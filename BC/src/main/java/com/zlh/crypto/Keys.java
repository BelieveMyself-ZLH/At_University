package com.zlh.crypto;

import com.zlh.constants.CryptoConstants;
import com.zlh.utils.Numeric;
import com.zlh.utils.Strings;
import org.bouncycastle.jce.ECNamedCurveTable;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.jce.spec.ECParameterSpec;

import java.math.BigInteger;
import java.security.*;
import java.util.Arrays;

/**
 * @Author: ZhouLinHu
 * @Description: Crypto key utilities
 * @Date: Created in 22:39 2019/4/17
 */
public final class Keys {
    public static final int PRIVATE_KEY_SIZE = 32;//私钥的大小32
    public static final int PUBLIC_KEY_SIZE = 64;//公钥的到校64
    public static final int ADDRESS_SIZE = 160;//地址大小
    public static final int ADDRESS_LENGTH_IN_HEX =ADDRESS_SIZE >> 2;
    static final int PUBLIC_KEY_LENGTH_IN_HEX = PUBLIC_KEY_SIZE << 1;
    public static final int PRIVATE_KEY_LENGTH_IN_HEX =PRIVATE_KEY_SIZE << 1;

    static {
        if (Security.getProvider(BouncyCastleProvider.PROVIDER_NAME) == null){
            Security.addProvider(new BouncyCastleProvider());
        }
    }

    private Keys(){}

    /**
     * Create a keypair using SECP-256k1 curve.
     *
     * <p>Private keypairs are encoded using PKCS8
     *
     * <p>Private keys are encoded using X.509
     */
    static KeyPair createSecp256k1KeyPair() throws NoSuchProviderException,
            NoSuchAlgorithmException, InvalidAlgorithmParameterException {

        // 注册 BC Provider
        Security.addProvider(new BouncyCastleProvider());
        // 创建椭圆曲线算法的密钥对生成器
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance(
                CryptoConstants.KEY_GEN_ALGORITHM,
                BouncyCastleProvider
                        .PROVIDER_NAME);
        // 椭圆曲线（EC）域参数设定
        ECParameterSpec ecSpec = ECNamedCurveTable.getParameterSpec(CryptoConstants.EC_PARAM_SPEC);
        keyPairGenerator.initialize(ecSpec, new SecureRandom());
        return keyPairGenerator.generateKeyPair();
    }

    public static ECKeyPair createEcKeyPair() throws InvalidAlgorithmParameterException,
            NoSuchAlgorithmException, NoSuchProviderException {
        KeyPair keyPair = createSecp256k1KeyPair();
        return ECKeyPair.create(keyPair);
    }

    public static String getAddress(ECKeyPair ecKeyPair) {
        return getAddress(ecKeyPair.getPublicKeyValue());
    }

    public static String getAddress(BigInteger publicKey) {
        return getAddress(
                Numeric.toHexStringWithPrefixZeroPadded(publicKey, PUBLIC_KEY_LENGTH_IN_HEX));
    }

    public static String getAddress(String publicKey) {
        String publicKeyNoPrefix = Numeric.cleanHexPrefix(publicKey);

        if (publicKeyNoPrefix.length() < PUBLIC_KEY_LENGTH_IN_HEX) {
            publicKeyNoPrefix = Strings.zeros(
                    PUBLIC_KEY_LENGTH_IN_HEX - publicKeyNoPrefix.length())
                    + publicKeyNoPrefix;
        }
        String hash = Hash.sha3(publicKeyNoPrefix);
        // right most 160 bits
        return Numeric.HEX_PREFIX + hash.substring(hash.length() - ADDRESS_LENGTH_IN_HEX);
    }

    public static byte[] getAddress(byte[] publicKey) {
        byte[] hash = Hash.sha3(publicKey);
        // right most 160 bits
        return Arrays.copyOfRange(hash, hash.length - 20, hash.length);
    }

    /**
     * 将 byte[] 公钥转成字符串
     * @param publicKey
     * @return
     */
    public static String publicKeyEncode(byte[] publicKey) {
        return Base58.encode(publicKey);
    }

    /**
     * 将字符串转成 byte[]
     * @param publicKey
     * @return
     */
    public static byte[] publicKeyDecode(String publicKey) {
        return Base58.decode(publicKey);
    }
}

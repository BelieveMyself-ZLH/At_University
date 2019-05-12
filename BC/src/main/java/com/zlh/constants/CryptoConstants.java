package com.zlh.constants;

/**
 * @Author: ZhouLinHu
 * @Description: 加密算法用到的常量
 * @Date: Created in 17:57 2019/5/7
 */
public interface CryptoConstants {
    /**
     * 椭圆曲线密钥生成算法，ECDSA
     */
    String KEY_GEN_ALGORITHM = "ECDSA";

    /**
     * 椭圆曲线（EC）域参数设定
     */
    String EC_PARAM_SPEC = "secp256k1";

    /**
     * 签名算法
     */
    String SIGN_ALGORITHM = "SHA1withECDSA";
}

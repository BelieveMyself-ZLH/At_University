package com.zlh.crypto;

import com.zlh.utils.Numeric;

/**
 * @Author: ZhouLinHu
 * @Description: 钱包文件工具类
 * @Date: Created in 18:49 2019/5/7
 */
public class WalletUtils {
    public static boolean isValidAddress(String input) {
        String cleanInput = Numeric.cleanHexPrefix(input);

        try {
            Numeric.toBigIntNoPrefix(cleanInput);
        } catch (NumberFormatException e) {
            return false;
        }

        return cleanInput.length() == (160>>2);
    }
}

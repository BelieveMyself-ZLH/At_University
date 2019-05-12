package com.zlh.exceptions;

/**
 * @Author: ZhouLinHu
 * @Description: Cipher exception wrapper 密码异常包装类
 * @Date: Created in 22:19 2019/4/16
 */
public class CipherException extends Exception {
    public CipherException(String message){
        super(message);
    }

    public CipherException(Throwable cause){
        super(cause);
    }

    public CipherException(String message, Throwable cause){
        super(message, cause);
    }
}

package com.zlh.exceptions;

/**
 * @Author: ZhouLinHu
 * @Description: encoding and decoding exception
 * @Date: Created in 11:12 2019/4/16
 */
public class MessageException extends RuntimeException {

    public MessageException(String message){
        super(message);
    }

    public MessageException(String message, Throwable cause){
        super(message, cause);
    }
}

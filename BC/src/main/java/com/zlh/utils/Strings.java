package com.zlh.utils;

import java.util.List;

/**
 * @Author: ZhouLinHu
 * @Description: String 工具类
 * @Date: Created in 16:04 2019/4/15
 */
public class Strings {

    private Strings() {}

    public static String toCsv(List<String> src) {
        // return src == null ? null : String.join(", ", src.toArray(new String[0]));
        return join(src, ", ");
    }

    public static String join(List<String> src, String delimiter) {
        return src == null ? null : String.join(delimiter, src.toArray(new String[0]));
    }

    public static String capitaliseFirstLetter(String string) {
        if (string == null || string.length() == 0) {
            return string;
        } else {
            return string.substring(0, 1).toUpperCase() + string.substring(1);
        }
    }

    public static String lowercaseFirstLetter(String string) {
        if (string == null || string.length() == 0) {
            return string;
        } else {
            return string.substring(0, 1).toLowerCase() + string.substring(1);
        }
    }

    //判断字符串是否为空
    public static boolean isEmpty(String s){
        return s == null || s.length() == 0;
    }
    //返回一个0字符串
    public static String zeros(int n){
        return repeat('0', n);
    }
    //将\0替换为‘0’
    public static String repeat(char value, int n){
        return new String(new char[n]).replace("\0", String.valueOf(value));
    }
}

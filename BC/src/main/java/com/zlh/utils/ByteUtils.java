package com.zlh.utils;

import org.apache.commons.lang3.ArrayUtils;

import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.stream.Stream;

/**
 * @Author: ZhouLinHu
 * @Description: 数组工具
 * @Date: Created in 16:33 2019/4/15
 */
public class ByteUtils {
    //两个byte[]数组相加
    public static byte[] add(byte[] data1, byte[] data2){
        byte[] result = new byte[data1.length + data2.length];
        System.arraycopy(data1,0, result,0, data1.length);
        System.arraycopy(data2,0, result,data1.length, data2.length);
        return result;
    }
    //将多个字节数组合并成一个字节数组
    public static byte[] merge(byte[]... bytes){
        Stream<Byte> stream = Stream.of();
        //Stream.concat方法拼接流
        for (byte[] b : bytes){
            stream = Stream.concat(stream, Arrays.stream(ArrayUtils.toObject(b)));
        }
        return ArrayUtils.toPrimitive(stream.toArray(Byte[]::new));
    }
    //long 类型转byte[]
    public static byte[] toBytes(long val){
        return ByteBuffer.allocate(Long.BYTES).putLong(val).array();
    }
}

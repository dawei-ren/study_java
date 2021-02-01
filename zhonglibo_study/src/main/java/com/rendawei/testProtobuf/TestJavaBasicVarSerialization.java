package com.rendawei.testProtobuf;

import java.lang.reflect.Array;
import java.util.Arrays;

public class TestJavaBasicVarSerialization {


    public static void main(String[] args) {
        int a = 11;
        byte[] bs = intToBytes(a);

        System.out.println(Arrays.toString(bs));

        int b = bytesToInt(bs);
        System.out.println(b);


    }
    /*
    *
    * int 序列化
    * */
    public static byte[] intToBytes(int value){
        byte[] byteArray = new byte[4];
        // 先写高位，把高位放到最后一个字节，也就是右移3个字节

        byteArray[3] = (byte)((value & 0xFF000000) >> 3*8);
        byteArray[2] = (byte)((value & 0x00FF0000) >> 2*8);
        byteArray[1] = (byte)((value & 0x0000FF00) >> 8);
        byteArray[0] = (byte)((value & 0x000000FF));

        return byteArray;
    }
    /*
    * int 反序列化
    *
    * */
    public static int bytesToInt(byte[] byteArray){
        return (byteArray[0] & 0xFF) |
                ((byteArray[1] << 8) & 0xFF00) |
                ((byteArray[2] << 2*8) & 0xFF0000) |
                ((byteArray[3] << 3*8) & 0xFF000000);
    }
}

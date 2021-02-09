package com.rendawei.baseConversion;

import com.sun.media.sound.MidiUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class decimalToHexadecimal {
  public static void main(String[] args) {
    int a = 48;
    String hex = Integer.toHexString(a);
    System.out.println(hex);


    System.out.println("将十进制 转化为二进制");
    int i = 16;
    System.out.println(Integer.toBinaryString(i));;

    System.out.println("10进制转化为byte");
    int b = 85;
    System.out.println((byte) b);


    System.out.println("将byte数组转化为 16进制字符串");
    List<Byte> arrList = Arrays.asList((byte) 0xff, (byte) 0xbf,(byte) 0xff, (byte) 0xbf);
    String hexString = byteArrayToHexString(arrList);
    System.out.println(hexString);


  }

  public static String byteArrayToHexString(Collection<Byte> binaryData) {
    StringBuilder sb = new StringBuilder();
    boolean space = false;
    for (byte b : binaryData) {
      sb.append(String.format("%02x", b));
      if (space) {
        sb.append(' ');
        space = false;
      } else {
        space = true;
      }
    }
    return sb.toString();
  }
}

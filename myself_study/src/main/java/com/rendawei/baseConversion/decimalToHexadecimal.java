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


    System.out.println("将16进制字符串转化为byte数组");
    String hexString1 = "DDDD";
    byte[] byteArray = hexToByteArray(hexString1);
    System.out.println(Arrays.toString(byteArray));
    for (byte byt : byteArray) {
      System.out.format("0x%02X ", byt);
    }


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


  public static byte[] hexToByteArray(String inHex){
    int hexlen = inHex.length();
    byte[] result;
    if (hexlen % 2 == 1){
      //奇数
      hexlen++;
      result = new byte[(hexlen/2)];
      inHex="0"+inHex;
    }else {
      //偶数
      result = new byte[(hexlen/2)];
    }
    int j=0;
    for (int i = 0; i < hexlen; i+=2){
      result[j]=hexToByte(inHex.substring(i,i+2));
      j++;
    }
    return result;
  }

  public static byte hexToByte(String inHex){
    return (byte)Integer.parseInt(inHex,16);
  }

}

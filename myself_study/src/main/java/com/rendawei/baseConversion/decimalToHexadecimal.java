package com.rendawei.baseConversion;

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


  }
}

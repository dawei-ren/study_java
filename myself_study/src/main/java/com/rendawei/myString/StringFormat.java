package com.rendawei.myString;

import java.util.Date;

public class StringFormat {
  public static void main(String[] args) {
//    byte[] byteArray = {(byte) 0x7c};
    byte[] byteArray = {(byte) 0xAA, (byte) 0x00, (byte) 0x4f};
//    byte[] byteArray = {(byte) 0x00, (byte) 0xAA, (byte) 0x4f};

    StringBuilder sb = new StringBuilder();

    for (byte b : byteArray) {
      System.out.println(Integer.toBinaryString(b & 0xff));
      System.out.println(String.format("%8s", Integer.toBinaryString(b & 0xff)));
      sb.append(String.format("%8s", Integer.toBinaryString(b & 0xff)).replace(" ", "0"));
    }

    System.out.println(sb.toString());


    System.out.println(String.format("%s, %s, %s", 1, "content", true));
  }
}

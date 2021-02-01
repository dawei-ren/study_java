package com.rendawei.baseConversion;

public class judgeBinarybit {

  public static void main(String[] args) {
    // 128 -  10000000, 第七位为0
    System.out.println(judgeBinaryHighOrder(128, 7));
    System.out.println(judgeBinaryHighOrder(128, 8));


    /*
    *   0xbf:   10111111
    *   64:      1000000
    *
    *
    *
    *
    * */

    int a = 0xbf;  // 10111111
    byte a_byte = (byte) a;
    System.out.println(a_byte & 64);

    int b = 0xff;  // 11111111
    byte b_byte = (byte) b;
    System.out.println(b_byte & 64);

    Byte c = new Byte((byte) 1);
    System.out.println(c.byteValue());
  }


  public static int judgeBinaryHighOrder(int n, int bit){
    // 判断一个十进制数的次高位是0还是1， bit为从右想做数要判断的哪一位
    int m = 1 << (bit - 1);
    if ((n & m) == 0){
      return 0;
    } else {
      return 1;
    }
  }
}

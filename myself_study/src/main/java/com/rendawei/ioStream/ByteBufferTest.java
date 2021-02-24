package com.rendawei.ioStream;

import java.nio.ByteBuffer;

public class ByteBufferTest {
  public static void main(String[] args) {
    ByteBuffer byteBuffer = ByteBuffer.allocate(100);

    for (int i = 0; i < 10; i++) {
      byteBuffer.put((byte) i);
    }

    // 切换成读模式
    byteBuffer.flip();

//    byteBuffer.mark();
    // 切换成写模式
    byteBuffer.compact();
    byte[] bytes = new byte[]{(byte) 0x55, (byte)0xaa};
    byteBuffer.put(bytes);
//    byteBuffer.reset();
    byteBuffer.flip();

    while (byteBuffer.hasRemaining()){
      byte each = byteBuffer.get();
      if ((each == (byte)3) && (byteBuffer.get() ==(byte)4)){
        System.out.println(11111);
      }else {
        System.out.println(each);
      }
      System.out.println(byteBuffer.hasRemaining());
    }





  }
}

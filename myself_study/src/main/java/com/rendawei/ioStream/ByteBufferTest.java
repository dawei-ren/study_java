package com.rendawei.ioStream;

import java.nio.ByteBuffer;

public class ByteBufferTest {
  public static void main(String[] args) {
    ByteBuffer byteBuffer = ByteBuffer.allocate(100);

    for (int i = 0; i < 10; i++) {
      byteBuffer.put((byte) i);
    }

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

package com.rendawei.ioStream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;

public class ByteBufferYudipuInspectTest {
  public static void main(String[] args) {


    try(FileInputStream inputStream = new FileInputStream("C:\\Users\\David\\Desktop\\2020-12-31-08-40-26.yudipu.raw")) {
      byte[] bytes = new byte[100];
      int count = inputStream.read(bytes);

      ByteBuffer byteBuffer = ByteBuffer.wrap(bytes, 0, count);



      while (byteBuffer.hasRemaining()){
        byte each = byteBuffer.get();
        if ((each == (byte)3) && (byteBuffer.get() ==(byte)4)){
          System.out.println(11111);
        }else {
          System.out.println(each);
        }
        System.out.println(byteBuffer.hasRemaining());
      }

    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }


//    ByteBuffer byteBuffer = ByteBuffer.allocate(100);
//
//    for (int i = 0; i < 10; i++) {
//      byteBuffer.put((byte) i);
//    }
//
//    byteBuffer.flip();



  }
}

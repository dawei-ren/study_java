package com.rendawei.myInternet.testUDP.yudipu;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;
import java.util.Arrays;

public class TestYudipuReceive2 {

  public static void main(String[] args) throws IOException {
    DatagramChannel channel = DatagramChannel.open();
    channel.socket().bind(new InetSocketAddress(15557));

    // 只接收特定地址发送过来的数据
    channel.connect(new InetSocketAddress("192.168.1.101", 909));

    while (true){
      ByteBuffer buf = ByteBuffer.allocate(3);
      channel.receive(buf);
      buf.flip();

      // 数据处理
      byte[] res_array = buf.array();
      System.out.println("bytes: " + Arrays.toString(res_array));
    }




    // 关闭
//    channel.close();
  }
}

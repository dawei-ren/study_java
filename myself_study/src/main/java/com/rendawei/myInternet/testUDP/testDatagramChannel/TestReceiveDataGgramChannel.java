package com.rendawei.myInternet.testUDP.testDatagramChannel;

import java.io.IOException;
import java.lang.reflect.Array;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.DatagramChannel;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class TestReceiveDataGgramChannel {

  public static void main(String[] args) throws IOException {
    DatagramChannel channel = DatagramChannel.open();
    channel.socket().bind(new InetSocketAddress(9999));

    // 只接收特定地址发送过来的数据
    channel.connect(new InetSocketAddress("localhost", 8888));

    while (true){
      ByteBuffer buf = ByteBuffer.allocate(3);
      buf.clear();
      channel.receive(buf);
      buf.flip();

      // 数据处理
      byte[] res_array = buf.array();
      CharBuffer res_str = StandardCharsets.UTF_8.decode(buf);
      System.out.println("bytes: " + Arrays.toString(res_array) + "   string: " + res_str);

      // 将处理完的数据发送给别人
      String str = "bbb";
      ByteBuffer buf2 = ByteBuffer.wrap(str.getBytes());
      channel.send(buf2, new InetSocketAddress("localhost", 8888));
    }




    // 关闭
//    channel.close();
  }
}

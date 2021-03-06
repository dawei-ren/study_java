package com.rendawei.myInternet.testUDP.testDatagramChannel;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Arrays;
import java.util.Scanner;

public class TestSend {
  public static void main(String[] args) {

    DatagramSocket ds = null;

    try {
      // 创建套接字, 8888指的是发送方的端口
      ds = new DatagramSocket(8888);

      while (true){
        // 打包数据
        Scanner sc = new Scanner(System.in);
        System.out.print("学生说：");
        String str = sc.next();
        System.out.println(Arrays.toString(str.getBytes()));
        byte[] bytes = str.getBytes();
        DatagramPacket dp = new DatagramPacket(bytes, bytes.length, InetAddress.getByName("localhost"), 9999);

        // 发送数据
        ds.send(dp);


        // 接收回复
        byte[] b = new byte[1024];
        DatagramPacket dp2 = new DatagramPacket(b, b.length);
        ds.receive(dp2);
        String str2 = new String(dp2.getData(), 0, dp2.getLength());
        System.out.println("老师：" + str2);
      }
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      // 关闭
      if (ds != null){
        ds.close();
      }
    }
  }
}

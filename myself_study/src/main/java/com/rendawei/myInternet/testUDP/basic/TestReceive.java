package com.rendawei.myInternet.testUDP.basic;

import java.io.IOException;
import java.net.*;
import java.util.Scanner;

public class TestReceive {
  public static void main(String[] args){

    DatagramSocket ds = null;

    try {
      // 创建一个套接字，并且指定一个端口9999
      ds = new DatagramSocket(9999);

      while (true){
        // 接收数据
        byte[] b = new byte[1024];
        DatagramPacket dp = new DatagramPacket(b, b.length);
        ds.receive(dp);

        // 处理数据
        String str = new String(dp.getData(), 0, dp.getLength());
        System.out.println("学生：" + str);

        if ("bye".equals(str)){
          System.out.println("老师下线。。。");
          break;
        }

        // 回复数据
        Scanner sc = new Scanner(System.in);
        System.out.print("老师说：");
        String str2 = sc.next();
        byte[] bytes = str2.getBytes();
        DatagramPacket dp2 = new DatagramPacket(bytes, bytes.length, InetAddress.getByName("localhost"), 8888);

        // 发送数据
        ds.send(dp2);
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

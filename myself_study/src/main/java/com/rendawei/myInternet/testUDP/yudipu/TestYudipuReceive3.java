package com.rendawei.myInternet.testUDP.yudipu;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class TestYudipuReceive3 {
  public static void main(String[] args){

    DatagramSocket ds = null;
    AtomicInteger total = new AtomicInteger();
    Thread shutdownThread = new Thread(()-> System.out.println(total.get()));
    Runtime.getRuntime().addShutdownHook(shutdownThread);

    try {
      // 创建一个套接字，并且指定一个端口9999
      ds = new DatagramSocket(908);


      while (true){
        // 接收数据
        byte[] b = new byte[1500];
        DatagramPacket dp = new DatagramPacket(b, b.length);
        ds.receive(dp);

        // 处理数据
        total.addAndGet(dp.getLength());
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

package com.rendawei.myInternet.testUDP.yudipu;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Scanner;

public class TestYudipuSend {
  public static void main(String[] args) {

    try (DatagramSocket ds = new DatagramSocket(15555)) {
      // 创建套接字, 8888指的是发送方的端口

      int[] dataList = {
          0x00, 0x80, 0xbf, 0xbd,
          0x55, 0xaa, 0x11, 0x11, 0xbf, 0xbd,0x00, 0x80, 0xbf, 0xbd,0x00, 0x80, 0xbf, 0xbd,0x00, 0x80, 0xbf, 0xbd,0x00, 0x80, 0xbf, 0xbd,};
      byte[] byteList = new byte[dataList.length];

      for (int i = 0; i < dataList.length; i++) {
        byteList[i] = (byte) dataList[i];
      }


      for (byte b : byteList) {
        byte[] bytes = {b};
        DatagramPacket dp = new DatagramPacket(bytes, bytes.length, InetAddress.getByName("192.168.6.104"), 908);
        // 发送数据
        ds.send(dp);
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}

package com.rendawei.myInternet.testTCP.basic;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
  public static void main(String[] args) throws IOException {
    ServerSocket ss = new ServerSocket(8888);
    Socket s = ss.accept();
    InputStream is = s.getInputStream();
    DataInputStream dis = new DataInputStream(is);
    String str = dis.readUTF();
    System.out.println("客户端对我说: " + str);


    // 服务器端向客户端反馈一句话
    s.shutdownInput();
    OutputStream os = s.getOutputStream();
    DataOutputStream dos = new DataOutputStream(os);
    String str2 = "服务器端接收到您的信息";
    dos.writeUTF(str2);
    dos.close();
    os.close();

    // 关闭流， 关闭socket
    dis.close();
    is.close();
    s.close();
    ss.close();
  }
}

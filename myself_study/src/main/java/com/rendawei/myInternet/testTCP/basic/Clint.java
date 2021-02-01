package com.rendawei.myInternet.testTCP.basic;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

public class Clint {
  public static void main(String[] args) throws IOException {

    // 创建套接字
    Socket s = new Socket(InetAddress.getByName("localhost"), 8888);

    // 我们能感受到的应用层向外发送数据用的是： 输出流
    OutputStream os = s.getOutputStream();
    // 向外发送一句话
    String str = "你好";
//    byte[] bytes = str.getBytes();
//    os.write(bytes);

    DataOutputStream dos = new DataOutputStream(os);
    dos.writeUTF(str);

    // 客户端要接受服务器端的反馈信息
    s.shutdownOutput();
    InputStream is = s.getInputStream();
    DataInputStream dis = new DataInputStream(is);
    System.out.println(dis.readUTF());

    is.close();
    dis.close();

    // 关闭流，关闭socket资源
    dos.close();
    os.close();
    s.close();


  }
}

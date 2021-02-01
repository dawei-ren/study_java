package com.rendawei.myInternet.testTCP.login;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
  public static void main(String[] args) throws IOException, ClassNotFoundException {
    ServerSocket ss = new ServerSocket(8888);
    while (true){
      Socket s = ss.accept();


      InputStream is = s.getInputStream();
      // 接收对象需要对象流
      ObjectInputStream ois = new ObjectInputStream(is);
      User user = (User) ois.readObject();
      System.out.println(user);


      // 服务器端向客户端反馈
      s.shutdownInput();

      boolean flag;
      if ("admin".equals(user.getName()) && "admin".equals(user.getPassword())){
        flag = true;
      } else {
        flag = false;
      }

      OutputStream os = s.getOutputStream();
      DataOutputStream dos = new DataOutputStream(os);
      dos.writeBoolean(flag);
      dos.close();
      os.close();

      // 关闭流， 关闭socket
      ois.close();
      is.close();
      s.close();
    }
//    ss.close();
  }
}

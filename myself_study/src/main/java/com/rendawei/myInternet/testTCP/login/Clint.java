package com.rendawei.myInternet.testTCP.login;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Clint {
  public static void main(String[] args) throws IOException {

    // 创建套接字
    Socket s = new Socket(InetAddress.getByName("localhost"), 8888);

    // 键盘录入账号和密码：
    Scanner sc = new Scanner(System.in);
    System.out.print("账号：");
    String name = sc.next();
    System.out.print("密码：");
    String password = sc.next();

    // 将上面的账号和密码封装成一个对象;
    User user = new User(name, password);

    // 将这个对象发送给服务器
    // 应用层向外发送数据用的是： 输出流
    OutputStream os = s.getOutputStream();
    // 如果想发送对象的话，需要在外面包一层对象流
    ObjectOutputStream oos = new ObjectOutputStream(os);

    oos.writeObject(user);


    // 客户端要接受服务器端的反馈信息
    s.shutdownOutput();
    InputStream is = s.getInputStream();
    DataInputStream dis = new DataInputStream(is);
    boolean flag = dis.readBoolean();
    if (flag){
      System.out.println("登录成功");
    } else {
      System.out.println("登录失败");
    }

    is.close();
    dis.close();

    // 关闭流，关闭socket资源

    os.close();
    oos.close();
    s.close();


  }
}

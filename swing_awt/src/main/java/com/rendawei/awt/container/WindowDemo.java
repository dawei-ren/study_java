package com.rendawei.awt.container;

import java.awt.*;

public class WindowDemo {

  public static void main(String[] args) {
    // 创建一个窗口
    Frame frame = new Frame("测试窗口");
    // 设置窗口位置
    frame.setLocation(100,100);

    // 设置窗口大小
    frame.setSize(500,300);
    // 设置窗口可见性
    frame.setVisible(true);
  }
}

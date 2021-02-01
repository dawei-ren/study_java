package com.rendawei.awt.container;

import java.awt.*;

public class PanelDemo {

  /*
  *   panel 其实就是一个窗口中的容器，用来存放按钮、文本框等东西
  *
  * */
  public static void main(String[] args) {
    // 创建一个window对象，因为panel以及其他容器，都不能独立存在，必须要依附于window存在
    Frame frame = new Frame("这里演示 Panel");
    // 创建一个panel对象
    Panel panel = new Panel();
    // 创建一个文本框和按钮，并把他们放入到Panel容器中
    panel.add(new TextField("测试文本"));
    panel.add(new Button("测试按钮"));
    // 把panel放入到window中
    frame.add(panel);
    // 设置window的位置和大小
    frame.setBounds(100,100,500,300);
    // 设置window可见
    frame.setVisible(true);
  }
}

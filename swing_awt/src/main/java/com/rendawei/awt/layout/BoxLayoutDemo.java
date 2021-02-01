package com.rendawei.awt.layout;

import javax.swing.*;
import java.awt.*;

public class BoxLayoutDemo {


  /*
  *
  *
  *   BoxLayout 布局管理器
  *     这是为了简化开发，Swing新引入的一个布局管理器
  *     可以在垂直和水平方向上摆放GUI组件
  *
  *
  *
  * */
  public static void main(String[] args) {


    // 创建一个窗口
    Frame frame = new Frame("演示BoxLayout");

    // 给窗口设置BoxLayout布局管理器，Y_AXIS 表示垂直布局
    frame.setLayout(new BoxLayout(frame, BoxLayout.Y_AXIS));
    // 给窗口添加按钮
    frame.add(new Button("按钮1"));
    frame.add(new Button("按钮2"));



    // 窗口最佳大小
    frame.pack();
    // 窗口可见
    frame.setVisible(true);

  }
}

package com.rendawei.awt.layout;

import java.awt.*;

public class BorderLayoutDemo {

  /*
  *
  *   根据东、西、南、北、中 的区域分布
  *   如果没有指定区域，则默认在中间区域
  *   如果某一区域添加多个容器，默认只显示最后一个容器
  *   如果不往某个区域放入组件，这个区域不会空白出来，而是被其他区域占用，这个区域就是空白区域
  *
  *
  * */

  public static void main(String[] args) {

    // 创建一个窗口
    Frame frame = new Frame("演示BorderLayout");

    // 对窗口添加盒子布局,并且设置水平间距和垂直间距
    frame.setLayout(new BorderLayout(20, 20));

    // 在窗口的指定区域添加组件


    frame.add(new Button("北侧按钮"), BorderLayout.NORTH);
    frame.add(new Button("南侧按钮"), BorderLayout.SOUTH);
    frame.add(new Button("东侧按钮"), BorderLayout.EAST);
    frame.add(new Button("西侧按钮"), BorderLayout.WEST);
    frame.add(new Button("中心按钮"), BorderLayout.CENTER);


    // 设置窗口最佳大小
    frame.pack();
    // 设置窗口可见
    frame.setVisible(true);
  }
}

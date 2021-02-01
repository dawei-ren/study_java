package com.rendawei.awt.layout;

import java.awt.*;

public class GridLayoutDemo {


  /*
  *
  *   GridLayout 表示网格布局
  *     每个网格所占用的区域相同
  *     当向网格中添加组件时，默认从左往右，从上往下依次添加到网格中，
  *
  *   练习一个计算器布局
  *     因为计算器布局中可以分为两部分，上面一部分为显示数字部分，下面部分为按钮部分
  *
  * */


  public static void main(String[] args) {

    // 创建一个窗口
    Frame frame = new Frame("计算器");

    // 创建一个Panel对象，作为上面显示数字部分，里面存放一个TextFile组件
    Panel p1 = new Panel();
    p1.add(new TextField(30));   // 30表示能显示30个数据
    // 将p1添加到窗口中的北边（窗口默认为Border布局）
    frame.add(p1, BorderLayout.NORTH);


    // 创建一个panel对象，作为下面的数字显示按钮区域，布局管理器为GridLayout（网格布局）
    Panel p2 = new Panel();
    p2.setLayout(new GridLayout(3, 5, 4, 4));  //参数分别为行、列、水平间距、垂直间距
    // 忘p2 中添加内容
    for (int i = 0; i < 10; i++) {
      p2.add(new Button(String.valueOf(i)));
    }

    p2.add(new Button("+"));
    p2.add(new Button("-"));
    p2.add(new Button("*"));
    p2.add(new Button("/"));
    p2.add(new Button("."));


    // 将p2 放入窗口中，默认放到中间区域
    frame.add(p2);




    // 设置窗口最佳大小
    frame.pack();
    // 设置窗口可见
    frame.setVisible(true);

  }
}

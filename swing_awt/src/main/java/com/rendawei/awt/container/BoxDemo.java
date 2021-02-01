package com.rendawei.awt.container;

import javax.swing.*;
import java.awt.*;

public class BoxDemo {

  /*
  *
  * Box 容器：
  *   因为Box布局管理器使用起来很多，所以Swing专门创建了一个Box容器，这个容器默认就使用的BoxLayout布局管理器
  *
  *
  * */

  public static void main(String[] args) {

    Frame frame = new Frame("Box容器");

    // 创建水平布局盒子容器，里面放两个按钮
    Box hBox = Box.createHorizontalBox();
    hBox.add(new Button("水平按钮1"));
    hBox.add(new Button("水平按钮2"));

    // 创建垂直布局盒子容器，里面放两个按钮
    Box vBox = Box.createVerticalBox();
    vBox.add(new Button("垂直按钮1"));
    vBox.add(new Button("垂直按钮2"));


    // 将水平盒子容器和垂直盒子容器添加到窗口中
    frame.add(hBox, BorderLayout.NORTH);
    frame.add(vBox);


    frame.pack();
    frame.setVisible(true);

  }
}

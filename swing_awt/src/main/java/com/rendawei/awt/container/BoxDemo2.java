package com.rendawei.awt.container;

import javax.swing.*;
import java.awt.*;

public class BoxDemo2 {

  /*
  * 测试分割容器
  *
  * */
  public static void main(String[] args) {

    Frame frame = new Frame();

    // 创建水平排列的Box容器
    Box hBox = Box.createHorizontalBox();
    hBox.add(new Button("水平按钮1"));
    hBox.add(Box.createHorizontalGlue()); // 该分割在两个方向上都可以拉伸
    hBox.add(new Button("水平按钮2"));
    hBox.add(Box.createHorizontalStrut(30)); // 该分割固定宽度
    hBox.add(new Button("水平按钮3"));

    // 创建垂直排列的Box容器
    Box vBox = Box.createVerticalBox();
    // 添加按钮
    vBox.add(new Button("垂直按钮1"));
    vBox.add(Box.createVerticalGlue()); // 该分割在两个方向上都可以拉伸
    vBox.add(new Button("垂直按钮2"));
    vBox.add(Box.createVerticalStrut(30));  // 该分割固定高度
    vBox.add(new Button("垂直按钮3"));

    // 将水平容器添加到窗口北侧
    frame.add(hBox, BorderLayout.NORTH);
    frame.add(vBox);


    frame.pack();
    frame.setVisible(true);

  }
}

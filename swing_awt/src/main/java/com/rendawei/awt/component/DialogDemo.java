package com.rendawei.awt.component;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DialogDemo {

  /*
  *
  * 对话框
  *
  *     模式对话框显示之后无法对父窗口进行操作
  *     非模式对话框显示之后对父窗口没有影响，父窗口可以对边操作
  * */
  public static void main(String[] args) {

    Frame frame = new Frame("演示对话框");


    // 创建两个对话框，一个模式对话框，一个非模式对话框, 需要传入父容器，标题，是否时模式退化狂
    final Dialog d1 = new Dialog(frame, "模式对话框", true);
    final Dialog d2 = new Dialog(frame, "模式对话框", false);

    // 给对话框添加内容
    Box vBox = Box.createVerticalBox();
    vBox.add(new TextField(20));
    vBox.add(new Button("确认"));

    d1.add(vBox);

    // 设置对话框的位置以及大小, x轴位置，y轴位置，宽度、长度
    d1.setBounds(20,30,300,200);
    d2.setBounds(20,30,300,200);

    // 创建两个按钮
    Button b1 = new Button("打开模式对话框");
    Button b2 = new Button("打开非模式对话框");

    // 给两个按钮添加点击后的行为
    b1.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        d1.setVisible(true);
      }
    });

    b2.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        d2.setVisible(true);
      }
    });

    // 将按钮添加进窗口
    frame.add(b1, BorderLayout.NORTH);
    frame.add(b2);


    frame.pack();
    frame.setVisible(true);

  }
}

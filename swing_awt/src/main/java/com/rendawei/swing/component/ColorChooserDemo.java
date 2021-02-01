package com.rendawei.swing.component;

/*
* 颜色选择器
*
*
* */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ColorChooserDemo {
  JFrame jFrame = new JFrame("颜色选择器");

  // 声明一个文本域
  JTextArea jTextArea = new JTextArea("我爱中华", 6,30);

  // 声明一个按钮
  JButton jButton = new JButton("修改文本框背景颜色");




  public void init(){

    // 绑定按钮点击事件
    jButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        // 弹出一个颜色选择器, 传入父组件、标题、默认颜色
        Color result = JColorChooser.showDialog(jFrame, "颜色选择器", Color.white);
        // 修改文本框背景颜色
        jTextArea.setBackground(result);
      }
    });

    // 将文本域组件和按钮组件添加到窗口
    jFrame.add(jTextArea);
    jFrame.add(jButton, BorderLayout.SOUTH);

    jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    jFrame.pack();
    jFrame.setVisible(true);
  }

  public static void main(String[] args) {
    new ColorChooserDemo().init();
  }
}

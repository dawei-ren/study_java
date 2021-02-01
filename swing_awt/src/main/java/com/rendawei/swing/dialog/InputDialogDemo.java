package com.rendawei.swing.dialog;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



/*
*
*   输入对话框
*
*
* */

public class InputDialogDemo {


  JFrame jFrame = new JFrame("测试输入对话框");


  JTextArea jTextArea = new JTextArea(6,30);
  JButton btn1 = new JButton("弹出输入对话框");



  public void init(){
    // 绑定按钮点击事件
    btn1.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        String res = JOptionPane.showInputDialog(jFrame, "请填写电话号码", "输入对话框", JOptionPane.INFORMATION_MESSAGE);
        jTextArea.append(res + "\n");
      }
    });

    Box vBox = Box.createVerticalBox();
    vBox.add(btn1);



    jFrame.add(jTextArea);
    jFrame.add(vBox, BorderLayout.SOUTH);

    jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    jFrame.pack();
    jFrame.setVisible(true);


  }

  public static void main(String[] args) {
    new InputDialogDemo().init();
  }
}

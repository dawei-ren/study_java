package com.rendawei.swing.dialog;

/*
* 确认对话框
*
*
* */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConfirmDialogDemo {
  JFrame jFrame = new JFrame("测试确认对话框");
  JTextArea jTextArea = new JTextArea(6, 30);
  JButton btn = new JButton("弹出默认确认对话框");



  public void init(){
    btn.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        // DEFAULT_OPTION 可以根据不同的类型设置不同的确认对话框，返回的结果就是点击的结果
        int res = JOptionPane.showConfirmDialog(jFrame, jTextArea.getText(), "确认对话框", JOptionPane.DEFAULT_OPTION);
        if (res == JOptionPane.YES_OPTION){
          jTextArea.append("用户点击了 是 按钮");
        } else if (res == JOptionPane.NO_OPTION){
          jTextArea.append("用户点击了 否 按钮");
        } else if (res == JOptionPane.CANCEL_OPTION){
          jTextArea.append("用户点击了 取消 按钮");
        }
      }
    });

    Box vBox = Box.createVerticalBox();
    vBox.add(btn);


    jFrame.add(jTextArea);
    jFrame.add(vBox, BorderLayout.SOUTH);



    jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    jFrame.pack();
    jFrame.setVisible(true);
  }

  public static void main(String[] args) {
    new ConfirmDialogDemo().init();
  }
}

package com.rendawei.swing.dialog;

/*
* 消息对话框
*   可以自定义图标
*
*
* */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MessageDialogDemo {

  JFrame jFrame = new JFrame("测试消息对话框");
  JTextArea jTextArea = new JTextArea(6, 30);

  JButton btnError = new JButton(new AbstractAction("弹出错误消息对话框") {
    private static final long serialVersionUID = -6928555309598570370L;

    @Override
    public void actionPerformed(ActionEvent e) {
      // 获取文本域中的内容
      String text = jTextArea.getText();
      // 弹出消息对话框, 需要输入父组件，内容，标题，类型
      JOptionPane.showMessageDialog(jFrame, text, "消息对话框", JOptionPane.ERROR_MESSAGE);
    }
  });

  JButton b2 = new JButton(new AbstractAction("弹出基本信息消息框") {
    @Override
    public void actionPerformed(ActionEvent e) {
      JOptionPane.showMessageDialog(jFrame, jTextArea.getText(), "消息对话框", JOptionPane.INFORMATION_MESSAGE);
    }
  });

  JButton b3 = new JButton("弹出警告信息消息框");

  JButton b4 = new JButton("弹出问题消息对话框");
  JButton b5 = new JButton("基本消息对话框");




  public void init(){
    // 使用lambda 表达式简写
    b3.addActionListener(e -> JOptionPane.showMessageDialog(jFrame, jTextArea.getText(), "消息对话框", JOptionPane.WARNING_MESSAGE));

    // 使用匿名内部类
    b4.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        JOptionPane.showMessageDialog(jFrame, jTextArea.getText(), "消息对话框", JOptionPane.QUESTION_MESSAGE);
      }
    });
    b5.addActionListener(e -> JOptionPane.showMessageDialog(jFrame, jTextArea.getText(), "消息对话框", JOptionPane.PLAIN_MESSAGE));


    jFrame.add(jTextArea);

    Box vBox = Box.createVerticalBox();
    vBox.add(btnError);
    vBox.add(b2);
    vBox.add(b3);
    vBox.add(b4);
    vBox.add(b5);
    jFrame.add(vBox, BorderLayout.SOUTH);

    jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    jFrame.pack();
    jFrame.setVisible(true);

  }

  public static void main(String[] args) {
    new MessageDialogDemo().init();
  }


}

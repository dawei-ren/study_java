package com.rendawei.swing.dialog;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OptionDialogDemo {

  JFrame jFrame = new JFrame("测试选择对话框");
  JTextArea jTextArea = new JTextArea(6, 30);
  JButton btn = new JButton("弹出选择对话框");

  String[] taotaoList = {"特大号", "大号", "中号", "小号"};


  public void init(){

    // 定义点击事件
    btn.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        int res = JOptionPane.showOptionDialog(
            jFrame,                             // 父组件
            "请选择大小:",                // 提示信息
            "选项对话框",                    // 标题
            JOptionPane.DEFAULT_OPTION,         // 选项类型
            JOptionPane.INFORMATION_MESSAGE,    // 对话框类型
            null,                          // 图标
            taotaoList,                         // 选项
            "中号"                     // 默认选项
        );

        jTextArea.setText("用户选择了：" + taotaoList[res]);
      }
    });


    // 组装组件
    Box vbox = Box.createVerticalBox();
    vbox.add(btn);

    jFrame.add(jTextArea);
    jFrame.add(vbox, BorderLayout.SOUTH);

    jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    jFrame.pack();
    jFrame.setVisible(true);
  }

  public static void main(String[] args) {
    new OptionDialogDemo().init();
  }
}

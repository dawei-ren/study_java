package com.rendawei.swing.component;

import javax.swing.*;

public class JFrameDemo {

  JFrame jFrame = new JFrame("测试窗口");


  public void init(){

    // 设置窗口最佳大小
    jFrame.pack();
    // 设置窗口固定大小
    jFrame.setBounds(400, 400, 400, 400);
    // 设置窗口不可以随意改变大小,也不可以最大化
    jFrame.setResizable(false);
    // 设置窗口点击X关闭
    jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    // 设置窗口显示
    jFrame.setVisible(true);
  }

  public static void main(String[] args) {
    new JFrameDemo().init();
  }
}

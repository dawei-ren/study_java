package com.rendawei.awt.listener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class EventDemo1 {

  /*
  * 测试事件处理
  *
  * */


  Frame frame = new Frame("测试点击事件");
  TextField textField = new TextField(30);
  Button ok = new Button("确定");

  // 创建一个文本框
  TextField tf = new TextField(30);
  // 创建一个下拉选择框
  Choice names = new Choice();




  public void init(){

    // 点击监听器（使用普通方式添加）
    MyListener myListener = new MyListener();
    // 注册监听
    ok.addActionListener(myListener);

    // 组装视图
    Box hBox1 = Box.createHorizontalBox();
    hBox1.add(textField);
    hBox1.add(ok);
    frame.add(hBox1, BorderLayout.NORTH);

    // 给下拉选择框添加内容
    names.add("柳岩");
    names.add("舒淇");
    names.add("闫妮");

    // 给文本框变化注册监听器（使用内部类的方式一次性添加）
    tf.addTextListener(new TextListener() {
      @Override
      public void textValueChanged(TextEvent e) {
        System.out.println("当前文本框中的内容为：" + tf.getText());
      }
    });
    // 给下拉选择框选择事件注册监听器
    names.addItemListener(new ItemListener() {
      @Override
      public void itemStateChanged(ItemEvent e) {
        System.out.println("当前选中的女友是：" + e.getItem());
      }
    });
    // 给窗口组件添加事件注册监听器
    frame.addContainerListener(new ContainerAdapter() {
      @Override
      public void componentAdded(ContainerEvent e) {
        System.out.println("frame中添加了：" + e.getChild());
      }
    });


    // 创建一个水平盒子，用来放名称下拉选择框和文本框
    Box hBox = Box.createHorizontalBox();
    hBox.add(names);
    hBox.add(tf);
    // 将水平盒子添加到窗口南部
    frame.add(hBox);




    frame.pack();
    // 给窗口操作添加事件
    frame.addWindowListener(new WindowAdapter() {
      // 点击X关闭添加事件
      @Override
      public void windowClosing(WindowEvent e) {
        System.exit(0);
      }
    });
    frame.setVisible(true);

  }

  public static void main(String[] args) {
    new EventDemo1().init();
  }


  private class MyListener implements ActionListener{
    /*
    *   自定义监听器类来执行点击动作
    *
    * */
    @Override
    public void actionPerformed(ActionEvent e) {
      // 给textField 显示文字
      textField.setText("Hello World");
    }
  }
}

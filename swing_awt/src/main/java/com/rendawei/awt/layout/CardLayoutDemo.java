package com.rendawei.awt.layout;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CardLayoutDemo {


  /*
  *
  *   Card Layout 卡片布局
  *
  * */
  public static void main(String[] args) {

    // 创建一个窗口
    Frame frame = new Frame("展示 CardLayout");


    // 创建一个Panel用来存储多张卡片
    final Panel p1 = new Panel();
    // 给p1 设置卡片布局
    final CardLayout cardLayout = new CardLayout();
    p1.setLayout(cardLayout);

    // 向p1中添加多张卡片
    String[] cards = {"第一张","第二张","第三张","第四张","第五张"};

    for (String card : cards) {
      p1.add(card, new Button(card));
    }

    // 把p1 放到窗口的中间区域,  frame默认为block布局，并且不指定区域的话默认就是中间区域
    frame.add(p1);


    // 创建另外一个panel 用来存放多个按钮
    Panel p2 = new Panel();

    // 创建5个按钮组件
    Button b1 = new Button("上一张");
    Button b2 = new Button("下一张");
    Button b3 = new Button("第一张");
    Button b4 = new Button("第三张");
    Button b5 = new Button("最后一张");

    // 创建一个事件监听器，监听按钮的点击动作
    ActionListener actionListener = new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        String actionCmd = e.getActionCommand();  // 获取当前被点击按钮的文字字符串
        if ("上一张".equals(actionCmd)) {
          cardLayout.previous(p1);
        } else if ("下一张".equals(actionCmd)) {
          cardLayout.next(p1);
        } else if ("第一张".equals(actionCmd)) {
          cardLayout.first(p1);
        } else if ("第三张".equals(actionCmd)) {
          cardLayout.show(p1, "第三张");
        } else if ("最后一张".equals(actionCmd)) {
          cardLayout.last(p1);
        }
      }
    };

    // 将按钮和事件监听器绑定
    b1.addActionListener(actionListener);
    b2.addActionListener(actionListener);
    b3.addActionListener(actionListener);
    b4.addActionListener(actionListener);
    b5.addActionListener(actionListener);

    // 把按钮添加到容器p2中
    p2.add(b1);
    p2.add(b2);
    p2.add(b3);
    p2.add(b4);
    p2.add(b5);

    // 把p2 放到窗口的南边区域
    frame.add(p2, BorderLayout.SOUTH);







    // 窗口最佳布局
    frame.pack();
    // 窗口可见
    frame.setVisible(true);
  }
}

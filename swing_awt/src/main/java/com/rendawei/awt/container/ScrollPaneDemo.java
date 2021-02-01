package com.rendawei.awt.container;

import java.awt.*;

public class ScrollPaneDemo {
  public static void main(String[] args) {
    // 创建一个window
    Frame frame = new Frame("这里演示ScrollPane");
    // 创建一个ScrollPane, 默认里面的文本放不下才会显示滚动条，ScrollPane.SCROLLBARS_ALWAYS ，表示一直显示滚动条
    ScrollPane scrollPane = new ScrollPane(ScrollPane.SCROLLBARS_ALWAYS);
    // 在ScrollPane中添加内容
    scrollPane.add(new TextField("这里是测试文本"));
    scrollPane.add(new Button("测试按钮"));

    // 把ScrollPane添加进窗口中
    frame.add(scrollPane);

    // 设置窗口位置和大小
    frame.setBounds(100, 100, 500, 300);
    // 设置窗口可见
    frame.setVisible(true);
  }
}

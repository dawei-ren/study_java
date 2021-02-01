package com.rendawei.awt.layout;

import java.awt.*;

public class FlowLayoutDemo {

  /*
  *
  *   FlowLayout 表示流式布局，就是从左往右排列，遇到边界自动流到下一行
  *
  * */

  public static void main(String[] args) {

    // 创建一个窗口
    Frame frame = new Frame("这里测试Layout");

    // 设置窗口布局为流式布局, FlowLayout表示流式布局，LEFT表示左对齐，后面是水平间距和垂直间距
    frame.setLayout(new FlowLayout(FlowLayout.LEFT, 20,20));

    // 给窗口中添加多个俺就
    for (int i = 0; i < 100; i++) {
      frame.add(new Button("测试按钮"+ i));
    }

    // 设置窗口为最佳大小
    frame.pack();
    // 设置窗口可见
    frame.setVisible(true);
  }
}

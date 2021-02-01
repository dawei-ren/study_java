package com.rendawei.awt.draw;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class SimpleDraw {


  Frame frame = new Frame("测试绘图");

  // 方便判断画的是哪一种图形
  private final String RECT_SHAPE = "rect";
  private final String OVAL_SHAPE = "oval";

  // 创建按钮
  Button btnRect = new Button("绘制矩形");
  Button btnOval = new Button("绘制椭圆");

  // 定义一个变量，记录当前要回值的椭圆还是矩形
  private String shape = "";

  // 1. 自定义画布类，继承Canvas类， 重写paint方法完成画图
  private class MyCanvas extends Canvas{
    @Override
    public void paint(Graphics g) {
      // 绘制不同的图形
      if (shape.equals(RECT_SHAPE)){
        // 绘制矩形
        g.setColor(Color.BLACK);
        g.drawRect(100,100,150,100);
      } else if (shape.equals(OVAL_SHAPE)){
        // 绘制椭圆
        g.setColor(Color.RED);
        g.drawOval(100,100,150,100);
      }
    }
  }

  // 创建自定义画布对象
  MyCanvas myCanvas = new MyCanvas();



  public void init(){
    // 自定义点击事件
    ActionListener actionListener = new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        // 如果点击了绘制矩形按钮
        if (e.getActionCommand().equals("绘制矩形")){
          // 将标记改为RECT_SHAPE
          shape = RECT_SHAPE;
          myCanvas.repaint();  // 重新画图
        } else if (e.getActionCommand().equals("绘制椭圆")){
          shape = OVAL_SHAPE;
          myCanvas.repaint();
        }
      }
    };
    // 给按钮绑定点击事件监听器
    btnRect.addActionListener(actionListener);
    btnOval.addActionListener(actionListener);

    // 创建一个panel 承载按钮, 然后将panel放入窗口的南部区域
    Panel panel = new Panel();
    panel.add(btnRect);
    panel.add(btnOval);

    frame.add(panel, BorderLayout.SOUTH);


    // 设置画布大小，然后将画布放入窗口
    myCanvas.setPreferredSize(new Dimension(300,300));
    frame.add(myCanvas);



    frame.pack();
    frame.addWindowListener(new WindowAdapter() {
      @Override
      public void windowClosing(WindowEvent e) {
        System.exit(0);
      }
    });
    frame.setVisible(true);
  }

  public static void main(String[] args) {
    new SimpleDraw().init();
  }
}

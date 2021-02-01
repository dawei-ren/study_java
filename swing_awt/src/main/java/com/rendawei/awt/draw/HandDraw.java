package com.rendawei.awt.draw;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;

public class HandDraw {

  /*
  *
  * 手绘联系
  * */
  Frame frame = new Frame("手绘练习");


  // 定义画图区的宽高
  private final int AREA_WIDTH = 500;
  private final int AREA_HEIGHT = 400;

  // 定义右键菜单，用于自定义画笔颜色
  PopupMenu rightMenu = new PopupMenu();
  MenuItem redItem = new MenuItem("红色");
  MenuItem greenItem = new MenuItem("绿色");
  MenuItem blueItem = new MenuItem("蓝色");

  // 定义一个变量，用来记录当前画笔的颜色
  private Color forceColor = Color.BLACK;
  // 创建一个BufferedImage位图对象，定义宽、高、颜色类型(也就是缓冲区，)
  BufferedImage image = new BufferedImage(AREA_WIDTH, AREA_HEIGHT, BufferedImage.TYPE_INT_BGR);
  // 通过位图，获取关联的Graphics对象
  Graphics graphics = image.getGraphics();

  // 自定义一个类，继承Canvas 充当画布
  private class MyCanvas extends Canvas{
    @Override
    public void paint(Graphics g) {
      // 通过Image画图，传入需要的image、x坐标、y坐标、观察者
      g.drawImage(image, 0, 0, null);
    }
  }

  // 定义一个画布
  MyCanvas myCanvas = new MyCanvas();

  // 定义变量，记录鼠标上一次所处的位置
  private int preX = -1;
  private int preY = -1;

  public void init(){

    // 自定义事件监听器，保证右键菜单点击之后产生更换画笔颜色
    ActionListener actionListener = new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        String actionCommand = e.getActionCommand();
        if (actionCommand.equals("红色")) {
          forceColor = Color.RED;
        } else if (actionCommand.equals("绿色")) {
          forceColor = Color.GREEN;
        } else if (actionCommand.equals("蓝色")) {
          forceColor = Color.BLUE;
        }
      }
    };

    // 给按钮绑定事件监听器
    redItem.addActionListener(actionListener);
    greenItem.addActionListener(actionListener);
    blueItem.addActionListener(actionListener);

    // 将菜单项组装进右键菜单
    rightMenu.add(redItem);
    rightMenu.add(greenItem);
    rightMenu.add(blueItem);

    // 将右键菜单设置给画布
    myCanvas.add(rightMenu);

    // 虽然将右键菜单设置给画布了，但是还要绑定鼠标右键这个操作才出现菜单
    myCanvas.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseReleased(MouseEvent e) {  // 鼠标抬起时调用
        // 如果为true，表明是鼠标右键操作
        boolean popupTrigger = e.isPopupTrigger();
        if (popupTrigger) {
          // 显示右键菜单（在myCanvas组件显示，显示坐标为鼠标的x轴和y轴）
          rightMenu.show(myCanvas, e.getX(), e.getY());
        }

        // 鼠标抬起时，顺便将上一次鼠标位置重置
        preX = -1;
        preY = -1;

      }
    });


    // 设置位图的背景为白色, 位置，以及宽、高
    graphics.setColor(Color.WHITE);
    graphics.fillRect(0, 0, AREA_WIDTH, AREA_HEIGHT);

    // 通过监听鼠标的移动完成绘图
    myCanvas.addMouseMotionListener(new MouseMotionAdapter() {

      // 该方法，当鼠标左键按下，并进行拖动时，会被调用
      @Override
      public void mouseDragged(MouseEvent e) {
        // 默认这两个值为-1，当拖动鼠标时，就会变话，才开始画图
        if (preX > 0 && preY > 0){
          // 设置画笔颜色
          graphics.setColor(forceColor);
          // 画图，既然时拖动画图，必然一条线有起始的坐标和结束坐标（这个时在位图中画图，还不能显示在界面上）
          graphics.drawLine(preX, preY, e.getX(), e.getY());
        }
        // 修正起始坐标
        preX = e.getX();
        preY = e.getY();

        // 重绘组件(前面的步骤是在位图缓冲区域画图，调用repaint，才会调用继承自Canvas重写的paint方法，来在画布上展示图像)
        myCanvas.repaint();
      }
    });

    // 设置画布尺寸， 并添加到窗口
    myCanvas.setPreferredSize(new Dimension(AREA_WIDTH, AREA_HEIGHT));
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
    new HandDraw().init();
  }
}

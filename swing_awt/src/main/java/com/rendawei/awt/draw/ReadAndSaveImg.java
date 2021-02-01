package com.rendawei.awt.draw;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ReadAndSaveImg {

  Frame frame = new Frame("图片查看器");

  MenuBar menuBar = new MenuBar();
  Menu menu = new Menu("文件");
  MenuItem open = new MenuItem("打开");
  MenuItem save = new MenuItem("保存");

  // 声明BufferImage对象，记录本地存到内存中的图片
  BufferedImage bufferedImage;

  // 创建画布用来展示图片
  private class MyCanvas extends Canvas{
    @Override
    public void paint(Graphics g) {
      g.drawImage(bufferedImage, 0, 0, null);
    }
  }
  MyCanvas myCanvas = new MyCanvas();









  public void init(){
    // 给按钮绑定事件监听

    ActionListener actionListener = new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("打开")){
          // 打开一个对话框，可以选择图片
          FileDialog fileDialog = new FileDialog(frame, "打开图片", FileDialog.LOAD);
          // 显示此对话框
          fileDialog.setVisible(true);

          // 获取用户选择的图片路径以及名称
          String dir = fileDialog.getDirectory();
          String name = fileDialog.getFile();
          System.out.println(dir+name);

          // 让画布显示图片
          try {
            // 让图片缓存读取图片
            bufferedImage = ImageIO.read(new File(dir, name));
            // 展示图片缓存到画布
            myCanvas.repaint();
          } catch (IOException ioException) {
            ioException.printStackTrace();
          }

        } else if (e.getActionCommand().equals("保存")){
          // 打开一个对话框，可以选择保存路径
          FileDialog fileDialog = new FileDialog(frame, "保存图片", FileDialog.SAVE);
          // 显示此对话框
          fileDialog.setVisible(true);

          // 获取用户选择的路径以及名称
          String dir = fileDialog.getDirectory();
          String name = fileDialog.getFile();

          try {
            // 生成一个新的图片
            ImageIO.write(bufferedImage, "JPEG", new File(dir, name));
          } catch (IOException ioException) {
            ioException.printStackTrace();
          }


        }
      }
    };
    // 给按钮绑定监听器
    open.addActionListener(actionListener);
    save.addActionListener(actionListener);

    // 组装菜单, 并设置到窗口
    menu.add(open);
    menu.add(save);
    menuBar.add(menu);
    frame.setMenuBar(menuBar);

    // 将画布放到窗口中
    frame.add(myCanvas);



    frame.setBounds(200, 200, 740, 508);
    frame.setVisible(true);

    frame.addWindowListener(new WindowAdapter() {
      @Override
      public void windowClosing(WindowEvent e) {
        System.exit(0);
      }
    });

  }

  public static void main(String[] args) {
    new ReadAndSaveImg().init();
  }

}

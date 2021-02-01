package com.rendawei.swing.component;


/*
*    文件选择对话框
*
*
* */

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class FileChooserDemo {

  JFrame jFrame = new JFrame("文件选择器");

  JMenuBar jMenuBar = new JMenuBar();
  JMenu jMenu = new JMenu("文件");
  JMenuItem open = new JMenuItem("打开");
  JMenuItem save = new JMenuItem("另存为");

  // 用来防止图片流
  BufferedImage bufferedImage;

  // 定义一个画布类， 用来将选择的图片绘制到画布上（Swing 提供的组件，都使用了图像缓冲技术）
  private class MyPanel extends JPanel{
    @Override
    public void paint(Graphics g) {
      // 把图像流绘制到画布上即可
      g.drawImage(bufferedImage, 0, 0, this.getWidth(),this.getHeight(),null);
    }
  }
  // 实例化画布
  MyPanel drawArea = new MyPanel();




  public void init(){
    // 定义点击事件
    ActionListener actionListener = new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();
        if (cmd.equals("打开")){
          // 实例化一个文件选择器，默认为当前路径
          JFileChooser jFileChooser = new JFileChooser(".\\swing_awt\\src\\main\\java\\com\\rendawei\\swing\\img");
          // 显示文件选择器
          jFileChooser.showOpenDialog(jFrame);
          // 获取用户选择的文件
          File file = jFileChooser.getSelectedFile();
          // 进行显示
          try {
            bufferedImage = ImageIO.read(file);
            drawArea.repaint();
          } catch (IOException ioException) {
            ioException.printStackTrace();
          }
        } else if (cmd.equals("另存为")){
          // 实例化一个文件选择器，默认为当前路径
          JFileChooser jFileChooser = new JFileChooser(".\\swing_awt\\src\\main\\java\\com\\rendawei\\swing\\img");
          // 显示保存文件选择器
          jFileChooser.showSaveDialog(jFrame);
          // 获取用户选择的保存文件路径
          File file = jFileChooser.getSelectedFile();

          try {
            ImageIO.write(bufferedImage,"jpeg", file);
          } catch (IOException ioException) {
            ioException.printStackTrace();
          }
        }
      }
    };
    // 绑定点击事件到按钮
    open.addActionListener(actionListener);
    save.addActionListener(actionListener);


    // 组装下拉菜单
    jMenu.add(open);
    jMenu.add(save);
    jMenuBar.add(jMenu);
    jFrame.setJMenuBar(jMenuBar);

    // 设置画布大小
    drawArea.setPreferredSize(new Dimension(300, 400));
    // 将画布添加进窗口
    jFrame.add(drawArea);

    jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    jFrame.pack();
    jFrame.setVisible(true);
  }

  public static void main(String[] args) {
    new FileChooserDemo().init();
  }
}

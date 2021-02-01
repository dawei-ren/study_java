package com.rendawei.awt.component;

import java.awt.*;
import java.awt.event.*;

public class MenuDemo {
  Frame frame = new Frame("测试menu菜单");

  // 创建菜单条
  MenuBar menuBar = new MenuBar();

  // 创建菜单组件
  Menu fileMenu = new Menu("文件");
  Menu editMenu = new Menu("编辑");
  Menu formatMenu = new Menu("格式");

  // 创建菜单项组件
  MenuItem autoItem = new MenuItem("自动换行");
  MenuItem copyItem = new MenuItem("复制");
  MenuItem pasteItem = new MenuItem("粘贴");
  // 关联快捷键 Ctrl+Shift+Q
  MenuItem commentItem = new MenuItem("注释", new MenuShortcut(KeyEvent.VK_Q, true));
  MenuItem cancelCommentItem = new MenuItem("取消注释");

  TextArea textArea = new TextArea(6,40);

  // 创建右键菜单
  PopupMenu popupMenu = new PopupMenu();
  // 床架右键菜单选项
  MenuItem saveItem = new MenuItem("保存");
  MenuItem comment = new MenuItem("注释");
  MenuItem cancelComment = new MenuItem("取消注释");
  MenuItem copy = new MenuItem("复制");

  Panel panel = new Panel();





  public void init(){

    // 自定义点击事件监听器，当点击，给下面文本域中打印操作
    ActionListener actionListener = new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        // 每次出发，文本域中追加字符串
        textArea.append(e.getActionCommand() + "\n");
      }
    };
    // 将事件监听器绑定给按钮
    autoItem.addActionListener(actionListener);
    copyItem.addActionListener(actionListener);
    pasteItem.addActionListener(actionListener);
    commentItem.addActionListener(actionListener);
    cancelCommentItem.addActionListener(actionListener);
    saveItem.addActionListener(actionListener);
    comment.addActionListener(actionListener);
    cancelComment.addActionListener(actionListener);
    copy.addActionListener(actionListener);


    // 将注释和取消注释菜单项添加到格式菜单中
    formatMenu.add(commentItem);
    formatMenu.add(cancelCommentItem);

    // 组装编辑菜单
    editMenu.add(autoItem);
    editMenu.add(copyItem);
    editMenu.add(pasteItem);
    editMenu.add(formatMenu);

    // 组装menu bar
    menuBar.add(fileMenu);
    menuBar.add(editMenu);

    // 把菜单条放入窗口中
    frame.setMenuBar(menuBar);
    // 把文本框放入窗口中
    frame.add(textArea);


    // 组装右键菜单
    popupMenu.add(saveItem);
    popupMenu.add(copy);
    popupMenu.add(comment);
    popupMenu.add(cancelComment);
    // 将右键菜单组装到文本域中
    panel.add(popupMenu);
    // 设置panel大小
    panel.setPreferredSize(new Dimension(400,300));
    // 给panel 绑定鼠标事件监听器
    panel.addMouseListener(new MouseAdapter() {
      // 鼠标释放监听
      @Override
      public void mouseReleased(MouseEvent e) {
        // 获取鼠标左键还是右键，true表示右键
        boolean flag = e.isPopupTrigger();
        // 如果是右键
        if (flag) {
          // 显示右键菜单（父组件、x坐标、y坐标）
          popupMenu.show(panel, e.getX(), e.getY());
        }
      }
    });

    frame.add(panel, BorderLayout.SOUTH);


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
    new MenuDemo().init();
  }
}

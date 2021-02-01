package com.rendawei.swing.component;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/*
*
* 基本组件
*
* */

public class BasicComponentDemo {
  // 窗口组件
  JFrame jFrame = new JFrame("测试基本组件");

  // 声明菜单相关组件
  // 菜单栏
  JMenuBar jMenuBar = new JMenuBar();
  // 菜单
  JMenu fileMenu = new JMenu("文件");
  JMenu editMenu = new JMenu("编辑");
  // 菜单项
  JMenuItem autoItem = new JMenuItem("自动换行");
  JMenuItem copyItem = new JMenuItem("复制");
  JMenuItem pasteItem = new JMenuItem("粘贴");
  JMenu formatMenu = new JMenu("格式");
  JMenuItem commentItem = new JMenuItem("注释");
  JMenuItem cancelCommentItem = new JMenuItem("取消注释");

  // 声明文本域, 大小为8行20列
  JTextArea jTextArea = new JTextArea(8, 20);

  // 声明列表框
  // 声明列表框选项
  String[] colors = {"红色", "绿色", "蓝色"};
  // 将声明的列表框颜色直接添加进列表框
  JList<String> colorList = new JList<String>(colors);

  // 声明下拉选择框
  JComboBox<String> colorSelect = new JComboBox<String>();

  // 声明单选框组件，因为男女只能选一个，所以需要使用按钮组
  ButtonGroup buttonGroup = new ButtonGroup();
  // 圆形单选框
  JRadioButton male = new JRadioButton("男");
  JRadioButton female = new JRadioButton("女");

  // 方形单选框, true表示默认选中
  JCheckBox isMarried = new JCheckBox("是否已婚？", true);

  // 声明文本框
  JTextField jTextField = new JTextField(40);
  // 声明按钮,并且给按钮添加图片
  JButton ok = new JButton("确定", new ImageIcon("D:\\study\\myprogram\\study_java\\swing_awt\\src\\main\\java\\com\\rendawei\\swing\\img\\确认.png"));

  // 声明右键弹出菜单
  JPopupMenu jPopupMenu = new JPopupMenu();
  // 因为右键菜单选项都是单选，所以需要一个菜单组
  ButtonGroup buttonGroup1 = new ButtonGroup();
  // 声明右键菜单选项
  JRadioButtonMenuItem metalItem = new JRadioButtonMenuItem("Metal 风格");
  JRadioButtonMenuItem nimbusItem = new JRadioButtonMenuItem("Nimbus 风格");
  JRadioButtonMenuItem windowsItem = new JRadioButtonMenuItem("Windows 风格", true);
  JRadioButtonMenuItem windowsClassicItem = new JRadioButtonMenuItem("Windows 经典风格");
  JRadioButtonMenuItem motifItem = new JRadioButtonMenuItem("Motif 风格");
  JRadioButtonMenuItem[] rightMenuItems = {metalItem, nimbusItem, windowsItem, windowsClassicItem, motifItem};

  public void init(){

    // 组装底部, 并
    JPanel buttonPanel = new JPanel();
    buttonPanel.add(jTextField);
    buttonPanel.add(ok);
    // 添加到窗口南部区域
    jFrame.add(buttonPanel, BorderLayout.SOUTH);


    // 组装选择相关组件
    JPanel selectPanel = new JPanel();
    // 设置颜色选择框的内容
    colorSelect.addItem("红色");
    colorSelect.addItem("蓝色");
    colorSelect.addItem("绿色");
    selectPanel.add(colorSelect);
    // 将男女单选框添加到组中
    buttonGroup.add(male);
    buttonGroup.add(female);
    selectPanel.add(male);
    selectPanel.add(female);
    selectPanel.add(isMarried);

    // 组装文本域和选择相关（因为文本域和选择相关panel 为垂直关系）
    Box topLeft = Box.createVerticalBox();
    topLeft.add(jTextArea);
    topLeft.add(selectPanel);

    // 族中顶部，就是顶部左侧和颜色列表
    Box top = Box.createHorizontalBox();
    top.add(topLeft);
    top.add(colorList);
    // 将顶部放入到窗口中部区域
    jFrame.add(top);

    // 组装顶部菜单
    // 先将评论和取消评论组装到格式化
    formatMenu.add(commentItem);
    formatMenu.add(cancelCommentItem);
    // 组装编辑中的选项
    editMenu.add(autoItem);
    editMenu.addSeparator(); // 添加分割线
    editMenu.add(copyItem);
    editMenu.add(pasteItem);
    editMenu.addSeparator();
    editMenu.add(formatMenu);
    // 组装菜单栏
    jMenuBar.add(fileMenu);
    jMenuBar.add(editMenu);

    // 将顶部菜单栏设置给窗口
    jFrame.setJMenuBar(jMenuBar);


    // 组装右键菜单
    // 先将右键菜单项放到组里面
    for (JRadioButtonMenuItem rightMenuItem : rightMenuItems) {
      buttonGroup1.add(rightMenuItem);
    }


    // 创建监听器，用来绑定给右键菜单
    ActionListener actionListener = new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        // 获取点击的按钮名称
        String cmd = e.getActionCommand();

        try {
          changeFlavor(cmd);
        } catch (Exception exception) {
          exception.printStackTrace();
        }
      }
    };

    // 挨个给按钮绑定监听器
    for (JRadioButtonMenuItem rightMenuItem : rightMenuItems) {
      rightMenuItem.addActionListener(actionListener);
    }

    // 将右键菜单选项绑定到右键菜单
    for (JRadioButtonMenuItem rightMenuItem : rightMenuItems) {
      jPopupMenu.add(rightMenuItem);
    }

    // 将右键菜单绑定给文本域,这次不需要监听鼠标事件了
    jTextArea.setComponentPopupMenu(jPopupMenu);

    // 设置点击关闭按钮关闭窗口
    jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    // 设置窗口最佳大小
    jFrame.pack();
    // 设置窗口可见
    jFrame.setVisible(true);



  }

  public static void main(String[] args) {
    new BasicComponentDemo().init();
  }

  private void changeFlavor(String cmd) throws Exception {
    /*
    * 定义一个方法用来修改界面风格
    *
    * */
    switch (cmd) {
      case "Metal 风格":
        UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
        break;
      case "Nimbus 风格":
        UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        break;
      case "Windows 风格":
        UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        break;
      case "Windows 经典风格":
        UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsClassicLookAndFeel");
        break;
      case "Motif 风格":
        UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
        break;
    }

    // 刷新组件外观
    SwingUtilities.updateComponentTreeUI(jFrame.getContentPane());
    SwingUtilities.updateComponentTreeUI(jMenuBar);
    SwingUtilities.updateComponentTreeUI(jPopupMenu);
  }
}

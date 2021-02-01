package com.rendawei.swing.component;


/*
* 标签页
*
*
* */

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class JTabberPaneDemo {
  JFrame jFrame = new JFrame("测试标签组件");

  // 创建标签组件 SwingConstants.LEFT 表示标签放在左边
  JTabbedPane jTabbedPane = new JTabbedPane(SwingConstants.LEFT, JTabbedPane.SCROLL_TAB_LAYOUT);


  // 设置用户标签相关信息
  String userTitle = "用户管理";
  ImageIcon userIcon = new ImageIcon("D:\\study\\myprogram\\study_java\\swing_awt\\src\\main\\java\\com\\rendawei\\swing\\img\\用户.png");
  JTextArea userDetail = new JTextArea("请编辑用户信息:");

  // 设置手机标签相关信息
  String phoneTitle = "手机管理";
  JList<String> phoneList = new JList<>(new String[]{"iPhone", "小米", "华为"});

  // 设置订单标签相关信息
  String orderTitle = "订单管理";
  JList<String> orderList = new JList<>(new String[]{"订单1", "订单2", "订单3"});

  public void init(){
    // 给标签组件添加标签
    jTabbedPane.addTab(userTitle, userIcon, userDetail);
    jTabbedPane.addTab(phoneTitle, phoneList);
    jTabbedPane.addTab(orderTitle, orderList);


    // 禁用order标签(设置第二个标签为false)
    jTabbedPane.setEnabledAt(2, false);
    // 设置默认选中手机标签(将第一个标签设置为默认选中)
    jTabbedPane.setSelectedIndex(1);

    // 监听当前面板的选中情况
    jTabbedPane.addChangeListener(new ChangeListener() {
      @Override
      public void stateChanged(ChangeEvent e) {
        int selectedIndex = jTabbedPane.getSelectedIndex();
        // 弹出一个消息框显示选中了第几个标签
        JOptionPane.showMessageDialog(jFrame,"当前选中了第：" + (selectedIndex+1) + "个标签");
      }
    });

    // 将标签组件组装进窗口
    jFrame.add(jTabbedPane);

    // 设置窗口位置大小
    jFrame.setBounds(400, 400, 400, 400);
    // 固定窗口大小
    jFrame.setResizable(false);
    jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    jFrame.setVisible(true);
  }

  public static void main(String[] args) {
    new JTabberPaneDemo().init();
  }
}

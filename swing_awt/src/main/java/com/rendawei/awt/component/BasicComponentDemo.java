package com.rendawei.awt.component;

import javax.swing.*;
import java.awt.*;

public class BasicComponentDemo {

  /*
  * 这里定义组件
  *
  * */

  // 窗口
  Frame frame = new Frame("这里测试基本组件" );

  // 文本域，能容纳5行，20列
  TextArea textArea = new TextArea(5, 20);

  // 下拉选择框
  Choice colorChooser = new Choice();

  // 创建男女复选框，由于两个只能选择一个所以必须要把两个选择框，放到一个复选框组里面
  CheckboxGroup cbg = new CheckboxGroup();
  Checkbox male = new Checkbox("男", cbg, true);
  Checkbox female = new Checkbox("女", cbg, false);

  // 复选框
  Checkbox isMarried = new Checkbox("是否已婚？");

  // 文本框 容纳20个字符
  TextField tf = new TextField(50);

  // 按钮
  Button ok = new Button("确认");

  // 列表  6列，可多选
  List colorList = new List(6, true);

  public void init(){
    /*
     *
     * 这里组装界面
     *
     * */

    // 组装底部
    Box bBox = Box.createHorizontalBox();
    bBox.add(tf);
    bBox.add(ok);

    frame.add(bBox, BorderLayout.SOUTH);

    // 组装选择部分
    colorChooser.add("红色");
    colorChooser.add("蓝色");
    colorChooser.add("绿色");

    Box cBox = Box.createHorizontalBox();
    cBox.add(colorChooser);
    cBox.add(male);
    cBox.add(female);
    cBox.add(isMarried);

    // 组装文本域和选择部分
    Box topLeft = Box.createVerticalBox();
    topLeft.add(textArea);
    topLeft.add(cBox);

    // 组装顶部左边和顶部右边
    colorList.add("红色");
    colorList.add("绿色");
    colorList.add("蓝色");

    Box top = Box.createHorizontalBox();
    top.add(topLeft);
    top.add(colorList);

    // 将顶部添加到窗口
    frame.add(top);

    frame.pack();
    frame.setVisible(true);


  }

  public static void main(String[] args) {
    new BasicComponentDemo().init();

  }
}

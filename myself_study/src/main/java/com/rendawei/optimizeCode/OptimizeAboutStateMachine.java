package com.rendawei.optimizeCode;

import java.util.ArrayList;
import java.util.Objects;

public class OptimizeAboutStateMachine {
  public final ArrayList<String> list;


  public OptimizeAboutStateMachine(ArrayList<String> list) {
    this.list = list;
  }

  /**
   * 这种情况条件很多而且条件之间可以互相转化
   * 就可以使用状态机来优化
   */
  public void doSomething(String str){
    list.add(str);
    if (list.size() == 0){
      System.out.println("empty list");
    } else if (list.size() == 1 && list.get(0).equals("55")){
      System.out.println("one byte");
    } else if (list.size() == 2 && list.get(0).equals("55") && list.get(1).equals("aa")) {
      System.out.println("meta size");
    } else if (list.size() == 22) {
      System.out.println("full meta data");
      list.clear();
    }
  }
}


// 最简单的状态机
class StateMachine {
  public final ArrayList<String> list;
  private SeparateState state;

  StateMachine(ArrayList<String> list) {
    this.list = list;
    this.state = SeparateState.BEGIN;
  }

  public void doSomething(String str){
    switch (state) {
      case BEGIN:
        System.out.println("empty list");
        list.add(str);
        state = SeparateState.METADATA_ONE_BYTE;
        break;
      case METADATA_ONE_BYTE:
        System.out.println("one byte");
        list.add(str);
        state = SeparateState.METADATA_NOT_FULL;
        break;
      case METADATA_NOT_FULL:
        System.out.println("meta size");
        list.add(str);
        if (list.size() == 22){
          list.clear();
        }
        state = SeparateState.METADATA_EMPTY;
        break;
      case METADATA_EMPTY:
        System.out.println("empty");
        list.add(str);
        state = SeparateState.METADATA_ONE_BYTE;
        break;
    }
  }
}

enum SeparateState {
  BEGIN,
  METADATA_EMPTY,
  METADATA_ONE_BYTE,
  METADATA_NOT_FULL,
}


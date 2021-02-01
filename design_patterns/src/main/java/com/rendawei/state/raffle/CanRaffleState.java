package com.rendawei.state.raffle;

/*
*   可以抽奖状态：
*
*
* */

import java.util.Random;

public class CanRaffleState implements State {

  RaffleActivity activity;

  public CanRaffleState(RaffleActivity activity) {
    this.activity = activity;
  }

  /*
  * 此状态不可以扣积分，因为已经扣过积分了
  * */
  @Override
  public void deductMoney() {
    System.out.println("您已经扣过积分了");
  }

  /*
  * 此状态可以抽奖，根据抽奖的情况，改变不同的状态
  * */
  @Override
  public boolean raffle() {
    System.out.println("正在抽奖...");
    Random random = new Random();
    int num = random.nextInt(10);

    // 如果抽中奖
    if (num == 0){
      // 将状态改变为发放奖品
      activity.setState(activity.getDispenseState());
      return true;
    } else {
      // 如果没有抽中，将活动状态改变为不能抽奖状态
      System.out.println("很遗憾，没有抽中奖品");
      activity.setState(activity.getNoRaffleState());
      return false;
    }
  }

  @Override
  public void dispensePrice() {
    System.out.println("没有中奖，不能发放奖品");
  }
}

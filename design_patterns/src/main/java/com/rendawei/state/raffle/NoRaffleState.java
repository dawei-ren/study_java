package com.rendawei.state.raffle;


/*
*
*
* 不能抽奖的状态，此时可以扣除积分
*
*
* */

public class NoRaffleState implements State {

  // 初始化时传入活动引用，扣除积分后改变状态
  RaffleActivity activity;


  public NoRaffleState(RaffleActivity activity) {
    this.activity = activity;
  }


  /*
  *
  * 当前状态可以扣除积分，扣除后，将状态设置成可以抽奖状态
  * */
  @Override
  public void deductMoney() {
    System.out.println("扣除积分成功,您可以抽奖了");
    activity.setState(activity.getCanRaffleState());
  }

  /*
  * 当前状态不能抽奖
  *
  * */
  @Override
  public boolean raffle() {
    System.out.println("只有扣除积分之后才能抽奖");
    return false;
  }

  /*
  *
  * 当前状态不能发放奖品
  * */
  @Override
  public void dispensePrice() {
    System.out.println("不能发放奖品");
  }
}

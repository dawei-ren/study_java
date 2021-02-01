package com.rendawei.state.raffle;


/*
*
* 发放奖品的状态
*
* */

public class DispenseState implements State {

  RaffleActivity activity;

  public DispenseState(RaffleActivity activity) {
    this.activity = activity;
  }

  @Override
  public void deductMoney() {
    System.out.println("不能扣除积分");

  }

  @Override
  public boolean raffle() {
    System.out.println("不能抽奖");
    return false;
  }

  /*
  * 发放奖品
  * */
  @Override
  public void dispensePrice() {
    if (activity.getCount() > 0){
      System.out.println("恭喜中将");
      // 如果中奖，将状态转变为无法抽奖状态
      activity.setState(activity.getNoRaffleState());
    } else {
      System.out.println("很遗憾，奖品送完了");
      // 改变状态为奖品发送完毕,后面我们就不可以再抽奖了
      activity.setState(activity.getDispenseOutState());
    }
  }
}

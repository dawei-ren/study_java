package com.rendawei.state.raffle;


/*
*
* 奖品发放完毕状态，
*   当活动状态编程这个，活动已结束
*
* */

public class DispenseOutState implements State {
  RaffleActivity activity;

  public DispenseOutState(RaffleActivity activity) {
    this.activity = activity;
  }

  @Override
  public void deductMoney() {
    System.out.println("奖品发送完毕，请下次再参加");
  }

  @Override
  public boolean raffle() {
    System.out.println("奖品发送完毕，请下次再参加");
    return false;
  }

  @Override
  public void dispensePrice() {
    System.out.println("奖品发送完毕，请下次再参加");

  }
}

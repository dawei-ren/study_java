package com.rendawei.state.raffle;

public interface State {

  // 扣除积分
  public void deductMoney();

  // 是否抽中奖品
  public boolean raffle();

  // 发放奖品
  public void dispensePrice();

}

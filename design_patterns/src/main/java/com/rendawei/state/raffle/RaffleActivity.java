package com.rendawei.state.raffle;

public class RaffleActivity {

  // 活动当前的状态
  State state;
  // 奖品数量
  int count;

  // 活动中包含以下集中状态，他们会经常发生变化
  State noRaffleState = new NoRaffleState(this);
  State canRaffleState = new CanRaffleState(this);
  State dispenseState = new DispenseState(this);
  State dispenseOutState = new DispenseOutState(this);


  public RaffleActivity(int count) {
    // 初始化当前状态为不能抽奖状态
    this.state = getNoRaffleState();
    this.count = count;
  }

  public State getNoRaffleState() {
    return noRaffleState;
  }

  public void setNoRaffleState(State noRaffleState) {
    this.noRaffleState = noRaffleState;
  }

  public State getCanRaffleState() {
    return canRaffleState;
  }

  public void setCanRaffleState(State canRaffleState) {
    this.canRaffleState = canRaffleState;
  }

  public State getDispenseState() {
    return dispenseState;
  }

  public void setDispenseState(State dispenseState) {
    this.dispenseState = dispenseState;
  }

  public State getDispenseOutState() {
    return dispenseOutState;
  }

  public void setDispenseOutState(State dispenseOutState) {
    this.dispenseOutState = dispenseOutState;
  }

  public State getState() {
    return state;
  }

  public void setState(State state) {
    this.state = state;
  }

  public int getCount() {
    // 每领一次奖品，自动减一
    int currentCount = count;
    count--;
    return currentCount;
  }

  public void setCount(int count) {
    this.count = count;
  }

  // 扣分
  public void deductMoney(){
    state.deductMoney();
  }

  // 抽奖
  public void raffle(){
    // 如果抽奖成功
    if (state.raffle()){
      // 领奖品
      state.dispensePrice();
    }
  }


}

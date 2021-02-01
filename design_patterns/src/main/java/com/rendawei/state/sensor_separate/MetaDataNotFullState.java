package com.rendawei.state.sensor_separate;

public class MetaDataNotFullState implements MetaDataState {
  StateMachine stateMachine;

  public MetaDataNotFullState(StateMachine stateMachine) {
    this.stateMachine = stateMachine;
  }

  @Override
  public void putData(byte b) {
    if (stateMachine.metaDataBytes.size() > 14){
      stateMachine.setState(stateMachine.getMetaDataFullState());
    }
    stateMachine.metaDataBytes.add(b);
  }
}

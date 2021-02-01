package com.rendawei.state.sensor_separate;

import java.util.Objects;

public class MetaDataOneState implements MetaDataState {
  StateMachine stateMachine;

  public MetaDataOneState(StateMachine stateMachine) {
    this.stateMachine = stateMachine;
  }

  @Override
  public void putData(byte b) {
    if (Objects.equals(b, (byte) 0xAA)) {
      stateMachine.metaDataBytes.add(b);
      stateMachine.setState(stateMachine.getMetaDataNotFullState());
    } else {
      stateMachine.buffer2.put(stateMachine.metaDataBytes.get(1));
      stateMachine.metaDataBytes.clear();
      stateMachine.buffer1.put(b);
      stateMachine.setState(stateMachine.getMetaDataEmptyState());
    }
  }
}

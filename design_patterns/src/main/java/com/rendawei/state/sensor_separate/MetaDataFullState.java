package com.rendawei.state.sensor_separate;

import java.util.Objects;

public class MetaDataFullState implements MetaDataState {
  StateMachine stateMachine;

  public MetaDataFullState(StateMachine stateMachine) {
    this.stateMachine = stateMachine;
  }

  @Override
  public void putData(byte b) {
    stateMachine.metaDataBytes.add(b);
    if (Objects.equals(stateMachine.metaDataBytes.get(2), (byte) 0x11)
        && Objects.equals(stateMachine.metaDataBytes.get(3), (byte) 0x11)){
      stateMachine.metaDataBytes.forEach(stateMachine.buffer1::put);
    } else if (Objects.equals(stateMachine.metaDataBytes.get(2), (byte) 0x22)
        && Objects.equals(stateMachine.metaDataBytes.get(3), (byte) 0x22)){
      stateMachine.metaDataBytes.forEach(stateMachine.buffer2::put);
    }

    stateMachine.metaDataBytes.clear();
    stateMachine.setState(stateMachine.getMetaDataEmptyState());
  }
}

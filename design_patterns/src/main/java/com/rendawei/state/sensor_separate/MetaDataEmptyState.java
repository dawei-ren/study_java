package com.rendawei.state.sensor_separate;

import java.util.ArrayList;
import java.util.Objects;

public class MetaDataEmptyState implements MetaDataState {

  StateMachine stateMachine;

  public MetaDataEmptyState(StateMachine stateMachine) {
    this.stateMachine = stateMachine;
  }

  @Override
  public void putData(byte b) {

    if (Objects.equals(b, (byte) 0x55)){
      stateMachine.metaDataBytes.add(b);
      stateMachine.setState(stateMachine.getMetaDataOneState());
    } else {
      if ((b & 64) == 0){
        stateMachine.buffer1.put(b);
      } else {
        stateMachine.buffer2.put(b);
      }
    }
  }
}

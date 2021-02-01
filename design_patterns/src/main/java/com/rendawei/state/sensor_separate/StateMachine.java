package com.rendawei.state.sensor_separate;

import java.nio.ByteBuffer;
import java.util.List;

public class StateMachine {
  MetaDataState state;
  List<Byte> metaDataBytes;
  ByteBuffer buffer1;
  ByteBuffer buffer2;

  MetaDataState metaDataEmptyState = new MetaDataEmptyState(this);
  MetaDataState metaDataOneState = new MetaDataOneState(this);
  MetaDataState metaDataNotFullState = new MetaDataNotFullState(this);
  MetaDataState metaDataFullState = new MetaDataFullState(this);

  public StateMachine(List<Byte> metaDataBytes, ByteBuffer buffer1, ByteBuffer buffer2) {
    this.state = metaDataEmptyState;
    this.buffer1 = buffer1;
    this.buffer2 = buffer2;
    this.metaDataBytes = metaDataBytes;
  }

  public void putData(byte b){
    state.putData(b);
  }

  public MetaDataState getState() {
    return state;
  }

  public void setState(MetaDataState state) {
    this.state = state;
  }

  public MetaDataState getMetaDataEmptyState() {
    return metaDataEmptyState;
  }

  public MetaDataState getMetaDataOneState() {
    return metaDataOneState;
  }

  public void setMetaDataOneState(MetaDataState metaDataOneState) {
    this.metaDataOneState = metaDataOneState;
  }

  public void setMetaDataEmptyState(MetaDataState metaDataEmptyState) {
    this.metaDataEmptyState = metaDataEmptyState;
  }

  public MetaDataState getMetaDataNotFullState() {
    return metaDataNotFullState;
  }

  public void setMetaDataNotFullState(MetaDataState metaDataNotFullState) {
    this.metaDataNotFullState = metaDataNotFullState;
  }

  public MetaDataState getMetaDataFullState() {
    return metaDataFullState;
  }

  public void setMetaDataFullState(MetaDataState metaDataFullState) {
    this.metaDataFullState = metaDataFullState;
  }
}

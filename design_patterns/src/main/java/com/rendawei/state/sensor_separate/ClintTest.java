package com.rendawei.state.sensor_separate;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

public class ClintTest {

  public static void main(String[] args) {
    List<Byte> metaDataBytes = new ArrayList<>();
    ByteBuffer buffer1 = ByteBuffer.allocate(100);
    ByteBuffer buffer2 = ByteBuffer.allocate(100);

    StateMachine stateMachine = new StateMachine(metaDataBytes, buffer1, buffer2);



  }
}

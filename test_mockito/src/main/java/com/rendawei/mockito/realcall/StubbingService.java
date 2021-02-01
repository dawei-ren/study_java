package com.rendawei.mockito.realcall;

public class StubbingService {
    public int getI(){
        return 10;
    }

    public String getS(){
        throw new RuntimeException();
    }
}

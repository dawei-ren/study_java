package com.rendawei.mockito.quickstart;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.IsInstanceOf.instanceOf;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class StubbingTest {

    private ArrayList<String> list;

    @Before
    public void init(){
        this.list = mock(ArrayList.class);
    }

    @Test
    public void howToUseStubbing(){

        // 模拟返回值
        when(list.get(0)).thenReturn("first");
        assertThat(list.get(0), equalTo("first"));

        // 模拟抛出异常
        when(list.get(anyInt())).thenThrow(new RuntimeException());
        try {
            list.get(0);
            fail();
        } catch (Exception e){
            assertThat(e, instanceOf(RuntimeException.class));
        }
    }

    @Test
    public void howToStubbingVoidMethod(){

        // 模拟当执行list.clear()的时候什么都不干
        doNothing().when(list).clear();
        list.clear();
        // 测试有没有执行过
        verify(list, times(1)).clear();

        // 模拟当执行list.clear()的时候抛出异常
        doThrow(RuntimeException.class).when(list).clear();

        try {
            list.clear();
            fail();
        }catch (Exception e){
            assertThat(e, instanceOf(RuntimeException.class));
        }
    }

    @Test
    public void stubbingDoReturn(){

        // 使用when...thenReturn的方式和doReturn...when的方式效果完全相同
        when(list.get(0)).thenReturn("first");
        doReturn("second").when(list).get(1);

        assertThat(list.get(0), equalTo("first"));
        assertThat(list.get(1), equalTo("second"));
    }

    @Test
    public void iterateStubbing(){
        // 给list.size()的第一次的执行结果为1，第二次的执行结果为2，第三次的执行结果为3，第四次的执行结果为4，后面的执行结果全部为4
        when(list.size()).thenReturn(1,2, 3, 4);
        assertThat(list.size(), equalTo(1));
        assertThat(list.size(), equalTo(2));
        assertThat(list.size(), equalTo(3));
        assertThat(list.size(), equalTo(4));
        assertThat(list.size(), equalTo(4));
        assertThat(list.size(), equalTo(4));
    }



    @After
    public void destroy(){
        reset(this.list);
    }

}

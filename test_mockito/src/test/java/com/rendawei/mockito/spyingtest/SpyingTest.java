package com.rendawei.mockito.spyingtest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class SpyingTest {

    /*
    * spying 和mock不同的是，mock一个类就会完全虚构一个类，默认执行这个类的方法都是虚构的，直到声明这个类的方法为真实
    *                      但是spy 一个类，默认执行的都是类本身，直到声明这个类的某个方法为虚构值
    *
    *
    * */

    @Test
    public void testSpy(){
        List<String> realList = new ArrayList<String>();
        List<String> list = spy(realList);

        list.add("Mockito");
        list.add("PowerMockito");

        assertThat(list.get(0), equalTo("Mockito"));
        assertThat(list.get(1), equalTo("PowerMockito"));
        assertThat(list.isEmpty(), equalTo(false));


        when(list.isEmpty()).thenReturn(true);
        when(list.size()).thenReturn(0);

        assertThat(list.get(0), equalTo("Mockito"));
        assertThat(list.get(1), equalTo("PowerMockito"));
        assertThat(list.isEmpty(), equalTo(true));
        assertThat(list.size(), equalTo(0));

    }
}

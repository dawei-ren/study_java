package com.rendawei.mockito.spyingtest;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;

public class AssertMatcherTest {

    @Test
    public void test(){
        int i = 10;
        assertThat(i, equalTo(10));
        assertThat(i, not(equalTo(20)));
        assertThat(i, is(10));
        assertThat(i, is(not(20)));
    }

    @Test
    public void test2(){
        double price = 23.45;
        assertThat(price, either(equalTo(23.45)).or(equalTo(23.54)));
        assertThat(price, both(equalTo(23.45)).and(not(equalTo(23.54))));
        assertThat(price, anyOf(is(23.45), is(11.34), is(33.33)));
    }
}

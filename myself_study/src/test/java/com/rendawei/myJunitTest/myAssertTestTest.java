package com.rendawei.myJunitTest;

import org.hamcrest.Matcher;
import org.junit.Assert;
import org.junit.Test;
import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert.*;

import static org.junit.Assert.*;

public class myAssertTestTest {

  @Test
  public void testAssert(){


//    判断范围
    assert 1 < 2;
  }

}
package com.rendawei.basic;

import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BasicToBeTestedTest {


  @Test
  public void testAdd(){
    // 测试普通方法
    BasicToBeTested basic = new BasicToBeTested();
    Assert.assertEquals(2, basic.add(1, 1));

    // 测试结果为null
    Assert.assertNull(basic.getState());

    // 测试结果为true
    basic.changeState(1);
    Assert.assertTrue(basic.getState());

    // 测试结果为 not null
    Assert.assertNotNull(basic.getState());

    // 测试结果为false
    basic.changeState(0);
    Assert.assertFalse(basic.getState());

    // 测试结果不相等
    Assert.assertNotEquals(true, basic.getState());

    // 测试浮点型,
    /*
    *    浮点数比较第三个参数是允许误差范围，0代表没有误差，但是这可能会导致测试出错，因为同一个浮点数比如1.1在计算机里有很多表示方式
    * 比如1.1和1.0999999999999999，一般建议误差为0.0001
    *
    * */
    Assert.assertEquals(110.1, basic.getFloatData(), 0.0001);
  }

  @Test
  public void testAddArrayList(){
    // 测试两个数组是否相等
    BasicToBeTested basic = new BasicToBeTested();

    List<String> a = Arrays.asList("a", "b");
    List<String> b = Collections.singletonList("c");
    List<String> target = Arrays.asList("a", "b", "c");

    Assert.assertArrayEquals(target.toArray(), basic.addArrayList(a, b).toArray());
  }

  @Test
  public void testChangeState() throws NoSuchFieldException, IllegalAccessException {
    // 测试私有变量 (使用反射)
    BasicToBeTested basic = new BasicToBeTested();

    Field stateField = BasicToBeTested.class.getDeclaredField("state");
    stateField.setAccessible(true);

    basic.changeState(0);
    Assert.assertEquals(false, stateField.get(basic));

    basic.changeState(1);
    Assert.assertEquals(true, stateField.get(basic));

    // 自定义私有变量的值
    stateField.set(basic, false);
    Assert.assertEquals(false, stateField.get(basic));
  }

  @Test
  public void testPrivateAdd() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
    // 测试私有方法  （使用反射）
    BasicToBeTested basic = new BasicToBeTested();

    Method method = BasicToBeTested.class.getDeclaredMethod("privateAdd", int.class, int.class);
    method.setAccessible(true);

    Assert.assertEquals(2, method.invoke(basic, 1, 1));
  }

  @Test(expected = Exception.class)
  public void testFailed() throws Exception {
    // 测试程序执行失败
    BasicToBeTested basic = new BasicToBeTested();
    basic.failed();
  }

}
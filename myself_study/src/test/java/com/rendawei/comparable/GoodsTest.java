package com.rendawei.comparable;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

/*
 * Comparable 接口的使用举例： 自然排序，就是默认排序的方法
 *
 * 1. 像String。包装类等实现了Comparable接口，重写了compareTo 方法，给出了比较两个对象大小的规则
 * 2. 像String、包装类重写了compareTo 方法以后，进行了从小到大的排序
 * 3. 重写compareTo 的规则
 *     如果当前对象this大于形参对象obj，则返回正整数
 *     如果当前对象this小于形参对象obj，则返回负整数
 *     如果当前对象this等于形参对象obj，则返回零
 *
 * 4. 对于自定义类来说，如果需要排序，我们可以让自定义类实现Comparable接口，重写compareTo(obj)方法，在compareTo方法中指明如何排序
 *
 * Comparator 接口的使用： 定制排序
 * 1. 当元素的类型没有实现Comparable接口而又不方便修改代码，或者实现了Comparable接口的排序规则不适合当前的操作，就用Comparator的对象来排序
 * 2. 重写compare(Object o1， Object o2)方法，比较o1和o2的大小：
 *      如果方法返回正整数，则表示o1 大于o2
 *      如果方法返回0， 表示相等
 *      如果返回负整数，表示o1 小于o2
 *
 *
 * */


public class GoodsTest {


  @Test
  public void testComparableStringObj(){
    String[] arr = new String[]{"AA", "EE", "CC", "DD"};
    // 可以使用Arrays.sort 来排序是因为String类已经重写了Compare接口中的compareTo 方法
    Arrays.sort(arr);
    System.out.println(Arrays.toString(arr));
  }

  @Test
  public void testComparableObj(){
    Goods[] arr = new Goods[4];
    arr[0] = new Goods("lenovoMouse", 34);
    arr[1] = new Goods("dellMouse", 43);
    arr[2] = new Goods("xiaomiMouse", 18);
    arr[3] = new Goods("huaweiMouse", 654);

    // 如果CompareGoods 类没有实现Compare接口的compareTo方法的话是不能比较的，必须要重新写
    Arrays.sort(arr);
    System.out.println(Arrays.toString(arr));
  }

  @Test
  public void testComparator(){
    String[] arr = new String[]{"AA", "EE", "CC", "DD"};
    Arrays.sort(arr, new Comparator<String>() {
      public int compare(String o1, String o2) {
        if (o1 instanceof String && o2 instanceof String){
          String s1 = (String) o1;
          String s2 = (String) o2;
          // 下面的语句相当于if判断然后返回正整数、0或者负整数
          return -s1.compareTo(s2);
        }
        throw new RuntimeException("输入的数据类型不一致");
      }
    });
    System.out.println(Arrays.toString(arr));
  }

}
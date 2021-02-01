package com.rendawei.myList;

import java.util.Arrays;

public class TestArray {

  public static void main(String[] args) {

    // 创建空数组
    int[] ints = new int[5];
    System.out.println(Arrays.toString(ints));
    // 获取值
    System.out.println(ints[0]);
    // 设置值
    ints[0] = 1;

    // 创建初始化有值的数组
    int[] nums = {2, 5, 0, 4, 6, -10};
    // 获取数组长度
    System.out.println(nums.length);

    System.out.println("数组循环： 需要获取key");
    for (int i = 0; i < nums.length; i++) {
      System.out.println("key:" + i + " value:" + nums[i]);
    }

    System.out.println("数组循环: 不用获取key");
    for (int num : nums) {
      System.out.println(num);
    }

    // 打印数组
    System.out.println("使用Arrays来操作数组: 打印数组");
    int[] nums1 = {2, 5, 0, 4, 6, -10};
    System.out.println(Arrays.toString(nums1));

    System.out.println("使用Arrays来操作数组: 排序");
    int[] nums2 = {2, 5, 0, 4, 6, -10};
    System.out.println(Arrays.toString(nums2));
    Arrays.sort(nums2);
    System.out.println(Arrays.toString(nums2));

    System.out.println("使用Arrays来操作数组: 指定范围排序");
    int[] nums3 = {2, 5, 0, 4, 6, -10};
    System.out.println(Arrays.toString(nums3));
    Arrays.sort(nums3, 0, 4);
    System.out.println(Arrays.toString(nums3));

    System.out.println("使用Arrays来操作数组: 为数组元素填充相同的值");
    int[] nums4 = {2, 5, 0, 4, 6, -10};
    System.out.println(Arrays.toString(nums4));
    Arrays.fill(nums4, 1);
    System.out.println(Arrays.toString(nums4));

    System.out.println("使用Arrays来操作数组: 对数组的部分元素填充相同的值");
    int[] nums5 = {2, 5, 0, 4, 6, -10};
    System.out.println(Arrays.toString(nums5));
    // 对下表2-4的元素填充为3
    Arrays.fill(nums5, 2, 5, 3);
    System.out.println(Arrays.toString(nums5));


    System.out.println("循环获取 片分值");
    int[] ints1 = new int[10];
    for (int i = 0; i < 10; i++) {
      ints1[i] = i;
    }
    System.out.println(Arrays.toString(ints1));

    int start = 0;
    while (start < ints1.length -3){
      System.out.println(Arrays.toString(Arrays.copyOfRange(ints1, start, start+3)));
      start= start+3;
    }
    System.out.println(Arrays.toString(Arrays.copyOfRange(ints1, start, ints1.length)));
  }
}

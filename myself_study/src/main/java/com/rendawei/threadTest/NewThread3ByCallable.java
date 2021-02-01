package com.rendawei.threadTest;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;



/*
*
*   创建线程的方式3： 实现Callable接口
*
*     1. 创建一个实现Callable的实现类
*     2. 实现call方法，将此线程需要执行的操作声明在call()中
*     3. 创建Callable接口实现类的对象
*     4. 将此Callable接口实现类的对象作为参数传递到FutureTask构造器中，创建FutureTask的对象
*     5. 将FutureTask的对象作为参数传递到Thread类的构造器中，创建Thread对象，并start()
*     6. 如果需要的话，获取Callable中call方法的返回值
*
*   如何理解实现Callable接口的方式创建多线程比实现Runnable接口创建多线程方式强大？
*     1. call方法是可以有返回值的
*     2. call方法是可以捕获异常的，被外面的操作捕获异常的
*     3. Callable是支持泛型的，可以支持任何类型的数据
*
*
*
* */

public class NewThread3ByCallable {
  public static void main(String[] args) {
    NumThread numThread = new NumThread();

    FutureTask<Integer> futureTask = new FutureTask<Integer>(numThread);

    Thread myThread = new Thread(futureTask);
    myThread.start();

    // 此时，如果对callable的返回值不感兴趣，可以不用下面的代码
    {
      try {
        // get() 返回值即为futureTask构造器参数Callable实现类重写的call()的返回值。
        Integer sum = futureTask.get();
        System.out.println("总和：" + sum);
      } catch (InterruptedException | ExecutionException e) {
        e.printStackTrace();
      }
    }
  }

}


class NumThread implements Callable<Integer>{

  @Override
  public Integer call() throws Exception {
    int sum = 0;
    for (int i = 1; i <= 100; i++){
      if (i % 2 == 0){
        System.out.println(i);
        sum += i;
      }
    }
    return sum;

  }
}

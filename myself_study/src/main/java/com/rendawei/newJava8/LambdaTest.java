package com.rendawei.newJava8;


/*
*   Lambda 表达式
*       本质上就是对匿名内部类的简写，不用再实例化类了
*
*
*   格式：
*     无参数，无返回值
*     () -> System.out.println("bbb eating something")
*     有一个参数，无返回值
*     x -> System.out.println("bbb eating something")
*     两个参数，有返回值且方法体中有多条语句
*     (a, b) -> {
*           System.out.println("bbb eating something")
*           System.out.println("bbb eating something")
*           return a
*       }
*     有返回值且只有一条语句
*     (x, y) -> Integer.compare(x, y)
*
*   条件:
*     Lambda 表达式需要函数式接口的支持（接口中只有一个抽象方法）,
*     在开发过程中如果需要函数式接口的话，此接口可以使用@FunctionalInterface来修饰，避免之后乱改
*
*
*   Java8内置的4大核心函数式接口
*     Consumer<T> : 消费型接口
*       void accept(T t)
*     Supplier<T> : 供给型接口
*       T get()
*     Function<T, R> : 函数型接口
*       R apply(T t)
*     Predicate<T> : 断言型接口
*       boolean test<T t>

*
*
*   方法引用：
*     如果lambda表达式中的内容已经有方法实现了，可以直接引用
*
*   使用方法引用：
*     对象::实例方法名
*     类::静态方法名
*     类::实例方法名
*
*
*
*
*
*
*
* */

import com.rendawei.newJava8.baseClass.Child;
import com.rendawei.newJava8.baseClass.Person;

public class LambdaTest {
  public static void main(String[] args) {
    // 原来的实现方式， 必须要写一个Child类实现Person接口然后实例化Child类
    Person child = new Child();
    child.eat();

    // 而使用lambda表达式就不用再创建一个Child类，然后实现Person接口，重写ead方法了，通过-> 连接入参和方法体就可以了
    Person child1 = () -> System.out.println("bbb eating something");
    child1.eat();
  }

}

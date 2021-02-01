package com.rendawei.testProtobuf;


import java.io.*;
import java.lang.reflect.Array;
import java.util.Arrays;

/*
*   Java 原始序列化测试
*
*
* */
public class TestJavaSerialization {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        // 序列化，将对象序列化成一个二进制数组
        byte[] bs = serialize();
        System.out.println(Arrays.toString(bs));


        // 反序列化，将二进制数组还原成对象
        Teacher teacher = deserialize(bs);
        System.out.println(teacher);

    }


    /*
    * 序列化
    *
    * */

    public static byte[] serialize() throws IOException {
        // 实例化化对象
        Teacher teacher = new Teacher();
        teacher.setTeacherId(1L);
        teacher.setAge(18);
        teacher.setName("张飞");
        teacher.getCourses().add("Java");

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream output = new ObjectOutputStream(baos);
        output.writeObject(teacher);

        return baos.toByteArray();
    }


    /*
    * 反序列化
    *
    * */

    public static Teacher deserialize(byte[] byteArray) throws IOException, ClassNotFoundException {
        ObjectInputStream input = new ObjectInputStream(new ByteArrayInputStream(byteArray));
        return (Teacher)input.readObject();
    }
}

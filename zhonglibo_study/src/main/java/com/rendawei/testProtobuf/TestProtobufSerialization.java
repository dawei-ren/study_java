package com.rendawei.testProtobuf;

import com.google.protobuf.InvalidProtocolBufferException;
import com.rendawei.testProtobuf.autoTeacherProtobuf.TeacherSerializer;

import java.util.Arrays;

public class TestProtobufSerialization {
    public static void main(String[] args) throws InvalidProtocolBufferException {

        byte[] bs = serialize();
        System.out.println(Arrays.toString(bs));

        TeacherSerializer.Teacher teacher = deserialize(bs);
        System.out.println(teacher);
    }

    /*
    *
    * 序列化
    * */

    public static byte[] serialize(){
        TeacherSerializer.Teacher.Builder builder = TeacherSerializer.Teacher.newBuilder();
        builder.setTeacherId(1).setAge(18).setName("张飞").addCourses("Java");

        TeacherSerializer.Teacher teacher = builder.build();
        return teacher.toByteArray();
    }

    /*
    * 反序列化
    *
    * */

    public static TeacherSerializer.Teacher deserialize(byte[] byteArray) throws InvalidProtocolBufferException {
        return TeacherSerializer.Teacher.parseFrom(byteArray);
    }
}

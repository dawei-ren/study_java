package com.rendawei.testProtobuf;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/*
*   序列化是指将对象实例的状态存储到存储媒体的过程。在此过程中，先将对象的公共字段和私有字段以及类的名称（包括类所在的程序集）转换为字节流
*   ，然后再把字节流写入数据流。在随后对对象进行反序列化时，将创建出与原对象完全相同的副本。
*
*
*   只有实现了Serializable的类才能被序列化
*
*
*
* */
public class Teacher implements Serializable {

    //  Java的序列化的机制通过判断serialVersionUID来验证版本的一致性。
    private static final long serialVersionUID = -9151052169472403987L;

    private Long teacherId;
    private int age;
    private String name;



    private List<String> courses = new ArrayList<String>();

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Long getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Long teacherId) {
        this.teacherId = teacherId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getCourses() {
        return courses;
    }

    public void setCourses(List<String> courses) {
        this.courses = courses;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "teacherId=" + teacherId +
                ", age=" + age +
                ", name='" + name + '\'' +
                ", courses=" + courses +
                '}';
    }
}

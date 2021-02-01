package com.rendawei.testProtobuf;


/*
*   Protobuf
*       Protobuf是一种序列化协议
*
*   优点：
*       可以将对象序列化成一个很短的字节，极大地提高性能
*
*
*   序列化和反序列化
*       序列化： 将对象转化成二进制数据（二进制字节数组） ，编码
*       反序列化： 将二进制数组转化成对象，解码
*
*   Java中最原始的对象序列化和反序列化
*       ObjectInput 序列化
*       ObjectOutput 反序列化
*
*
*   使用方法：
*       1. 项目中安装protobuf-java依赖
*       2. 下载protoc软件
*       3. 写proto文件（定义要序列化的类）
*       4. 自动生成代码（D:\study\myprogram\protobuf\protoc-3.6.1-win32\bin\protoc.exe .\TeacherSerializer.proto --java_out=./）
*       5. 代码调用
*
*   为何protobuf效率那么高（可以通过很小的字节数组来序列化一个类）
*       1. Java原生的序列化，为了可以使类序列化之后可以反序列化，必须要记录一些关键字，数据信息，对象信息，位置信息，长度等，所以会占用很大的信息
*       2. 而protobuf，因为自动生成了一些代码，序列化的时候减少了一些额外信息。
*       3. protobuf，是伸缩性的，比如int 1， 在java中为4个字节，也就是说32位，protobuf会自动识别，如果为1这种很小的数，只用1个字节就够了，也就是8位
*
*
*
*
* */
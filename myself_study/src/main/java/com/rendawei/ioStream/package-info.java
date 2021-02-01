package com.rendawei.ioStream;


/*
 * 一、流的分类
 *
 * 1. 操作数据单位：字节流、字符流
 * 2. 数据的流向：输入流、输出流
 * 3. 流的角色：节点流、处理流
 *
 * 二、流的体系结构
 *
 *       抽象基类                     节点流（文件流）                      缓冲流
 * 字节读 InputStream                FileInputStream                   BufferInputStream
 * 字节写 OutputStream               FileOutputStream                  BufferOutPutStream
 * 字符读 Reader                     FileReader                        BufferReader
 * 字符写 Writer                     FileWriter                        BufferWriter
 *
 *
 * 测试FileInputStream 和 FileOutputStream的使用
 *
 * 结论：
 *   对于文本文件（.txt, .java, .c, .cpp），使用字符流处理
 *   对于非文本文件（.jpg, .mp3, .mp4, .avi, .doc, .ppt, ...），使用字节流处理
 *
 * */
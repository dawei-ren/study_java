package com.rendawei.ioStream;




import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileReaderWriterTest {
    /*
    * 将当前模块下的hello.txt文件内容读入程序中，并输出到控制台
    *
    * 说明点：
    * 1. read()的理解：返回读入的一个字符，如果达到文件末尾，返回-1
    * 2. 异常的处理：为了保证流资源一定可以执行关闭擦欧总。需要使用try-catch-finally处理
    * 3. 读入的文件一定要存在，否则就会报FileNotFoundException。
    * */

    public void testFileReader(){
        /*
        * 一个字母一个字母读取文件
        * */
        FileReader fr = null;

        try {
            // 实例化File类的对象，指明要操作的文件
            File file = new File("files/hello.txt");
            // 提供具体的流
            fr = new FileReader(file);
            // 数据的读入
            int data = fr.read();
            while (data != -1){
                System.out.print((char)data);
                data = fr.read();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 流的关闭操作
            try {
                if(fr != null){
                    fr.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void testFileReader1() {
        /*
        * 以数组的方式读取文件
        * */
        FileReader fr = null;
        try {
            // 1. File类的实例化

            File file = new File("files/hello.txt");

            // 2. FileReader流的实例化
            fr = new FileReader(file);


            // 3. 读入的操作
            // read(char[] cbuf): 返回每次读入cbuf数组中的字符的个数。如果达到文件末尾，返回-1
            char[] cbuf = new char[5];
            int len;

            while ((len = fr.read(cbuf)) != -1){
//                for (int i = 0; i < len; i++) {
//                    System.out.print(cbuf[i]);
//                }

                String str = new String(cbuf, 0, len);
                System.out.print(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 4. 资源的关闭
            if(fr != null){
                try {
                    fr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }



    /*
    *
    * 从内存中写出数据到硬盘文件里
    *
    * 说明：
    * 1. 输出操作，对应的File可以不存在的，
    *       如果不存在，在处处的过程中，会自动创建文件
    *       如果存在：
    *           如果流使用的构造器是：FileWriter(file,false)/ FileWriter(file):对原有文件的覆盖
    *           如果流使用的构造器是：FileWriter(file,true) ：不会对源文件覆盖，在原有文件追加内容
    *
    *
    * */

    public void testFileWriter(){
        FileWriter fw = null; // false 表示覆盖文件
        try {
            // 1. 提供File类的对象，指明写出到的文件
            File file = new File("files/dream.txt");

            // 2. 提供FileWriter的对象，用于数据写出
            fw = new FileWriter(file, false);

            // 3. 写出的操作
            fw.write("I have a dream !\n");
            fw.write("you need to have a dream");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 4. 流资源的关闭
            if (fw != null){
                try {
                    fw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

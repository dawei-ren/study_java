package com.rendawei.ioStream;


/*
*
* 测试FileInputStream 和 FileOutputStream的使用
*
* 结论：
*   对于文本文件（.txt, .java, .c, .cpp），使用字符流处理
*   对于非文本文件（.jpg, .mp3, .mp4, .avi, .doc, .ppt, ...），使用字节流处理
*
* */

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileInputOutputStreamTest {


    /*
    * 实现对图片的复制操作
    *
    * */
    public void testFileInputOutputStream(){
        FileInputStream fis = null;
        FileOutputStream fos = null;

        try {
            // 造文件
            File srcFile = new File("files/love.jpg");
            File destFile = new File("files/love1.jpg");

            // 造流
            fis = new FileInputStream(srcFile);
            fos = new FileOutputStream(destFile);

            // 复制
            byte[] buffer = new byte[5];
            int len;

            while ((len = fis.read(buffer)) != -1){
                fos.write(buffer, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            // 关闭流

            if (fos != null){
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fis != null){
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}

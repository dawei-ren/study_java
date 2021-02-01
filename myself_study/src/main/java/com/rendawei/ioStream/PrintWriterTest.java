package com.rendawei.ioStream;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;


/*
*
*   1. 使用PrintWriter，可以简化写入步骤，一行一行写，不用写一行然后换行这种操作
*   2. 使用try-with-resource语法，可以自动关闭流，不用每写一次，关闭一次，大大的简化代码量
* */

public class PrintWriterTest {

    public void testPrintWriter(){

        try (PrintWriter printWriter = new PrintWriter(new FileWriter(new File("files","test_print_writer.txt")),true)){
            printWriter.println("aaaaaaa");
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}

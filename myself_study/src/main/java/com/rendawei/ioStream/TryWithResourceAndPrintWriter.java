package com.rendawei.ioStream;
import org.apache.commons.io.FileUtils;
import java.io.*;


/*
*   测试使用PrintWriter写入数据，
*       1. 使用try-with-resource 简化try-catch步骤，并且不用每次都stop
*       2. 使用PrintWriter简化写入步骤、换行等，
*       3. 使用更加厉害的FileUtils创建文件目录
*
*
* */

public class TryWithResourceAndPrintWriter {
    private final File fileDirectoryObj;

    // 传入文件路径
    public TryWithResourceAndPrintWriter(String fileDirectory) throws IOException {
        this.fileDirectoryObj = new File(fileDirectory);
        // 判断目录是否存在，如果不存在，创建目录
        if (!fileDirectoryObj.exists()){
            FileUtils.forceMkdir(fileDirectoryObj);
        }
    }

    // 向文件中写入数据
    public void writeFile(String lineStr, String fileName){
        File file = new File(fileDirectoryObj, fileName);

        // 第一个true表示追加写入，第二个true表示自动刷新，try后面就是try-with-resource语法
        try (PrintWriter pw = new PrintWriter(new FileWriter(file, true), true)){
            pw.println(lineStr);
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    // 读取目录中所有文件的数据
    public void readFile(){
        // 获取目录中的文件列表
        File[] fileList = fileDirectoryObj.listFiles();
        // 如果目录中有文件
        if (fileList != null && fileList.length > 0){
            // 循环文件列表
            for (File eachFile : fileList){
                // 使用try-with-resource简化步骤
                try (BufferedReader br = new BufferedReader(new FileReader(eachFile))){
                    String eachLine;
                    // 循环每一个文件中的所有行
                    while ((eachLine = br.readLine()) != null){
                        System.out.println(eachLine);
                    }
                } catch (IOException e){
                    e.printStackTrace();
                }
                // 一个文件读完后，使用FileUtils删除文件
                try {
                    FileUtils.forceDelete(eachFile);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

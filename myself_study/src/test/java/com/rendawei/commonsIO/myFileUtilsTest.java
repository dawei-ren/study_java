package com.rendawei.commonsIO;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import static org.junit.Assert.*;

public class myFileUtilsTest {
  private MyFileUtils myFileUtils;
  private File fileDirectoryObj;

  @Before
  public void setUp() throws IOException {
    this.myFileUtils = new MyFileUtils();

    // 创建文件目录
    this.fileDirectoryObj = new File("testFileDirectory");
    // 判断目录是否存在，如果不存在，创建目录
    if (!fileDirectoryObj.exists()){
      FileUtils.forceMkdir(fileDirectoryObj);
    }
  }

  @Test
  public void testFileToBytes() {

    File file = createFile1("a.txt","test");
    File file1 = createFile2("b.txt","test");
    byte[] bytes = myFileUtils.fileToBytes(file);
    byte[] bytes1 = myFileUtils.fileToBytes(file1);
    System.out.println(Arrays.toString(bytes));
    System.out.println(Arrays.toString(bytes1));

    byte[] helloWordBytes = new byte[]{116, 101, 115, 116};
    assertArrayEquals(bytes1, helloWordBytes);
  }


  public File createFile1(String filename, String lineStr) {
    /*
    *
    * 注意：使用PrintWriter创建文件的时候 会创建一个换行符，
    *       在Windows中为\r\n
    *       造Unix系统中为\n
    *       在Mac系统中为\r
    * 所以创建文件最好不要换行符，不然在不同系统中会报错，尽量使用createFile2的方法创建文件
    *
    * */
    // 再目录中创建文件
    File file = new File(fileDirectoryObj,filename);
    // 在文件中写入数据
    try (PrintWriter pw = new PrintWriter(new FileWriter(file), true)){
      pw.println(lineStr);
    } catch (IOException e){
      e.printStackTrace();
    }
    return file;
  }

  public File createFile2(String filename, String lineStr){
    File file = new File(fileDirectoryObj,filename);
    try(FileWriter fw = new FileWriter(file, false)){
      fw.write(lineStr);
    }catch (IOException e){
      e.printStackTrace();
    }
    return file;
  }

  @After
  public void destroy() throws IOException {
    FileUtils.forceDelete(fileDirectoryObj);
  }

}
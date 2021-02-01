package com.rendawei.commonsIO;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class MyFileUtils {



  // 创建文件目录
  public void mkDir() throws IOException {
    File fileDirectoryObj = new File("testFileDirectory");
    // 判断目录是否存在，如果不存在，创建目录
    if (!fileDirectoryObj.exists()){
      FileUtils.forceMkdir(fileDirectoryObj);
    }
  }

  // 删除文件或目录
  public void deleteFileOrDir(File fileObj) throws IOException {
    FileUtils.forceDelete(fileObj);
  }


  // 将文件转化为二进制数组
  public byte[] fileToBytes(File file){
    try {
      return FileUtils.readFileToByteArray(file);
    } catch (IOException e) {
      e.printStackTrace();
      return null;
    }
  }

}

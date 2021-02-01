package com.rendawei.myExcel;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class TestExcel {

  public void createExcel() throws IOException {
    //创建Excel文件薄
    XSSFWorkbook workbook = new XSSFWorkbook();
    //创建工作表sheeet
    Sheet sheet  =workbook.createSheet();


    //创建第一行
    Row row = sheet.createRow(0);
    // 给第一行添加内容
    String[] title = {"id","name","sex"};
    for (int i = 0; i < title.length; i++){
      row.createCell(i).setCellValue(title[i]);
    }

    //追加10行数据
    for (int i=1;i<10;i++){
      // 创建一行
      Row nextrow=sheet.createRow(i);
      // 给每一行添加内容
      nextrow.createCell(0).setCellValue("a"+i);
      nextrow.createCell(1).setCellValue("user"+i);
      nextrow.createCell(2).setCellValue("男");
    }

    //创建一个文件
    File file = new File("testFileDirectory", "test1.xlsx");
    FileOutputStream stream= FileUtils.openOutputStream(file);

    // 写入数据
    workbook.write(stream);
    stream.close();

  }
}

package com.qingtian;

import com.qingtian.core.ExcelFileGenerator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;

/**
 * @author mcrwayfun
 * @version 1.0
 * @description
 * @date Created in 2018/8/10
 */
public class ExcelTest {

    public static void main(String[] args) {

        // 获取excel表格数据
        ExcelTest excelTest = new ExcelTest();
        ArrayList<String> fieldName = excelTest.getFieldName();
        ArrayList<ArrayList<String>> excelFillData = excelTest.excelFillData();

        // 输出
        File file = new File("src/main/resources/" + System.currentTimeMillis() + ".xls");

        // excel生成器
        ExcelFileGenerator generator = new ExcelFileGenerator(fieldName, excelFillData);

        try {
            OutputStream os = new FileOutputStream(file);
            generator.expordExcel(os);
            // 清理刷新缓冲区，将缓存中的数据将数据导出excel
            os.flush();
            // 关闭os
            if (os != null) {
                os.close();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * excel字段属性
     *
     * @return
     */
    private ArrayList<String> getFieldName() {

        ArrayList<String> fieldList = new ArrayList<String>(10);

        fieldList.add("id");
        fieldList.add("name");
        fieldList.add("age");

        return fieldList.isEmpty() ? null : fieldList;
    }

    /**
     * 组装excel数据
     *
     * @return
     */
    private ArrayList<ArrayList<String>> excelFillData() {

        ArrayList<ArrayList<String>> dataList = new ArrayList<ArrayList<String>>();
        int count = 10;
        for (int i = 1; i <= count; i++) {

            ArrayList<String> rowData = new ArrayList<String>();
            // id
            rowData.add(i + "");
            // name
            rowData.add("mcrwayfun" + i);
            // age
            rowData.add(i + "");

            dataList.add(rowData);
        }

        return dataList.isEmpty() ? null : dataList;
    }
}

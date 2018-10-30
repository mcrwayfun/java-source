package com.qingtian;

import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.hssf.util.HSSFColor;

import java.io.OutputStream;
import java.util.ArrayList;

/**
 * @author mcrwayfun
 * @version 1.0
 * @description 系统数据导出Excel工具
 * @date Created in 2018/8/10
 */
public class ExcelFileGenerator {

    // Excel每个工作簿的行数
	private final int SPLIT_COUNT = 1000;

    // excel标题数据集
	private ArrayList fieldName = null;

    // excel数据内容
	private ArrayList fieldData = null;

    // POI报表的核心对象
	private HSSFWorkbook workBook = null;

	/**
	 * 构造器
	 * 
	 * @param fieldName
	 *            结果集的字段名
	 * @param fieldData
	 */
	public ExcelFileGenerator(ArrayList fieldName, ArrayList fieldData) {

		this.fieldName = fieldName;
		this.fieldData = fieldData;
	}

	/**
	 * 创建HSSFWorkbook对象
	 * 
	 * @return HSSFWorkbook
	 */
	public HSSFWorkbook createWorkbook() {

        // 创建workbook对象
		workBook = new HSSFWorkbook();
		int rows = fieldData.size();
		int sheetNum = 1;


		for (int i = 1; i <= sheetNum; i++) {
            // 使用wookbook对象创建sheet对象
			HSSFSheet sheet = workBook.createSheet("Page " + i);
            // 使用HSSFSheet对象创建row，row的下标从0开始
			HSSFRow headRow = sheet.createRow(0);
            // 循环excel的标题
			for (int j = 0; j < fieldName.size(); j++) {
                // 使用HSSFRow创建cell，cell的下标从0开始
				HSSFCell cell = headRow.createCell(j);
				// 添加样式
                // 设置每一列的宽度
				sheet.setColumnWidth(j, 6000);
				// 创建样式
				HSSFCellStyle cellStyle = workBook.createCellStyle();
				// 设置字体
				HSSFFont font = workBook.createFont();
				// 将字体变为粗体
				font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
				// 将字体颜色变红色
				short color = HSSFColor.RED.index;
				font.setColor(color);
                // 设置之后的字体
				cellStyle.setFont(font);

				// 添加样式
                // 设置单元格的类型
				cell.setCellType(HSSFCell.CELL_TYPE_STRING);
				// poi3.6版本已经内部做了处理，不需设置编码，设置编码格式
				// cell.setEncoding(HSSFCell.ENCODING_UTF_16);

				if (fieldName.get(j) != null) {
					cell.setCellStyle(cellStyle);
                    // 赋值
					cell.setCellValue((String) fieldName.get(j));
				} else {
					cell.setCellStyle(cellStyle);
					cell.setCellValue("-");
				}
			}
            // 分页显示数据
			for (int k = 0; k < rows ; k++) {
                // 使用HSSFSheet对象创建row，row的下标从0开始
				HSSFRow row = sheet.createRow((k + 1));
				// 将数据内容放入excel单元格
                // 循环数据集
				ArrayList rowList = (ArrayList) fieldData.get((i - 1) + k);
				for (int n = 0; n < rowList.size(); n++) {
                    // 使用HSSFRow创建cell，cell的下标从0开始
					HSSFCell cell = row.createCell(n);
					if (rowList.get(n) != null) {
						cell.setCellValue((String) rowList.get(n).toString());
					} else {
						cell.setCellValue("");
					}
				}
			}
		}
		return workBook;
	}

	public void expordExcel(OutputStream os) throws Exception {
        // 创建工作簿对象excel
		workBook = createWorkbook();
        // 将workbook对象写到输出流
		workBook.write(os);
		os.close();
	}


}

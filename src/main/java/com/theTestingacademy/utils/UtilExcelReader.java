package com.theTestingacademy.utils;


import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class UtilExcelReader {

    public static Object[][] getDataFromExcel(String filePath, String sheetName) throws IOException {
        FileInputStream fin = new FileInputStream(new File(filePath));
        Workbook book = WorkbookFactory.create(fin);
        Sheet sheet = book.getSheet(sheetName);

        int rowCount = sheet.getLastRowNum();
        int colCount = sheet.getRow(0).getLastCellNum();
        Object[][] data = new Object[rowCount][colCount];

        for (int i = 1; i <= rowCount; i++) {
            for (int j = 0; j < colCount; j++) {
                data[i - 1][j] = sheet.getRow(i).getCell(j).toString();
            }
        }
        book.close();
        fin.close();
        return data;
    }
}

package com.theTestingacademy.tests.SampleTestcases.DataDerivenTesting;

import io.qameta.allure.Description;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

import java.io.*;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class DataDrivenTesting {


    @Description("Testcase to create a excel sheet and insert the data")
    @Test
    public void testtoCreateExcelSheet() throws IOException {
       // Create data set
        Map<String,Object> data=new TreeMap<>();
        data.put("1",new Object[] {"LoginId","username","password"});
        data.put("2",new Object[] {"Admin1","pass@gmail.com","123456"});
        data.put("3",new Object[] {"Admin2","test@gmail.com","123456"});

        //  create a sheet with name Main and enter the above data set.In rows and cell .
        Set<String> keyset=data.keySet();
        XSSFWorkbook workbook=new XSSFWorkbook();
        XSSFSheet sheet= workbook.createSheet("Main");
        // take key data as   each row
        int rownum=0;
        for(String key:keyset)
        {
            Row row=sheet.createRow(rownum++);
            Object[] objectA=(Object[])data.get(key);
            int cellnum=0;
            for(Object celldata:objectA)
            {
                Cell cell=row.createCell(cellnum++);
                cell.setCellValue((String)celldata);
            }
        }
        // save the data on file name called TestDataCreated.xlsx.
        FileOutputStream outputfilename=new FileOutputStream(new File("TestDataCreated.xlsx"));
        workbook.write(outputfilename);
        outputfilename.close();

    }

    @Description(" Fetch the data from the above created excel sheet")
    @Test
    public void fetchDataFromExcelSheet() throws IOException {
        //get the file
        FileInputStream fileinput=new FileInputStream(new File("TestDataCreated.xlsx"));
        XSSFWorkbook workbook=new XSSFWorkbook(fileinput);
        XSSFSheet sheet=workbook.getSheetAt(0);
        Iterator<Row> rowIterator= sheet.iterator();
        while(rowIterator.hasNext())
        {
            Row r=rowIterator.next();
            Iterator<Cell> cellIterator= r.cellIterator();
            while(cellIterator.hasNext())
            {
                Cell c=cellIterator.next();
                System.out.println(c.getStringCellValue());
            }

        }
    }
}

package com.puregenomics.at.dataprovider;

import java.io.IOException;
import java.util.Map;

public class PrintExcelData {
	
	public static void main(String[] args) throws IOException {
		ReadExcelData ex = new ReadExcelData("D:\\PG3_Workspace\\PG3_Automation\\src\\test\\resources\\Questions.xlsx", 0);
        Map<String, Map<String, String>> excelData =ex.getExcelAsMap();
        //System.out.println("Excel Data for 2nd row and column- Questions : "+excelData.get("2").get("Questions"));
        System.out.println("excelData as Map: "+excelData);
}

}

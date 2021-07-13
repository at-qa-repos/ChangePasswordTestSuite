package com.changePassword.utils;

import java.io.FileInputStream;
import java.util.HashMap;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Row.MissingCellPolicy;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {

	static HashMap<String, String> HM;
	private static Workbook GetWorkBook(String path) throws Exception{
		Workbook wObj=null;
		FileInputStream fileInputStream = new FileInputStream(path);
		if(path.endsWith("xlsx")){
			wObj=new XSSFWorkbook(fileInputStream);
		}else{
			wObj=new HSSFWorkbook(fileInputStream);
		}
		return wObj;
	}

	public static HashMap<String, HashMap<String, String>> GetData(String path,String sheetName) throws Exception{
		HashMap<String, String> HM=new HashMap<String, String>();
		HashMap<String, HashMap<String, String>> HMM=new HashMap<String, HashMap<String, String>>();
		Workbook wObj=GetWorkBook(path);
		Sheet sheetObj=wObj.getSheet(sheetName);
		int rowCount=sheetObj.getLastRowNum();
		for(int i=1;i<=rowCount;i++){
			Row rowObj=sheetObj.getRow(i);
			String tcName=rowObj.getCell(0).getStringCellValue();
			int cellCount=rowObj.getLastCellNum()-1;
			for(int j=1;j<=cellCount;j+=2){
				Cell cellObj=rowObj.getCell(j, MissingCellPolicy.CREATE_NULL_AS_BLANK);
				String key=cellObj.getStringCellValue();
				Cell cellObjVal=rowObj.getCell(j+1, MissingCellPolicy.CREATE_NULL_AS_BLANK);
				String value=cellObjVal.getStringCellValue();
				HM.put(key, value);
			}
			HMM.put(tcName, HM);
		}
		return HMM;
	}	


	public static HashMap<String, String> GetTestCaseData(String path,String sheetName,String tcName) throws Exception{
		try{
			HM=new HashMap<String, String>();
			Workbook wObj=GetWorkBook(path);
			Sheet sheetObj=wObj.getSheet(sheetName);
			int rowCount=sheetObj.getLastRowNum();
			for(int i=1;i<=rowCount;i++){
				Row rowObj=sheetObj.getRow(i);
				String tcname=rowObj.getCell(0).getStringCellValue();
				if(tcName.equalsIgnoreCase(tcname)){
					int cellCount=rowObj.getLastCellNum()-1;
					for(int j=1;j<=cellCount;j+=2){
						Cell cellObj=rowObj.getCell(j, MissingCellPolicy.CREATE_NULL_AS_BLANK);
						String key=cellObj.getStringCellValue();
						Cell cellObjVal=rowObj.getCell(j+1, MissingCellPolicy.CREATE_NULL_AS_BLANK);
						String value=cellObjVal.getStringCellValue();
						HM.put(key, value);
					}
					break;
				}
			}
		}catch(Exception e){
			throw e;
		}
		return HM;
	}	


}

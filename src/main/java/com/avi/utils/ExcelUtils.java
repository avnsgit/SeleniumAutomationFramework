package com.avi.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.avi.constants.FrameworkConstants;
import com.avi.exceptions.IOExceptionForFileRead;
import com.avi.exceptions.InvalidPathForFilesException;

public final class ExcelUtils {

	private ExcelUtils() {

	}

	public static List<Map<String, String>> getTestDetails(String sheetName) {
		List<Map<String, String>> list = null;
		try (FileInputStream fis = new FileInputStream(FrameworkConstants.getExcelPath());
				XSSFWorkbook workBook = new XSSFWorkbook(fis);) {
			XSSFSheet sheet = workBook.getSheet(sheetName);
			int lastRowNum = sheet.getLastRowNum();
			int lastCellNum = sheet.getRow(0).getLastCellNum();
			Map<String, String> map = null;
			list = new ArrayList<>();
			for (int i = 1; i <= lastRowNum; i++) {
				map = new HashMap<>();
				for (int j = 0; j < lastCellNum; j++) {
					String key = sheet.getRow(0).getCell(j).getStringCellValue();
					String value = sheet.getRow(i).getCell(j).getStringCellValue();
					map.put(key, value);
				}
				list.add(map);
			}
		} catch (FileNotFoundException e) {
			throw new InvalidPathForFilesException("Excel File you try to read is not found");
		} catch (IOException e) {
			throw new IOExceptionForFileRead("Some io exception happened while reading excel file");
		}
		return list;
	}
}

package com.configproperties;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

import com.amazon.frameworkconstants.FrameworkConstants;

public class Data {

	public static Properties property = new Properties();

	@DataProvider(name = "getProductsData")
	public String[][] excelDataForProducts() throws IOException {
		File file = new File(System.getProperty("user.dir") + Data.property.getProperty("productsdatapath"));
		if (file.exists()) {
			FileInputStream fis = new FileInputStream(file);
			XSSFWorkbook workBook = new XSSFWorkbook(fis);
			int totalNoOfSheets = workBook.getNumberOfSheets();
			for (int i = 0; i < totalNoOfSheets; i++) {
				if (workBook.getSheetAt(i).getSheetName().equals("Sheet1")) {
					XSSFSheet sheet = workBook.getSheetAt(i);
					int noOfRows = sheet.getPhysicalNumberOfRows();
					int noOfColumns = sheet.getRow(0).getLastCellNum();
					String[][] productsData = new String[noOfRows - 1][noOfColumns];
					for (int row = 0; row < noOfRows - 1; row++) {
						for (int col = 0; col < noOfColumns; col++) {
							DataFormatter df = new DataFormatter();
							productsData[row][col] = df.formatCellValue(sheet.getRow(row + 1).getCell(col));
						}
					}
					return productsData;
				}
			}
		}
		return new String[0][0];

	}

	@DataProvider(name = "getRegistrationData")
	public Object[][] dataSupplier() {
		File file = new File(System.getProperty("user.dir") + Data.property.getProperty("registrationdatapath"));
		if (file.exists()) {
			FileInputStream fis;
			try {
				fis = new FileInputStream(file);
				XSSFWorkbook wb;
				wb = new XSSFWorkbook(fis);
				XSSFSheet sheet = wb.getSheetAt(0);
				wb.close();
				int lastRowNum = sheet.getLastRowNum();
				int lastCellNum = sheet.getRow(0).getLastCellNum();
				Object[][] obj = new Object[lastRowNum][1]; // Object[][1]
				Map<String, String> map;
				for (int row = 1; row <= lastRowNum; row++) {
					map = new HashMap<>();
					for (int col = 0; col < lastCellNum; col++) {
						String key = sheet.getRow(0).getCell(col).getStringCellValue();
						String value = sheet.getRow(row).getCell(col).getStringCellValue();
						map.put(key, value);
					}
					obj[row - 1][0] = map;
				}
				return obj;
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
		return new Object[0][0];
	}

	public static void readThePropertyFile() throws IOException {
		File file = new File(FrameworkConstants.getConfigFilePath());
		FileInputStream fis = null;
		try {
			if (Objects.isNull(fis)) {
				fis = new FileInputStream(file);
				property.load(fis);
			}
		} catch (Exception e) {
			e.getStackTrace();
		} finally {
			if (Objects.nonNull(fis)) {
				fis.close();
			}
		}

	}
}

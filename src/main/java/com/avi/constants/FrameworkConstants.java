package com.avi.constants;

import com.avi.enums.ConfigProperties;
import com.avi.utils.PropertyUtils;

public final class FrameworkConstants {

	private FrameworkConstants() {

	}

	private static final String RESOURCESPATH = System.getProperty("user.dir") + "/src/test/resources";
	private static final String CHROMEDRIVERPATH = RESOURCESPATH + "/executables/chromedriver.exe";
	private static final String GECKODRIVERPATH = RESOURCESPATH + "/executables/geckodriver.exe";
	private static final String CONFIGFILEPATH = RESOURCESPATH + "/config/config.properties";
	private static final String JSONFILEPATH = RESOURCESPATH + "/config/config.json";
	private static final String EXCELPATH = RESOURCESPATH + "/excel/testdata.xlsx";
	private static final String RUNMANAGERSHEET = "RUNMANAGER";
	private static final String ITERATIONDATASHEET = "DATA";
	private static final String EXTENTREPORTFOLDERPATH = System.getProperty("user.dir") + "/extent-test-output/";
	private static String extentReportFilePath = "";

	public static String getExtentReportFilePath() {
		if (extentReportFilePath.isEmpty()) {
			extentReportFilePath = createExtentReportPath();
		}
		return extentReportFilePath;
	}

	private static String createExtentReportPath() {
		if (PropertyUtils.get(ConfigProperties.OVERRIDEREPORTS).equalsIgnoreCase("no")) {
			return EXTENTREPORTFOLDERPATH + System.currentTimeMillis() + "/index.html";
		} else {
			return EXTENTREPORTFOLDERPATH + "/index.html";
		}
	}

	public static String getChromeDriverPath() {
		return CHROMEDRIVERPATH;
	}

	public static String getGeckoDriverPath() {
		return GECKODRIVERPATH;
	}

	public static String getConfigFilePath() {
		return CONFIGFILEPATH;
	}

	public static String getJsonFilePath() {
		return JSONFILEPATH;
	}

	public static String getExcelPath() {
		return EXCELPATH;
	}

	public static String getIterationDataSheet() {
		return ITERATIONDATASHEET;
	}

	public static String getRunManagerSheet() {
		return RUNMANAGERSHEET;
	}
}

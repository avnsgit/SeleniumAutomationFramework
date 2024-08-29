package com.avi.reports;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.avi.constants.FrameworkConstants;
import com.avi.enums.CategoryType;

public final class ExtentReport {

	private ExtentReport() {

	}

	private static ExtentReports extent;

	public static void initReports() {
		extent = new ExtentReports();
		ExtentSparkReporter spark = new ExtentSparkReporter(FrameworkConstants.getExtentReportFilePath());
		extent.attachReporter(spark);
		spark.config().setTheme(Theme.STANDARD);
		spark.config().setDocumentTitle("Automation Report");
		spark.config().setReportName("Selenium Test Report");
	}

	public static void flushReports() {
		if (Objects.nonNull(extent)) {
			extent.flush();
		}
		ExtentManager.unload();
		try {
			Desktop.getDesktop().browse(new File(FrameworkConstants.getExtentReportFilePath()).toURI());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void createTest(String testCaseName) {
		ExtentManager.setExtentTest(extent.createTest(testCaseName));
	}

	public static void addAuthors(String[] authors) {
		for (String temp : authors) {
			ExtentManager.getExtentTest().assignAuthor(temp);
		}
	}

	public static void addCategories(CategoryType[] authors) {
		for (CategoryType temp : authors) {
			ExtentManager.getExtentTest().assignCategory(temp.toString());
		}
	}
}

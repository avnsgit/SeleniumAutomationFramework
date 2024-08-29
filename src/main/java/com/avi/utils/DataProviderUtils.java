package com.avi.utils;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.testng.annotations.DataProvider;

import com.avi.constants.FrameworkConstants;

public final class DataProviderUtils {

	private DataProviderUtils() {

	}

	private static List<Map<String, String>> list = new ArrayList<>();

	@DataProvider(parallel = true)
	public static Object[] getData(Method m) {
		String testName = m.getName();
		if (list.isEmpty()) {
			list = ExcelUtils.getTestDetails(FrameworkConstants.getIterationDataSheet());
		}
		List<Map<String, String>> smallList = new ArrayList<>();
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).get("testname").equalsIgnoreCase(testName)
					&& (list.get(i).get("execute").equalsIgnoreCase("yes"))) {
				smallList.add(list.get(i));
			}
		}
		return smallList.toArray();
	}
}

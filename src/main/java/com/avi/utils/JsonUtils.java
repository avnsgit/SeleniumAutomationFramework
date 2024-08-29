package com.avi.utils;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import com.avi.constants.FrameworkConstants;
import com.avi.enums.JsonProperties;
import com.avi.exceptions.InvalidPathForFilesException;
import com.fasterxml.jackson.databind.ObjectMapper;

@SuppressWarnings("unchecked")
public final class JsonUtils {

	private JsonUtils() {

	}

	private static Map<String, String> configMAP = new HashMap<>();

	static {
		try {
			configMAP = new ObjectMapper().readValue(new File(FrameworkConstants.getJsonFilePath()), HashMap.class);
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(0);
		}
	}

	public static String get(JsonProperties key) {
		if (Objects.isNull(key) || Objects.isNull(configMAP.get(key.name().toLowerCase()))) {
			throw new InvalidPathForFilesException(
					"Property name " + key + " is not found. Please check config.properties");
		}
		return configMAP.get(key.name().toLowerCase());
	}
}

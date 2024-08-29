package com.avi.exceptions;

@SuppressWarnings("serial")
public class IOExceptionForFileRead extends FrameworkException {

	public IOExceptionForFileRead(String message) {
		super(message);
	}

	public IOExceptionForFileRead(String message, Throwable cause) {
		super(message, cause);
	}

}

package com.fis.exception;

public class ExceptionResponse {

	private String exception;
	private int statusCode;
	private String timeStamp;
	private String path;

	public ExceptionResponse() {
		super();
	}

	public ExceptionResponse(String exception, String path, int statusCode, String timeStamp) {
		super();
		this.exception = exception;
		this.path = path;
		this.statusCode = statusCode;
		this.timeStamp = timeStamp;
	}

	public String getException() {
		return exception;
	}

	public void setException(String exception) {
		this.exception = exception;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(String timeStamp) {
		this.timeStamp = timeStamp;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	public int getStatusCode() {
		return statusCode;
	}
}

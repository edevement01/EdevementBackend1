package com.edevement.startup.response;

import java.io.Serializable;

public class Status implements Serializable {

	private static final long serialVersionUID = 3865023819401469008L;
	private int statusCode;
	private String statusMessage;
	public int getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	public String getStatusMessage() {
		return statusMessage;
	}
	public void setStatusMessage(String statusMessage) {
		this.statusMessage = statusMessage;
	}
	
}

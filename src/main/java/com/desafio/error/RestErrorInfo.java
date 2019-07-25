package com.desafio.error;

import java.util.ArrayList;
import java.util.List;

public class RestErrorInfo {
	public List<String> detail;
	public String message;

	public RestErrorInfo() {

	}

	public RestErrorInfo(String ex, List<String> detail) {
		this.message = ex;
		this.detail = detail;
	}

	public RestErrorInfo(Exception ex) {
		this.message = ex.getLocalizedMessage();
	}

	public RestErrorInfo(String string, String localizedMessage) {
		this.message = string;
		this.detail = new ArrayList<>();
		this.detail.add(localizedMessage);
	}
}

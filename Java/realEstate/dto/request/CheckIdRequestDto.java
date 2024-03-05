package com.sangheon.realEstate.dto.request;

public class CheckIdRequestDto {

	private String id;
	
	public String getId() {
		return id;
	}
	
	// 값을 받아 옴 > 생성자, setter, 초기화
	public void setId(String id) {
		this.id = id;
	}

	public boolean validId() {
		boolean valid = id.length() < 20;
		return valid;
	}
}

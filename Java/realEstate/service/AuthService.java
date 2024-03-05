package com.sangheon.realEstate.service;

import com.sangheon.realEstate.dto.request.CheckIdRequestDto;
import com.sangheon.realEstate.dto.request.SendCodeRequestDto;
import com.sangheon.realEstate.dto.response.CheckIdResponseDto;
import com.sangheon.realEstate.dto.response.SendCodeResponseDto;

public interface AuthService {
	CheckIdResponseDto CheckId(CheckIdRequestDto dto);
	SendCodeResponseDto sendCode(SendCodeRequestDto dto);
}

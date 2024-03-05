package com.sangheon.realEstate.controller;

import com.sangheon.realEstate.dto.request.CheckIdRequestDto;
import com.sangheon.realEstate.dto.request.SendCodeRequestDto;
import com.sangheon.realEstate.dto.response.CheckIdResponseDto;
import com.sangheon.realEstate.dto.response.SendCodeResponseDto;


public interface AuthController {
	CheckIdResponseDto checkId(CheckIdRequestDto request);
	SendCodeResponseDto sendCode(SendCodeRequestDto sendCodeRequest);
	
}
    
package com.sangheon.realEstate.controller.implement;

import com.sangheon.realEstate.controller.AuthController;
import com.sangheon.realEstate.dto.request.CheckIdRequestDto;
import com.sangheon.realEstate.dto.request.SendCodeRequestDto;
import com.sangheon.realEstate.dto.response.CheckIdResponseDto;
import com.sangheon.realEstate.dto.response.SendCodeResponseDto;
import com.sangheon.realEstate.interfaces.Code;
import com.sangheon.realEstate.service.AuthService;
import com.sangheon.realEstate.service.implement.AuthServiceImplement;

public class AuthControllerImplement implements AuthController {

	private AuthService authService;
	public AuthControllerImplement (AuthService authService) {
		this.authService = authService;
	}
	
	@Override
	public CheckIdResponseDto checkId(CheckIdRequestDto request) {
		boolean validId = request.validId();
		if (!validId) return new CheckIdResponseDto(Code.VF, null);
		
		CheckIdResponseDto response = authService.CheckId(request);
		return response;
	}

	@Override
	public SendCodeResponseDto sendCode(SendCodeRequestDto request) {
		boolean validEmail = request.validEmail();
		if (!validEmail) return new SendCodeResponseDto(Code.VF, null);
		
		SendCodeResponseDto response = authService.sendCode(request);
		return response;
	}

}

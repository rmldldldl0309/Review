package com.example.board.dto.response;

public interface ResponseMessage {
    String SUCCESS = "Success";

    // 400
    String VALIDATION_FAILED = "Validation failed";
    String DUPLICATE_EMAIL = "Duplicate email";
    String DUPLICATE_NICKNAME = "Duplicate nickname";
    String DUPLICATE_TELEPHONE_NUMBER = "Duplicate telephone number";
    String THIS_USER_DOES_NOT_EXIST = "This user does not exist";
    String THIS_BOARD_DOES_NOT_EXIST = "This board does not exist";

    // 401
    String LOGIN_INFORMATION_MISMATCH = "Login information mismatch"; 
    String AUTHORIZAION_FAILED = "Authorization failed";

    //403 
    String DO_NOT_HAVE_PERMISSION = "Do not have permission";

    // 500
    String DATABASE_ERROR = "Database error";
}

package com.example.board.dto.response;

public interface ResponseCode {
    String SUCCESS = "SU";

    // 400
    String VALIDATION_FAILED = "VF";
    String DUPLICATE_EMAIL = "DE";
    String DUPLICATE_NICKNAME = "DN";
    String DUPLICATE_TELEPHONE_NUMBER = "DT";
    String THIS_USER_DOES_NOT_EXIST = "NU";
    String THIS_BOARD_DOES_NOT_EXIST = "NB";

    // 401
    String LOGIN_INFORMATION_MISMATCH = "SF"; 
    String AUTHORIZAION_FAILED = "AF";

    //403 
    String DO_NOT_HAVE_PERMISSION = "NP";

    // 500
    String DATABASE_ERROR = "DBE";
}

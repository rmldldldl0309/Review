package com.example.board.dto.Response.user;

// import java.util.ArrayList;
// import java.util.List;

// import org.apache.catalina.connector.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.example.board.dto.Response.ResponseCode;
import com.example.board.dto.Response.ResponseDto;
import com.example.board.dto.Response.ResponseMessage;

import lombok.Getter;

@Getter
public class GetUserResponseDto extends ResponseDto{
    private String email;
    private String nickName;
    private String profileImage;

    // private List<String> userList = new ArrayList<String>(){
    //     {
    //         add(email);
    //         add(nickName);
    //         add(profileImage);
    //     }
    // };

    // private GetUserDto(List<String> userList) {
    //     super(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);
    //     this.userList = userList;
    // }

    // private static ResponseEntity<GetUserDto> success (List<String> userList) {
    //     GetUserDto body = new GetUserDto(userList);
    //     return ResponseEntity.status(HttpStatus.OK).body(body);
    // }

    private GetUserResponseDto(String email, String nickName, String profileImage) {
        super(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);
        this.email = email;
        this.nickName = nickName;
        this.profileImage = profileImage;
    }

    public static ResponseEntity<GetUserResponseDto> success (String email, String nickName, String profileImage) {
        GetUserResponseDto body = new GetUserResponseDto(email, nickName, profileImage);
        return ResponseEntity.status(HttpStatus.OK).body(body);

    }

}

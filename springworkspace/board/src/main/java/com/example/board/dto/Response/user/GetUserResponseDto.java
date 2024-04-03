package com.example.board.dto.response.user;

// import java.util.ArrayList;
// import java.util.List;

// import org.apache.catalina.connector.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.example.board.dto.response.ResponseCode;
import com.example.board.dto.response.ResponseDto;
import com.example.board.dto.response.ResponseMessage;
import com.example.board.entity.UserEntity;

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

    private GetUserResponseDto(UserEntity userEntity) {
        super(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);
        this.email = userEntity.getEmail();
        this.nickName = userEntity.getNickname();
        this.profileImage = userEntity.getProfileImageUrl();
    }

    public static ResponseEntity<GetUserResponseDto> success (UserEntity userEntity) {
        GetUserResponseDto body = new GetUserResponseDto(userEntity);
        return ResponseEntity.status(HttpStatus.OK).body(body);

    }



}

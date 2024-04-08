package com.example.board.dto.request.user;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter@Getter@NoArgsConstructor
public class UpdateNicknameRequestDto {
    
    @NotBlank
    private String email;

    @NotBlank
    private String nickname;

}

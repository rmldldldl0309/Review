package com.example.board.dto.Request;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter@Setter@NoArgsConstructor
public class PostAuthRequestDto {
    
    @NotBlank
    private String email;
    @NotBlank
    private String password;
}

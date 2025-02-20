package com.guesthouse.assistpeople.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginDTO {

    @NotNull(message = "아이디를 입력해주세요")
    private String id;

    @NotNull(message = "비밀번호를 입력해주세요")
    private String password;
}

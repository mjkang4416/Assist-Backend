package com.guesthouse.assistpeople.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class UserDTO {
        private Long userId;
        @NotBlank(message = "이름을 입력해주세요")
        private String userName;
        @NotBlank(message = "아이디를 입력해주세요")
        private String id;
        @NotBlank(message = "비밀번호를 입력해주세요")
        private String password;
        private String Role;



//        public static UserDTO toDto(UserVO member) {
//            return new UserDTO(
//                    member.getUserId(),
//                    member.getUserName(),
//                    member.getId(),
//                    member.getPassword(),
//                    member.getRole()
//            );
//        }
}



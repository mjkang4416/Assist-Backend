package com.guesthouse.assistpeople.entity;

import com.guesthouse.assistpeople.dto.UserDTO;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.*;
import jakarta.persistence.Id;




@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class UserEntity {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long userId;

        @Column(unique = true,nullable = false)
        private String nickName;

        private String password,mbti,id,
                Introduce,reason,appeal,userPic;


        private String Role;




        public static UserEntity toVO(UserDTO memberDto) {
                return UserEntity.builder()
                        .id(memberDto.getId())
                        .nickName(memberDto.getUserName())
                        .password(memberDto.getPassword())
                        .build();
        }

}

//package com.guesthouse.assistpeople.entity;
//
//import com.guesthouse.assistpeople.dto.UserDTO;
//import jakarta.persistence.*;
//import lombok.*;
//
//@Getter
//@Setter
//@AllArgsConstructor
//@NoArgsConstructor
//@Builder
//public class UserEntity {
//
//        @Id
//        @GeneratedValue(strategy = GenerationType.IDENTITY)
//        private Long userId;
//
//        @Column(unique = true,nullable = false)
//        private String nickName;
//
//        private String password,mbti,id,
//                Introduce,reason,appeal,userPic;
//
//
//        private String Role;
//
//
//        public static UserEntity toVO(UserDTO memberDto) {
//                return UserEntity.builder()
//                        .id(memberDto.getId())
////                        .nickName(memberDto.getUserName())
//                        .password(memberDto.getPassword())
//                        .build();
//        }
//
//}

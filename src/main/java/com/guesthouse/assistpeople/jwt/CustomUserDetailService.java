//package com.guesthouse.assistpeople.jwt;
//
//import com.guesthouse.assistpeople.dto.UserDTO;
//import com.guesthouse.assistpeople.entity.UserEntity;
//import com.guesthouse.assistpeople.repository.UserRepository;
//import com.test.demo.domain.dto.UserDTO;
//import com.test.demo.domain.vo.UserVO;
//import com.test.demo.mapper.UserMapper;
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import java.util.Arrays;
//import java.util.Collection;
//
//@Service
//@RequiredArgsConstructor
//@Slf4j
//public class CustomUserDetailService implements UserDetailsService  {
//        private final UserRepository userRepository;	// 별도로 생성해야 함
//
//        //아이디로 로그인
//        @Override
//        public UserDetails loadUserByUsername(String id) {
//            UserEntity user = userRepository.loginID(id);
//            if(user == null){
//                throw new UsernameNotFoundException("해당하는 유저가 없습니다.");
//            }
//            UserDTO userDTO = UserDTO.toDto(user);
//
//            return new CustomUserDetail(userDTO);
//        }
//
//         private Collection<? extends GrantedAuthority> getAuthorities(UserEntity member) {
//             return Arrays.asList(new SimpleGrantedAuthority("ROLE_" + member.getRole()));
//        }
//
//
//    }
//

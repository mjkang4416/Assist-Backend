package com.guesthouse.assistpeople.controller;

import com.guesthouse.assistpeople.dto.ChatRoomDTO;
import com.guesthouse.assistpeople.dto.ChatRoomWithMessageDTO;
import com.guesthouse.assistpeople.entity.MessageEntity;
import com.guesthouse.assistpeople.jwt.CustomUserDetail;
import com.guesthouse.assistpeople.service.ChatRoomService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/chat")
@Slf4j
public class ChatRoomController {

        private final ChatRoomService chatRoomService;

        // 로그인한 사용자의 1대1 채팅방 목록 반환
        @GetMapping("/roomList")
        public List<ChatRoomWithMessageDTO> getMatchRooms(@AuthenticationPrincipal CustomUserDetail customUserDetails ) {
            return chatRoomService.getMatchRooms(customUserDetails);
        }

        // 특정 채팅방 조회(이전 채팅 기록 보여줌)
        @GetMapping("/room/{roomId}")
        public List<MessageEntity> getRoom(@PathVariable Long roomId) {
            return chatRoomService.roomDetail(roomId);
        }

        // 채팅방 생성
        @PostMapping("/room")
        public ChatRoomDTO createRoom(@RequestParam Long postId, @AuthenticationPrincipal CustomUserDetail customUserDetails) {
                log.info(customUserDetails.getUsername());
            return chatRoomService.createChatRoom(postId, customUserDetails.getUsername());
        }
}

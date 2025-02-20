package com.guesthouse.assistpeople.controller;

import com.guesthouse.assistpeople.dto.messageDTO;
import com.guesthouse.assistpeople.entity.UserEntity;
import com.guesthouse.assistpeople.repository.UserRepository;
import com.guesthouse.assistpeople.service.MassageService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
public class MessageController {
        // SimpMessageSendingOperations: 메시지를 특정 목적지로 전송하는 기능 제공
        private final SimpMessageSendingOperations template;
        private final UserRepository userRepository;
        private final MassageService messageService;

        /* 클라이언트가 메시지를 send하는 경로
         * WebSocketConfig에서 정의한 applicationDestinationPrefixes와 @MessageMapping 경로가 병합됨
         * /pub 으로 발행자가 메시지를 보내면 브로커가 /sub 경로로 구독자에게 메시지를 보냄
         */

        // 채팅방에 입장했을 때
        @MessageMapping(value = "/chat/enter")
        public void enterUser(messageDTO chat) {
            UserEntity user = userRepository.findByUserId(chat.getUserId());

            chat.setMessageContent(user.getNickName() + "님이 채팅방에 참여하였습니다.");
            log.info("📩 채팅방 입장: " + chat.toString());
            // "/sub/chat/room/" + chat.getRoomId() 해당 경로로 메시지를 전송함
            template.convertAndSend("/sub/chat/room/" + chat.getRoomId(), chat);
        }


        // 기본 채팅
        @MessageMapping(value = "/chat/message")
        public void sendMessage(messageDTO message) {
            messageDTO savedMessage = messageService.saveMessage(message); // 메시지 db에 저장
            template.convertAndSend("/sub/chat/room/"+savedMessage.getRoomId(), savedMessage);
        }



}

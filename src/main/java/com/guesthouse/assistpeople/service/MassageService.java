package com.guesthouse.assistpeople.service;

import com.guesthouse.assistpeople.dto.messageDTO;
import com.guesthouse.assistpeople.entity.ChatRoomEntity;
import com.guesthouse.assistpeople.entity.MessageEntity;
import com.guesthouse.assistpeople.entity.UserEntity;
import com.guesthouse.assistpeople.repository.ChatRoomRepository;
import com.guesthouse.assistpeople.repository.MessageRepository;
import com.guesthouse.assistpeople.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@RequiredArgsConstructor
public class MassageService {
    private final MessageRepository messageRepository;
    private final UserRepository userRepository;
    private final ChatRoomRepository chatRoomRepository;

    // 메시지 저장
    public messageDTO saveMessage(messageDTO messageDTO) {
        UserEntity user = userRepository.findByUserId(messageDTO.getUserId());

        ChatRoomEntity room = chatRoomRepository.findById(messageDTO.getRoomId()).get();
        MessageEntity message = messageRepository.save(MessageEntity.builder()
                .messageContent(messageDTO.getMessageContent())
                .sendTime(new Date()) // 현재 시간으로 전송 시간 설정
                .userId(user)
                .roomId(room)
                .build()
        );
        return convertDTO(message);
    }

    public messageDTO convertDTO(MessageEntity message) {
        messageDTO messageDTO = new messageDTO();
        messageDTO.setMessageId(message.getMessageId());
        messageDTO.setMessageContent(message.getMessageContent());
        messageDTO.setSendTime(message.getSendTime());
        messageDTO.setUserId(message.getUserId().getUserId());
        messageDTO.setRoomId(message.getRoomId().getRoomId());
        return messageDTO;
    }
}

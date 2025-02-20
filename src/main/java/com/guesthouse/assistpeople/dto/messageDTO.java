package com.guesthouse.assistpeople.dto;

import lombok.*;

import java.util.Date;
@AllArgsConstructor
@Builder
@NoArgsConstructor
@Getter
@Setter
public class messageDTO {
    // 메시지 타입: 입장, 채팅, 퇴장
    public enum MessageType{
        ENTER, TALK, LEAVE;
    }
    private Long messageId;
    private String messageContent;
    private Date sendTime;
    private Long userId;
    private Long roomId;
    private MessageType messageType;
}

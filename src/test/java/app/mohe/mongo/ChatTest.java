package app.mohe.mongo;

import app.mohe.chat.entity.Chat;
import app.mohe.chat.service.ChatService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
public class ChatTest {
    @Autowired
    private ChatService service;

    @Test
    @DisplayName("채팅 입력테스트")
    void saveChat(){
        Chat chat = new Chat();
        chat.setRoomId("11111");
        chat.setMessage("테스트입력");
        chat.setType(Chat.MessageType.TALK);
        chat.setSender("gaebabja");
        service.sendMsg(chat);
        System.out.println("입력완료");
    }

    @Test
    @DisplayName("채팅방 채팅조회 테스트")
    void lstChatByRoomId(){
        Chat chat = new Chat();
        chat.setRoomId("11111");
        List<Chat> chatList = service.lstChatByRoom(chat);
        for(Chat c : chatList){
            System.out.println("chat : "+c.toString());
        }
    }
}

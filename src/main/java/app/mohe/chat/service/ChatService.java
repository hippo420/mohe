package app.mohe.chat.service;

import app.mohe.chat.entity.Chat;
import app.mohe.chat.repository.ChatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChatService {

    @Autowired
    private ChatRepository chatRepository;

    public void sendMsg(Chat chat)
    {
        chatRepository.save(chat);
    }

    public List<Chat> lstChatByRoom(Chat chat) {
       return chatRepository.findByRoomId(chat.getRoomId());
    }
}

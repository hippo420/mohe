package app.mohe.chat.controller;

import app.mohe.chat.entity.Chat;
import app.mohe.chat.repository.ChatRepository;
import app.mohe.chat.service.ChatService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@Slf4j
@RestController
@RequestMapping("/api/chat/")
public class ChatController {
    @Autowired
    private ChatService service;

    @RequestMapping("sendMsg")
    public void sendMsg(@ModelAttribute Chat chat){
        log.info(chat.toString());
        service.sendMsg(chat);
    }

    @RequestMapping("lst")
    public List<Chat> lstChatByRoom(@RequestParam Chat chat){

        return service.lstChatByRoom(chat);
    }
}

package app.mohe.chat.controller;

import app.mohe.chat.entity.ChatRoom;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/chat")
public class ChatRoomController {

    @RequestMapping("makeRoom")
    public void makeRoom(){

    }

    @RequestMapping("findAll")
    public Map<ChatRoom,String> findAll(){
        Map<ChatRoom,String> map = new HashMap<ChatRoom,String>();

        return map;
    }
}


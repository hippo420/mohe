package app.mohe.chat.entity;

import lombok.Data;

@Data
public class Chat {
    public enum MessageType {
        ENTER, TALK, EXIT, MATCH, MATCH_REQUEST;
    }
    private MessageType type;
    private String roomId;
    private String sender;
    private String message;

}

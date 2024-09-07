package app.mohe.chat.entity;

import jakarta.persistence.Id;
import lombok.Data;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.lang.annotation.Documented;

@Data
@Document(collection ="chat")
public class Chat {
    public enum MessageType {
        ENTER, TALK, EXIT, MATCH, MATCH_REQUEST;
    }


    @Id
    @Indexed
    private String roomId;
    private MessageType type;
    private String sender;
    private String message;

}

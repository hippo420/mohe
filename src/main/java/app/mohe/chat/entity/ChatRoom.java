package app.mohe.chat.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class ChatRoom {
    @Id
    private String roomId;

    private String name;
}

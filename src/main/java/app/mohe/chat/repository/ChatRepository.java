package app.mohe.chat.repository;

import app.mohe.chat.entity.Chat;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ChatRepository extends MongoRepository<Chat,String> {
    List<Chat> findByRoomId(String roomId);
}

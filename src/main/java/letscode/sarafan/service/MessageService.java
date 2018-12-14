package letscode.sarafan.service;

import letscode.sarafan.model.Message;
import letscode.sarafan.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MessageService {

    private MessageRepository messageRepository;

    @Autowired
    public MessageService(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    public Optional<Message> getMessageById(String getMessageId) {
        return messageRepository.findById(getMessageId);
    }

    public List<Message> getAll() {
        return messageRepository.findAll();
    }

    public void deleteMessageById(String deleteMessageId) {
        messageRepository.deleteById(deleteMessageId);

    }

    public Message save(Message entity) {
        return messageRepository.save(entity);
    }


}

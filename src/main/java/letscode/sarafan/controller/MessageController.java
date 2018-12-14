package letscode.sarafan.controller;


import letscode.sarafan.model.Message;
import letscode.sarafan.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "message", produces = MediaType.APPLICATION_JSON_VALUE)
public class MessageController {


    private MessageService messageService;

    @Autowired
    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }


    @GetMapping("{id}")
    public Optional<Message> getOne(@PathVariable String id) {
        return messageService.getMessageById(id);

    }

    @GetMapping("/all")
    public List<Message> getAll() {
        return messageService.getAll();
    }

    @PostMapping(value = "/create", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void createMessage(@RequestBody Message message) {
        messageService.save(message);
    }


    @DeleteMapping("{id}")
    public void deleteOne(@PathVariable String id) {
        messageService.deleteMessageById(id);

    }


}

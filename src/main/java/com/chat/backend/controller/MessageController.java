package com.chat.backend.controller;

import com.chat.backend.model.Message;
import com.chat.backend.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/messages")
public class MessageController {

    @Autowired
    private MessageService messageService;

    @PostMapping
    public Message sendMessage(@RequestParam Long senderId,
                                @RequestParam Long chatRoomId,
                                @RequestParam String content) {
        return messageService.sendMessage(senderId, chatRoomId, content);
    }

    @GetMapping
    public List<Message> getAllMessages() {
        return messageService.getAllMessages();
    }

    @GetMapping("/{id}")
    public Message getMessageById(@PathVariable Long id) {
        return messageService.getMessageById(id);
    }

    @GetMapping("/chatroom/{chatRoomId}")
    public List<Message> getMessagesByChatRoom(@PathVariable Long chatRoomId) {
        return messageService.getMessagesByChatRoom(chatRoomId);
    }

    @DeleteMapping("/{id}")
    public void deleteMessage(@PathVariable Long id) {
        messageService.deleteMessage(id);
    }
}   
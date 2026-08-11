package com.chat.backend.service;

import com.chat.backend.model.Message;
import com.chat.backend.model.User;
import com.chat.backend.model.ChatRoom;
import com.chat.backend.repository.MessageRepository;
import com.chat.backend.repository.UserRepository;
import com.chat.backend.repository.ChatRoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService {

    @Autowired
    private MessageRepository messageRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ChatRoomRepository chatRoomRepository;

    public Message sendMessage(Long senderId, Long chatRoomId, String content) {
        User sender = userRepository.findById(senderId)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + senderId));

        ChatRoom chatRoom = chatRoomRepository.findById(chatRoomId)
                .orElseThrow(() -> new RuntimeException("ChatRoom not found with id: " + chatRoomId));

        Message message = new Message();
        message.setContent(content);
        message.setSender(sender);
        message.setChatRoom(chatRoom);

        return messageRepository.save(message);
    }

    public List<Message> getAllMessages() {
        return messageRepository.findAll();
    }

    public Message getMessageById(Long id) {
        return messageRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Message not found with id: " + id));
    }

    public List<Message> getMessagesByChatRoom(Long chatRoomId) {
        return messageRepository.findAll().stream()
                .filter(m -> m.getChatRoom().getId().equals(chatRoomId))
                .toList();
    }

    public void deleteMessage(Long id) {
        messageRepository.deleteById(id);
    }
}
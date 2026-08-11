package com.chat.backend.service;

import com.chat.backend.model.ChatRoom;
import com.chat.backend.repository.ChatRoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChatRoomService {

    @Autowired
    private ChatRoomRepository chatRoomRepository;

    public ChatRoom createChatRoom(ChatRoom chatRoom) {
        return chatRoomRepository.save(chatRoom);
    }

    public List<ChatRoom> getAllChatRooms() {
        return chatRoomRepository.findAll();
    }

    public ChatRoom getChatRoomById(Long id) {
        return chatRoomRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("ChatRoom not found with id: " + id));
    }

    public ChatRoom updateChatRoom(Long id, ChatRoom roomDetails) {
        ChatRoom room = getChatRoomById(id);
        room.setRoomName(roomDetails.getRoomName());
        return chatRoomRepository.save(room);
    }

    public void deleteChatRoom(Long id) {
        chatRoomRepository.deleteById(id);
    }
}
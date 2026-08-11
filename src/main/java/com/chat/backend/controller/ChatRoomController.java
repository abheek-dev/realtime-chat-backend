package com.chat.backend.controller;

import com.chat.backend.model.ChatRoom;
import com.chat.backend.service.ChatRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/chatrooms")
public class ChatRoomController {

    @Autowired
    private ChatRoomService chatRoomService;

    @PostMapping
    public ChatRoom createChatRoom(@RequestBody ChatRoom chatRoom) {
        return chatRoomService.createChatRoom(chatRoom);
    }

    @GetMapping
    public List<ChatRoom> getAllChatRooms() {
        return chatRoomService.getAllChatRooms();
    }

    @GetMapping("/{id}")
    public ChatRoom getChatRoomById(@PathVariable Long id) {
        return chatRoomService.getChatRoomById(id);
    }

    @PutMapping("/{id}")
    public ChatRoom updateChatRoom(@PathVariable Long id, @RequestBody ChatRoom chatRoom) {
        return chatRoomService.updateChatRoom(id, chatRoom);
    }

    @DeleteMapping("/{id}")
    public void deleteChatRoom(@PathVariable Long id) {
        chatRoomService.deleteChatRoom(id);
    }
}
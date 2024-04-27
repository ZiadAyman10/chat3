package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dao.ChatMessageDAO;
import com.example.demo.entity.*;

@Service
public class ChatMessageService {
    private ChatMessageDAO chatMessageDAO;
    @Autowired
    public ChatMessageService(ChatMessageDAO chatMessageDAO) {
        this.chatMessageDAO = chatMessageDAO;
    }
    public List<ChatMessage>getAllMessages(String person1,String person2){
        return chatMessageDAO.getAllMessages(person1,person2);
    }
    @Transactional
    public ChatMessage addMessage(ChatMessage chatMessage){
        ChatMessage theChatMessage=chatMessageDAO.addMessage(chatMessage);
        return theChatMessage;
    }
}

package com.example.demo.rest;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.entity.*;
import com.example.demo.service.ChatMessageService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api")
public class ChatMessageRestController {
    private ChatMessageService chatMessageService;
    
    public ChatMessageRestController(ChatMessageService chatMessageService) {
        this.chatMessageService = chatMessageService;
    }

    @GetMapping("/chat/{person1}/{person2}")
    public List<ChatMessage> getAllMessages(@PathVariable("person1") int person1,@PathVariable("person2") int person2) {
        return chatMessageService.getAllMessages(person1,person2);
    }
    @PostMapping("/chat")
    public ChatMessage sendMessage(@RequestBody ChatMessage message) {
        ChatMessage theMessage = chatMessageService.addMessage(message);
        return theMessage;
    }
    
}

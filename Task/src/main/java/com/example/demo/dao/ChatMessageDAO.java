package com.example.demo.dao;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.example.demo.entity.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import java.util.Comparator; // Import Comparator for sorting
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.time.ZoneId;

@Repository
public class ChatMessageDAO {
    EntityManager entityManager;
    @Autowired
    public ChatMessageDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
        
    public List<ChatMessage> getAllMessages(String person1,String person2){
        TypedQuery<ChatMessage> theQuery = entityManager.createQuery("SELECT c FROM ChatMessage c WHERE (c.id_sender = :sender1 AND c.id_receiver = :receiver1) OR (c.id_sender = :sender2 AND c.id_receiver = :receiver2)", ChatMessage.class);
        theQuery.setParameter("sender1", person1);
        theQuery.setParameter("receiver1", person2);
        theQuery.setParameter("sender2", person2);
        theQuery.setParameter("receiver2", person1);

        List<ChatMessage> chat = theQuery.getResultList();
        return getSortedMessages(chat);
    }

    public List<ChatMessage> getSortedMessages(List<ChatMessage> messages) {
        // Sort messages by timestamp using Comparator
        //messages.sort(Comparator.comparing(ChatMessage::getTimestamp).reversed());
        messages.sort(Comparator.comparing(ChatMessage::getTimestamp));
        return messages;
    }

    public ChatMessage addMessage(ChatMessage message){
        message.setId(0);
        message.setTimestamp(convertToCairoLocalDateTime(System.currentTimeMillis()));
        ChatMessage theChatMessage = entityManager.merge(message);
        return theChatMessage;
    }

    private LocalDateTime convertToCairoLocalDateTime(long millis) {
        ZoneId cairoZoneId = ZoneId.of("Africa/Cairo");
        return LocalDateTime.ofInstant(java.time.Instant.ofEpochMilli(millis), cairoZoneId);
    }
}

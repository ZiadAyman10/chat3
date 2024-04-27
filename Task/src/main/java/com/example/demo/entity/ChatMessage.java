package com.example.demo.entity;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "chat")
public class ChatMessage {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "id_sender")
    private String id_sender;
    @Column(name = "id_receiver")
    private String id_receiver;
    @Column(name = "content")
    private String content;
    @Column(name = "timestamp")
    private LocalDateTime timestamp;

    // Constructors
    public ChatMessage() {
    }

    public ChatMessage(String id_sender, String id_receiver, String content) {
        this.id_sender = id_sender;
        this.id_receiver = id_receiver;
        this.content = content;
    }

    // Getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getId_sender() {
        return id_sender;
    }

    public void setId_sender(String id_sender) {
        this.id_sender = id_sender;
    }

    public String getId_receiver() {
        return id_receiver;
    }

    public void setId_receiver(String id_receiver) {
        this.id_receiver = id_receiver;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    // toString method for easy printing
    @Override
    public String toString() {
        return "ChatMessage{" +
                "id=" + id +
                ", id_sender='" + id_sender + '\'' +
                ", id_receiver='" + id_receiver + '\'' +
                ", content='" + content + '\'' +
                ", timestamp=" + timestamp +
                '}';
    }
}


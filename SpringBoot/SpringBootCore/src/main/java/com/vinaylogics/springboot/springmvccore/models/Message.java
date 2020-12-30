package com.vinaylogics.springboot.springmvccore.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

public class Message implements Serializable {

    private static final long serialVersionUID = -1552876852960468015L;

    private Long id;
    private String message;
    private String name;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime messageTime = LocalDateTime.now();

    public Message() {
    }

    public Message(Long id, String message) {
        this.id = id;
        this.message = message;
    }

    public Message(Long id, String message, LocalDateTime messageTime) {
        this.id = id;
        this.message = message;
        this.messageTime = messageTime;
    }

    public Message(Long id, String name,String message,  LocalDateTime messageTime) {
        this.id = id;
        this.name = name;
        this.message = message;
        this.messageTime = messageTime;
    }

    public Message(String name, String message,  LocalDateTime messageTime) {
        this.name = name;
        this.message = message;
        this.messageTime = messageTime;
    }

    public Message( String name, String message) {
        this.name = name;
        this.message = message;
    }

    public Message(String message) {
        this.message = message;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDateTime getMessageTime() {
        return messageTime;
    }

    public void setMessageTime(LocalDateTime messageTime) {
        this.messageTime = messageTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Message message1 = (Message) o;
        return Objects.equals(id, message1.id) && Objects.equals(message, message1.message) && Objects.equals(name, message1.name) && Objects.equals(messageTime, message1.messageTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, message, name, messageTime);
    }

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", message='" + message + '\'' +
                ", messageTime=" + messageTime +
                '}';
    }
}

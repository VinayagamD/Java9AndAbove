package com.vinaylogics.springboot.springaop.models;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name="messages")
@NamedQueries({
 @NamedQuery(
  name = "findById",
         query = "FROM Message m WHERE id=:id"
 )})
public class Message extends BaseModel {

    private String name;
    private String message;

    @Column(name = "message_time", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime messageTime = LocalDateTime.now();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Message message1 = (Message) o;
        return Objects.equals(name, message1.name) && Objects.equals(message, message1.message) && Objects.equals(messageTime, message1.messageTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), name, message, messageTime);
    }

    @Override
    public String toString() {
        return "Message{" +
                "base = '" + super.toString()+'\''+
                "name='" + name + '\'' +
                ", message='" + message + '\'' +
                ", messageTime=" + messageTime +
                '}';
    }
}

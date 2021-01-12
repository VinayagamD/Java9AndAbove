package com.vinaylogics.springboot.springmvccore.dtos;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class ErrorDataDTO implements Serializable {

    private List<String> messages;
    private List<String> keys;
    private Builder builder;

    public ErrorDataDTO() {
    }

    public ErrorDataDTO(Builder builder) {
        messages = builder.messages;
        keys = builder.keys;
        this.builder = builder;
    }

    public List<String> getMessages() {
        return messages;
    }

    public void setMessages(List<String> messages) {
        this.messages = messages;
    }

    public List<String> getKeys() {
        return keys;
    }

    public void setKeys(List<String> keys) {
        this.keys = keys;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ErrorDataDTO that = (ErrorDataDTO) o;
        return Objects.equals(messages, that.messages) && Objects.equals(keys, that.keys);
    }

    @Override
    public int hashCode() {
        return Objects.hash(messages, keys);
    }

    @Override
    public String toString() {
        return "ErrorDataDTO{" +
                "messages=" + messages +
                ", keys=" + keys +
                '}';
    }

    public static class Builder {
        private List<String> messages;
        private List<String> keys;

        public Builder message(List<String> messages) {
            this.messages = messages;
            return this;
        }

        public Builder keys(List<String> keys) {
            this.keys = keys;
            return this;
        }

        public ErrorDataDTO build(){
            return new ErrorDataDTO(this);
        }
    }
}

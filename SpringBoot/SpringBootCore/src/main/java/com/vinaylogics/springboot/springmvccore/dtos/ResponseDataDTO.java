package com.vinaylogics.springboot.springmvccore.dtos;

import java.io.Serializable;
import java.util.Objects;

public class ResponseDataDTO<T> implements Serializable {

    private boolean success;
    private String message;
    private ErrorDataDTO error;
    private T data;
    private Builder<T> builder;

    public ResponseDataDTO() {
    }

    public ResponseDataDTO(Builder<T> builder) {
        success = builder.success;
        message = builder.message;
        error = builder.error;
        data = builder.data;
        this.builder = builder;
    }


    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ErrorDataDTO getError() {
        return error;
    }

    public void setError(ErrorDataDTO error) {
        this.error = error;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ResponseDataDTO<?> that = (ResponseDataDTO<?>) o;
        return success == that.success && Objects.equals(message, that.message) && Objects.equals(error, that.error) && Objects.equals(data, that.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(success, message, error, data);
    }

    @Override
    public String toString() {
        return "ResponseDataDTO{" +
                "success=" + success +
                ", message='" + message + '\'' +
                ", error=" + error +
                ", data=" + data +
                '}';
    }

    public static class Builder<T>{
        private boolean success;
        private String message;
        private ErrorDataDTO error;
        private T data;

        public Builder<T> success(boolean success) {
            this.success = success;
            return this;
        }

        public Builder<T> message(String message) {
            this.message = message;
            return this;
        }

        public Builder<T> error(ErrorDataDTO error) {
            this.error = error;
            return this;
        }

        public Builder<T> data(T data) {
            this.data = data;
            return this;
        }

        public ResponseDataDTO<T> build(){
            return new ResponseDataDTO<>(this);
        }
    }
}

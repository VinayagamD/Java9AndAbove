package com.vinaylogics.schoolmanagement.dto;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.vinaylogics.schoolmanagement.utils.SchoolUtils;
import com.vinaylogics.schoolmanagement.utils.dataconverter.LocalDateTimeAdapter;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

public class ResponseData<T> implements Serializable {

    private boolean success = false;
    private T data;
    private String message;
    private int statusCode;

    public ResponseData(boolean success, T data, String message, int statusCode) {
        this.success = success;
        this.data = data;
        this.message = message;
        this.statusCode = statusCode;
    }

    public ResponseData() {
    }

    public static String toJson(ResponseData responseData){

        return SchoolUtils.getGson().toJson(responseData);
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ResponseData<?> that = (ResponseData<?>) o;
        return success == that.success &&
                statusCode == that.statusCode &&
                Objects.equals(data, that.data) &&
                Objects.equals(message, that.message);
    }

    @Override
    public int hashCode() {
        return Objects.hash(success, data, message, statusCode);
    }

    @Override
    public String toString() {
        return "ResponseData{" +
                "success=" + success +
                ", data=" + data +
                ", message='" + message + '\'' +
                ", statusCode=" + statusCode +
                '}';
    }
}

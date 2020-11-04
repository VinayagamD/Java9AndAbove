package com.vinaylogics.springbasics.core.xml;

import java.util.Objects;

public class HelloIndia {
    private String message1;
    private String message2;
    private String message3;

    public String getMessage1() {
        return message1;
    }

    public void setMessage1(String message1) {
        this.message1 = message1;
    }

    public String getMessage2() {
        return message2;
    }

    public void setMessage2(String message2) {
        this.message2 = message2;
    }

    public String getMessage3() {
        return message3;
    }

    public void setMessage3(String message3) {
        this.message3 = message3;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HelloIndia that = (HelloIndia) o;
        return Objects.equals(message1, that.message1) &&
                Objects.equals(message2, that.message2) &&
                Objects.equals(message3, that.message3);
    }

    @Override
    public int hashCode() {
        return Objects.hash(message1, message2, message3);
    }

    @Override
    public String toString() {
        return "HelloIndia{" +
                "message1='" + message1 + '\'' +
                ", message2='" + message2 + '\'' +
                ", message3='" + message3 + '\'' +
                '}';
    }
}

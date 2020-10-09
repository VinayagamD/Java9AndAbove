package com.vinaylogics.librarymanagement.librarymodel.model;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class User extends BaseModel {

    private static final long serialVersionUID = 6352196668019535353L;
    private String name;
    private String password;
    private String userId;
    private String email;
    private String phoneNumber;
    private Set<UserType> types = new HashSet<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Set<UserType> getTypes() {
        return types;
    }

    public void setTypes(Set<UserType> types) {
        this.types = types;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        User user = (User) o;
        return Objects.equals(name, user.name) &&
                Objects.equals(password, user.password) &&
                Objects.equals(userId, user.userId) &&
                Objects.equals(email, user.email) &&
                Objects.equals(phoneNumber, user.phoneNumber) &&
                Objects.equals(types, user.types);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), name, password, userId, email, phoneNumber, types);
    }

    @Override
    public String toString() {
        return "User{" +
                "baseModel='"+super.toString()+'\''+
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", userId='" + userId + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", types=" + types +
                '}';
    }
}

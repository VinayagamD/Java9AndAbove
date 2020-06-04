package com.vinaylogics.schoolmanagement.models;

import java.time.LocalDateTime;
import java.util.Objects;

public class User extends BaseModel {

    private String name;
    private String userId;
    private Gender gender;
    private Role role;

    /**
     *
     */
    public User() {
    }

    /**
     *
     * @param name
     * @param userId
     * @param gender
     * @param role
     */
    public User(String name, String userId, Gender gender, Role role) {
        this.name = name;
        this.userId = userId;
        this.gender = gender;
        this.role = role;
    }

    /**
     *
     * @param id
     * @param name
     * @param userId
     * @param gender
     * @param role
     * @param createdAt
     * @param updatedAt
     */
    public User(Long id, String name, String userId, Gender gender, Role role , LocalDateTime createdAt, LocalDateTime updatedAt){
        this.id = id;
        this.name = name;
        this.userId = userId;
        this.gender = gender;
        this.role = role;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        User user = (User) o;
        return Objects.equals(name, user.name) &&
                Objects.equals(userId, user.userId) &&
                gender == user.gender &&
                role == user.role;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), name, userId, gender, role);
    }

    @Override
    public String toString() {
        return "User{"+super.toString() +
                "name='" + name + '\'' +
                ", userId='" + userId + '\'' +
                ", gender=" + gender +
                ", role=" + role +
                '}';
    }
}

package com.vinaylogics.springbasics.security.models;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "users")
@NamedQueries({
        @NamedQuery(name = "findAll", query = "FROM User u"),
        @NamedQuery(name = "findById", query = "FROM User u  WHERE u.id = :id"),
        @NamedQuery(name = "findByUsername", query = "FROM User u  WHERE u.username = :username")
})
public class User extends BaseModel{
    private String username;
    private String password;
    private String passwordConfirm;
    @ManyToMany
    @JoinTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPasswordConfirm() {
        return passwordConfirm;
    }

    public void setPasswordConfirm(String passwordConfirm) {
        this.passwordConfirm = passwordConfirm;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}

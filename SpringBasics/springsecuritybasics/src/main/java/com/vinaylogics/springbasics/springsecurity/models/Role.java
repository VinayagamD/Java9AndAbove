package com.vinaylogics.springbasics.springsecurity.models;

import javax.persistence.*;
import java.util.Set;

@Entity
@NamedQueries({
        @NamedQuery(name = "findAllRole",query = "FROM Role r")
})
@Table(name = "roles")
public class Role extends BaseModel {
    private String name;
    @ManyToMany(mappedBy = "roles")
    private Set<User> users;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }
}

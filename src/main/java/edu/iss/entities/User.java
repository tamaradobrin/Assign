package edu.iss.entities;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {

    @Id
    private String username;
    private String password;
    @Enumerated(EnumType.STRING)
    private Group usergroup;

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

    public Group getUsergroup() {
        return usergroup;
    }

    public void setUsergroup(Group usergroup) {
        this.usergroup = usergroup;
    }
}


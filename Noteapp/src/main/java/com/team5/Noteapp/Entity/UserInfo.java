package com.team5.Noteapp.Entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class UserInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne(cascade = CascadeType.ALL)
    private User user;

    @Column(unique = true)
    private String username;

    private String password;

    private boolean isActive;

    @Override
    public String toString() {
        return "UserInfo{" +
                "id=" + id +
                ", user=" + user +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                 ", isActive=" + isActive +
                '}';
    }
}
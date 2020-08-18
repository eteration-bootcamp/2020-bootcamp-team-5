package com.team5.Noteapp.Entity;

import javax.persistence.*;

import com.team5.Noteapp.Validator.Email;
import com.team5.Noteapp.Validator.PhoneNumber;
import lombok.Data;
import org.checkerframework.common.aliasing.qual.Unique;

@Entity
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String surname;

    @PhoneNumber
    @Unique
    private String phoneNumber;

    @Email
    @Unique
    private String mail;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", mail='" + mail + '\'' +
                '}';
    }
}

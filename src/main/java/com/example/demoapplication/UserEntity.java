package com.example.demoapplication;


import com.fasterxml.jackson.databind.ser.std.TimeZoneSerializer;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "users")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    @CreationTimestamp
    private Timestamp created_at;
    private String email;
    private String password;

    public UserEntity(Long userId, Timestamp created_at, String email, String password){
        this.userId = userId;
        this.created_at = created_at;
        this.email = email;
        this.password = password;
    }
    public UserEntity(){

    }
    public Long getUserId(){
        return userId;
    }
    public Timestamp getCreated_at(){
        return created_at;
    }
    public String getEmail(){
        return email;
    }
    public String getPassword(){
        return password;
    }
    public void setUserId(Long userId){
        this.userId = userId;
    }
    public void setCreated_at(Timestamp created_at){
        this.created_at = created_at;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public void setPassword(String password){
        this.password = password;
    }
}

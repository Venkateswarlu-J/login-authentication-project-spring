package com.LoginJv.demo.loginEntity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String uName;
    private String password;
    private String gmail;
    public User(){}
    public User(String uName, String gmail, String password) {
        this.uName = uName;
        this.gmail = gmail;
        this.password=password;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }



    public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        this.uName = uName;
    }

    public String getGmail() {
        return gmail;
    }

    public void setGmail(String gmail) {
        this.gmail = gmail;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", uName=" + uName +
                ", gmail='" + gmail + '\'' +
                '}';
    }
}

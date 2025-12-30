package com.LoginJv.demo.loginEntity;


import jakarta.persistence.*;
import org.hibernate.annotations.Columns;

import java.util.Date;

@Entity
public class Feedback {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int S_NO;
    @Column
    private String gmail;
    @Column
    private String userName;
    @Column
    private String msg;
    @Column
    private Date date;

    public Feedback(){}
    public Feedback(String gmail,String userName,String msg){
        setGmail(gmail);
        setUserName(userName);
        setMsg(msg);
        setDate(new Date());
    }

    public int getS_NO() {
        return S_NO;
    }

    public void setS_NO(int s_NO) {
        S_NO = s_NO;
    }

    public String getGmail() {
        return gmail;
    }

    public void setGmail(String gmail) {
        this.gmail = gmail;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Feedback{" +
                "S_NO=" + S_NO +
                ", gmail='" + gmail + '\'' +
                ", userName='" + userName + '\'' +
                ", msg='" + msg + '\'' +
                ", date=" + date +
                '}';
    }

}

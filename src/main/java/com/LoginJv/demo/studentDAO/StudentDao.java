package com.LoginJv.demo.studentDAO;

import com.LoginJv.demo.loginEntity.User;

import java.util.List;

public interface StudentDao {

    public void save(User user);
    public List<User> getStudents();
    public User findByIdentity(String name);
    public void updatePass(User user,String newPass);
}

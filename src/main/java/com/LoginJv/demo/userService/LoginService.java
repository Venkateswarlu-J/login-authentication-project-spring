package com.LoginJv.demo.userService;


import com.LoginJv.demo.loginEntity.User;
import com.LoginJv.demo.studentDAO.StudentDao;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Service
public class LoginService {
    @Autowired
    private StudentDao studentDao;

    public String generateOtp(){
        return String.valueOf(((int)(Math.random()*900000)+100000));
    }

    public User find(String email){
        return studentDao.findByIdentity(email);

    }

    public void register(User user){
        studentDao.save(user);
    }
    public User authenticateUser(String identity,String pass){
        User user=studentDao.findByIdentity(identity);
        return user!=null&&user.getPassword().equals(pass)?user:null;

    }
    public List<User> getAll(){
        return studentDao.getStudents();
    }
    public void update(String email, String newPass ){
//        System.out.println(newPass);
        User user=studentDao.findByIdentity(email);
        studentDao.updatePass(user,newPass);
    }
}

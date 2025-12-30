package com.LoginJv.demo.studentDAO;

import com.LoginJv.demo.loginEntity.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.autoconfigure.WebMvcProperties;
import org.springframework.stereotype.Repository;

import java.lang.reflect.Type;
import java.util.List;

@Repository
public class StudnetDAO implements StudentDao{

    @Autowired
    private EntityManager entityManager;
    @Transactional
    public void save(User user) {
        TypedQuery<User> query=entityManager.createQuery("select u from User u where u.gmail=:gmail",User.class);
        query.setParameter("gmail",user.getGmail());
        List<User> users=query.getResultList();
        if (!users.isEmpty()) {
            System.out.println("The email is already existed! Please login");
        } else {
            entityManager.persist(user);
            System.out.println("Registered Successfully");
        }
    }
    public User findByIdentity(String identity){
        TypedQuery<User> query=entityManager.createQuery("select u from User u where u.uName=:identity or u.gmail=:identity",User.class);
        query.setParameter("identity",identity);
        List<User> user=query.getResultList();
        return user.isEmpty()?null:user.get(0);
    }

    public List<User> getStudents(){
        TypedQuery<User> list=entityManager.createQuery("from User",User.class);
        return list.getResultList();
    }
    @Transactional
    public void updatePass(User user,String newPass){
        user.setPassword(newPass);
        entityManager.merge(user);
    }
}

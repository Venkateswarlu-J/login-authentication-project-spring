package com.LoginJv.demo.feedbackDAO;

import com.LoginJv.demo.loginEntity.Feedback;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.parser.Entity;

@Repository
public class FeedBackService implements FeedBackDAO{
    @Autowired
    EntityManager entityManager;

    @Transactional
    public void insert(Feedback feedback){
        entityManager.persist(feedback);
    }
}

package com.LoginJv.demo.feedbackDAO;

import com.LoginJv.demo.loginEntity.Feedback;
import org.springframework.stereotype.Component;

@Component
public interface FeedBackDAO {
    public void insert(Feedback feedback);
}

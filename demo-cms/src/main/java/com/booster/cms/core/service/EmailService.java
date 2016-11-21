package com.booster.cms.core.service;

import org.springframework.mail.SimpleMailMessage;

import com.booster.cms.web.domain.frontend.FeedbackForm;

public interface EmailService {

    /**
     * Sends an email with the content in the feedback.
     * 
     * @param feedback
     */
    public void sendFeedbackEmail(FeedbackForm feedback);

    /**
     * Sends an email with the simple mail message content.
     * 
     * @param mailMessage
     */
    public void sendGenericEmail(SimpleMailMessage mailMessage);

}

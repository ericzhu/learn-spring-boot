package com.booster.cms.core.service.spring;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;

import com.booster.cms.core.service.EmailService;
import com.booster.cms.web.domain.frontend.FeedbackForm;

public abstract class EmailServiceAbstract implements EmailService {

    @Value("${mail.default.to.address}")
    private String defaultToAddress;

    protected SimpleMailMessage prepareSimpleMailMessageFromFeedback(FeedbackForm feedback) {
        SimpleMailMessage message = new SimpleMailMessage();

        message.setTo(defaultToAddress);
        message.setFrom(feedback.getEmail());
        message.setSubject("Feedback from " + feedback.getName());
        message.setText(feedback.getFeedback());

        return message;
    }

    @Override
    public void sendFeedbackEmail(FeedbackForm feedback) {
        sendGenericEmail(prepareSimpleMailMessageFromFeedback(feedback));
    }

}

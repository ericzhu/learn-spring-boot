package com.booster.cms.core.service.spring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.SimpleMailMessage;

public class EmailServiceMockImpl extends EmailServiceAbstract {

    private static final Logger LOGGER = LoggerFactory.getLogger(EmailServiceMockImpl.class);

    @Override
    public void sendGenericEmail(SimpleMailMessage mailMessage) {
        LOGGER.debug("Simulating email service ...");
        LOGGER.info("to: {}", mailMessage.getTo()[0]);
        LOGGER.info("from: {}", mailMessage.getFrom());
        LOGGER.info("Subject: {}", mailMessage.getSubject());
        LOGGER.info("Content: {}", mailMessage.getText());
    }

}

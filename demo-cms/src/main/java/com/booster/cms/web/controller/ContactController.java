package com.booster.cms.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.booster.cms.core.service.EmailService;
import com.booster.cms.web.domain.frontend.FeedbackForm;

@Controller
public class ContactController {

    private static final Logger LOGGER             = LoggerFactory.getLogger(ContactController.class);

    public static final String  FEEDBACK_MODEL_KEY = "feedback";
    public static final String  CONTACT_VIEW_NAME  = "contact/contact";

    @Autowired
    private EmailService        emailService;

    @GetMapping(value = "/contact")
    public String showContactPage(Model uiModel) {
        uiModel.addAttribute(FEEDBACK_MODEL_KEY, new FeedbackForm());
        return CONTACT_VIEW_NAME;
    }

    @PostMapping(value = "/contact")
    public String createContact(@ModelAttribute(name = "feedback") FeedbackForm feedback) {
        LOGGER.debug("FeedBack: {}", feedback.toString());
        
        emailService.sendFeedbackEmail(feedback);
        
        return CONTACT_VIEW_NAME;
    }

}

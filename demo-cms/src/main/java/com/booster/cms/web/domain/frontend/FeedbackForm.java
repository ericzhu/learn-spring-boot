package com.booster.cms.web.domain.frontend;

import java.io.Serializable;

public class FeedbackForm implements Serializable {

    private static final long serialVersionUID = 1L;

    private String            email;
    private String            name;
    private String            feedback;

    public FeedbackForm() {}

    public FeedbackForm(String email, String name, String feedback) {
        this.email = email;
        this.name = name;
        this.feedback = feedback;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    @Override
    public String toString() {
        return "FeedBackView [email=" + email + ", name=" + name + ", feedback=" + feedback + "]";
    }

}

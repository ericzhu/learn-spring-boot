package com.booster.cms.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.booster.cms.web.domain.frontend.LoginForm;

@Controller
public class LoginController {

    public static final String LOGIN_VIEW_NAME      = "user/login";

    public static final String LOGIN_FORM_MODEL_KEY = "loginForm";

    @GetMapping(value = "/login")
    public String showLoginPage(Model uiModel) {
        uiModel.addAttribute(LOGIN_FORM_MODEL_KEY, new LoginForm());
        return LOGIN_VIEW_NAME;
    }
}

package com.booster.cms.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PayloadController {
    
    public static final String PAYLOAD_VIEW_NAME = "payload/payload";
    
    @GetMapping(value="/payload")
    public String showPayload() {
        return PAYLOAD_VIEW_NAME;
    }
    
}

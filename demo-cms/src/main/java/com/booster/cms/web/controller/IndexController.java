package com.booster.cms.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by ezhu on 11/18/16.
 */
@Controller
public class IndexController {

    @GetMapping(value = "/")
    public String index() {
        return "index";
    }

}

package com.example.medfarm;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;

@Controller
public class Routes {

    @GetMapping("/login")
    public String login(Map<String,String> model) {
        return "login";
    }

    @GetMapping({"/","/home"})
    public String home(Map<String,String> model) {
        return "home";
    }

    @GetMapping("/loginaceito")
    public String aceito(Map<String,String> model) {
        return "loginaceito";
    }
}

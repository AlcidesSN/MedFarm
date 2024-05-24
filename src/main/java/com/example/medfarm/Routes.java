package com.example.medfarm;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;

@Controller
public class Routes {


    @GetMapping({"/","/home"})
    public String home(Map<String,String> model) {
        return "home";
    }


}

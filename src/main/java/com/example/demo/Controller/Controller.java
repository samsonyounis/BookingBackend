package com.example.demo.Controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

@org.springframework.stereotype.Controller
@CrossOrigin("*")
public class Controller {
@CrossOrigin
    @GetMapping("/")
    public String homePage(){
        return "index.html";
    }
}

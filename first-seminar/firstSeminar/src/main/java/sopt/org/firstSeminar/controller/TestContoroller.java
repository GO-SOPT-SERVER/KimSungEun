package sopt.org.firstSeminar.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestContoroller {
    @GetMapping("/test")
    public String test(){
        return "Welcome Spring";
    }
}

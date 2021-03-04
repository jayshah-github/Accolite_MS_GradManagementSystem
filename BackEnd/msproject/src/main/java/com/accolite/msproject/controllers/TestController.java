package com.accolite.msproject.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("test")
public class TestController {

    @GetMapping("/helloWorld")
    public @ResponseBody
    String testHelloWorld() {
        return "helloWorld";
    }

}

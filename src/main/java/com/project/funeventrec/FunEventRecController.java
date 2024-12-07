package com.project.funeventrec;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunEventRecController {
    @RequestMapping
    public String hello() {
        return "Hello World from Spring Boot";
    }

    @RequestMapping("/events")
    public String events() {
        return "Let's go!";
    }
}

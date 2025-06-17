package main.java.com.bpm.camunda.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/api/common")
public class CommonController {

    @GetMapping("/health")
    public String healthCheck() {
        return "Service is up and running!";
    }
}

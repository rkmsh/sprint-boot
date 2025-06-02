package com.rkmsh.request_handler.controller;

import org.springframework.web.bind.annotation.RestController;

import com.rkmsh.request_handler.requestResponseModels.CommonRequestModel;
import com.rkmsh.request_handler.requestResponseModels.CommonResponseModel;

import lombok.extern.slf4j.Slf4j;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping(value = "/api/v1/common")
@Slf4j
public class CommonController {

    @PostMapping("/verify")
    public CommonResponseModel verify(@RequestBody CommonRequestModel request) {
        //TODO: process POST request
        log.info("Name: {}, role: {}, email: {}", request.getName(), request.getRole(), request.getEmail());

        
        return new CommonResponseModel()
                    .setStatus("SUCCESS")
                    .setErrorCode("00");
    }
    
}

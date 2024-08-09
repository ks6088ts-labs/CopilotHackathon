package com.microsoft.hackathon.copilotdemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/* 
* Create a GET operation to return the value of a key passed as query parameter. 
* If the key is not passed, return "key not passed".
* If the key is passed, return "hello <key>".
* 
*/
// handle a simple GET request. In this first exercise, we have provided a comment that describes the code you need to generate. Just press enter and wait a couple of seconds, Copilot will generate the code for you.
@RestController
public class DemoController {

    @GetMapping("/hello")
    public String hello(@RequestParam(required = false) String key) {
        if (key == null) {
            return "key not passed";
        }
        return "hello " + key;
    }
}
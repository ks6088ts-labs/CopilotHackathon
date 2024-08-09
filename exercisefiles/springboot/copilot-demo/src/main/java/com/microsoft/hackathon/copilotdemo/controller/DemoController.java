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

    // New operation under /diffdates that calculates the difference between two dates.
    // The operation should receive two dates as parameter in format dd-MM-yyyy and return the difference in days.
    // If the dates are not passed, return "dates not passed".
    // If the dates are passed, return the difference in days.
    @GetMapping("/diffdates")
    public String diffDates(@RequestParam(required = false) String date1, @RequestParam(required = false) String date2) {
        if (date1 == null || date2 == null) {
            return "dates not passed";
        }
        // Split the date string into day, month and year
        String[] date1Parts = date1.split("-");
        String[] date2Parts = date2.split("-");
        // Create a LocalDate object for each date
        LocalDate localDate1 = LocalDate.of(Integer.parseInt(date1Parts[2]), Integer.parseInt(date1Parts[1]), Integer.parseInt(date1Parts[0]));
        LocalDate localDate2 = LocalDate.of(Integer.parseInt(date2Parts[2]), Integer.parseInt(date2Parts[1]), Integer.parseInt(date2Parts[0]));
        // Calculate the difference in days
        long diff = ChronoUnit.DAYS.between(localDate1, localDate2);
        return String.valueOf(diff);
    }
}
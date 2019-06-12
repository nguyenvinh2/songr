package com.codefellows.vinh.songr.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ReverseController {
    @RequestMapping(value="/reverse", method= RequestMethod.GET)
    @ResponseBody
    public String reverse(@RequestParam String sentence){
        String[] arr = sentence.split(" ");
        return String.join(" ", reverseStringArray(arr));
    }

    private String[] reverseStringArray(String[] inputArray) {
        String[] reversedArray = new String[inputArray.length];
        for(int i = 0; i < inputArray.length; i++) {
            reversedArray[i] = inputArray[inputArray.length - 1 - i];
        }
        return reversedArray;
    }
}

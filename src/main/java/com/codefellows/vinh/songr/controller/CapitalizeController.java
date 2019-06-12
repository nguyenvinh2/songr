package com.codefellows.vinh.songr.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class CapitalizeController {
    @RequestMapping(value="/capitalize/{input}", method= RequestMethod.GET)
    @ResponseBody
    public String capitalize(@PathVariable String input){
        return input.toUpperCase();
    }
}

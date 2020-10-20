package com.bhs.springboot.web;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@RequiredArgsConstructor
@Controller
@Log4j2
public class findmapController {

    @GetMapping("/findmap")
    public String findmap() {

        return "findmap";
    }
}

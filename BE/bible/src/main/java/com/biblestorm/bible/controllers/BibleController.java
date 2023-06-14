package com.biblestorm.bible.controllers;

import com.biblestorm.bible.services.BibleService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("bible")
public class BibleController {
    BibleService bibleService;
    public BibleController(BibleService service1){
        this.bibleService = service1;
    }

    @GetMapping("/test")
    public String test(){
        return "test";
    }
}

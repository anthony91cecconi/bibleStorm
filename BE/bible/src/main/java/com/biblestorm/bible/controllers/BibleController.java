package com.biblestorm.bible.controllers;

import com.biblestorm.bible.entitys.Bible;
import com.biblestorm.bible.services.BibleService;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/new")
    public Boolean newBible(@RequestBody Bible bible){
        return this.bibleService.newBible(bible);
    }
}

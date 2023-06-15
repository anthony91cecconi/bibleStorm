package com.biblestorm.bible.controllers;

import com.biblestorm.bible.entitys.Bible;
import com.biblestorm.bible.entitys.Book;
import com.biblestorm.bible.services.BibleService;
import com.biblestorm.bible.services.BookService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("control/v1/bible")
public class BibleController {
    BibleService bibleService;
    BookService bookService;
    public BibleController(BibleService service1,BookService service2){
        this.bibleService = service1;
        this.bookService = service2;
    }

    @PostMapping("/new-bible")
    public Boolean newBible(@RequestBody Bible bible){
        return this.bibleService.newBible(bible);
    }

    @PostMapping("/new-book")
    public Boolean newBook(@RequestBody Book book){
        return this.bookService.newBook(book);
    }
}

package com.biblestorm.bible.controllers;

import com.biblestorm.bible.entitys.Bible;
import com.biblestorm.bible.entitys.Book;
import com.biblestorm.bible.entitys.Chapter;
import com.biblestorm.bible.services.BibleService;
import com.biblestorm.bible.services.BookService;
import com.biblestorm.bible.services.ChapterService;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("control/v1/bible")
public class BibleController {
    BibleService bibleService;
    BookService bookService;
    ChapterService chapterService;
    public BibleController(BibleService service1,BookService service2,ChapterService service3){
        this.bibleService = service1;
        this.bookService = service2;
        this.chapterService = service3;
    }

    @PostMapping("/new-bible")
    public Boolean newBible(@RequestBody Bible bible){
        return this.bibleService.newBible(bible);
    }

    @PostMapping("/new-book")
    public Boolean newBook(@RequestBody Book book){
        return this.bookService.newBook(book);
    }

    @GetMapping("/get-bible/{id}")
    public Bible getBible(@PathVariable("id") String id){
        return this.bibleService.getBible(id);
    }

    @PostMapping("/new-chapter")
    public Boolean newChapter(@RequestBody Chapter chapter){
        return this.chapterService.newChapter(chapter);
    }
}

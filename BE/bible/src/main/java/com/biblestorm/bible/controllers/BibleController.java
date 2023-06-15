package com.biblestorm.bible.controllers;

import com.biblestorm.bible.entitys.Bible;
import com.biblestorm.bible.entitys.Book;
import com.biblestorm.bible.entitys.Chapter;
import com.biblestorm.bible.entitys.Verse;
import com.biblestorm.bible.services.BibleService;
import com.biblestorm.bible.services.BookService;
import com.biblestorm.bible.services.ChapterService;
import com.biblestorm.bible.services.VerseService;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("control/v1/bible")
public class BibleController {
    BibleService bibleService;
    BookService bookService;
    ChapterService chapterService;
    VerseService verseService;
    public BibleController(BibleService service1, BookService service2, ChapterService service3, VerseService service4){
        this.bibleService = service1;
        this.bookService = service2;
        this.chapterService = service3;
        this.verseService = service4;
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

    @GetMapping("/get-book/{id}")
    public Book getBook(@PathVariable("id") String id){
        return this.bookService.getBook(id);
    }

    @PostMapping("/new-chapter")
    public Boolean newChapter(@RequestBody Chapter chapter){
        return this.chapterService.newChapter(chapter);
    }

    @PostMapping("/new-verse")
    public Boolean newVerse(@RequestBody Verse verse){
        return this.verseService.newVerse(verse);
    }
}

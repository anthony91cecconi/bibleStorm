package com.biblestorm.bible.services;

import com.biblestorm.bible.repositories.BookRepository;
import org.springframework.stereotype.Service;

@Service
public class BookService {
    BookRepository bookRepository;
    public BookService(BookRepository repo1){
        this.bookRepository = repo1;
    }


}

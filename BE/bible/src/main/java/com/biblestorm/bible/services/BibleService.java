package com.biblestorm.bible.services;

import com.biblestorm.bible.entitys.Bible;
import com.biblestorm.bible.entitys.Book;
import com.biblestorm.bible.repositories.BibleRepository;
import lombok.extern.java.Log;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Log
public class BibleService {
    BibleRepository bibleRepository;
    public BibleService(BibleRepository repository1){
        this.bibleRepository = repository1;
    }

    public boolean newBible(Bible bible){
        bible.setId( bible.getName()+"("+bible.getEdition().getYear()+")");

        if(this.bibleRepository.existsById(bible.getId())) {
            log.info("bibbia gia esistente in archivio, operazione fallita");
            return false;
        }else{
            log.info("bibbia salvata in archivio");
            this.bibleRepository.save(bible);
            return true;
        }
    }

    public void addBook(Book book){
        List<Book> books;
        if(book.getBible().getBooks() == null){
            books = new ArrayList<>();
        }else {
            books = book.getBible().getBooks();
        }

        books.add(book);
        book.getBible().setBooks(books);
        this.bibleRepository.save(book.getBible());
        log.info("libro aggiunto alla bibbia");
    }

    public Bible getBible(String id){
        return this.bibleRepository.findById(id).get();
    }
}

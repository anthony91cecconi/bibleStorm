package com.biblestorm.bible.services;

import com.biblestorm.bible.entitys.Book;
import com.biblestorm.bible.repositories.BookRepository;
import lombok.extern.java.Log;
import org.springframework.stereotype.Service;

@Service
@Log
public class BookService {
    BibleService bibleService;
    BookRepository bookRepository;
    public BookService(BookRepository repo1,BibleService service1){
        this.bookRepository = repo1;
        this.bibleService = service1;
    }

    public boolean newBook(Book book){
        if (book.getBibleId().getId()==null){
            log.warning("bibbia non specificata operazione fallita");
            return false;
        }
        book.setId(book.getBibleId().getId() + "=" + book.getName());
        log.info(book.getName().split("",3).toString());
        if(this.bookRepository.existsById(book.getId())) {
            log.warning("questo è gia presente in archivio");
            return false;
        }else{
            this.bookRepository.save(book);
            this.bibleService.addBook(book);
            log.info("libro salvato correttamente");
            return true;
        }
    }

}

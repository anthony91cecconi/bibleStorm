package com.biblestorm.bible.services;

import com.biblestorm.bible.entitys.Bible;
import com.biblestorm.bible.entitys.Book;
import com.biblestorm.bible.entitys.Chapter;
import com.biblestorm.bible.repositories.BookRepository;
import lombok.extern.java.Log;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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
        book.setId(book.getBibleId().getId() + "_" + book.getName());
        if(this.bookRepository.existsById(book.getId())) {
            log.warning("elemento gia presente in archivio");
            return false;
        }else{
            this.bookRepository.save(book);
            this.bibleService.addBook(book);
            log.info("libro salvato correttamente");
            return true;
        }
    }

    public void addChapter(Chapter chapter){
        List<Chapter> chapters;
        if(chapter.getBookId().getChapters() == null){
            chapters = new ArrayList<>();
        }else {
            chapters = chapter.getBookId().getChapters();
        }

        chapters.add(chapter);
        chapter.getBookId().setChapters(chapters);
        this.bookRepository.save(chapter.getBookId());
        log.info("capitolo aggiunto al libro");
    }

    public Book getBook(String id){
        return this.bookRepository.findById(id).get();
    }

}

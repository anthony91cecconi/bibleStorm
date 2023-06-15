package com.biblestorm.bible.services;

import com.biblestorm.bible.entitys.Chapter;
import com.biblestorm.bible.repositories.BookRepository;
import com.biblestorm.bible.repositories.ChapterRepository;
import lombok.extern.java.Log;
import org.springframework.stereotype.Service;

@Service
@Log
public class ChapterService {

    ChapterRepository chapterRepository;
    BookService bookService;
    public ChapterService(ChapterRepository repository1, BookService service1){
        this.bookService = service1;
        this.chapterRepository = repository1;
    }

    public boolean newChapter(Chapter chapter){
        chapter.setId(chapter.getBookId().getId() + "-" + chapter.getNumber());

        if (chapter.getBookId().getId()==null){
            log.warning("bibbia non specificata operazione fallita");
            return false;
        }
        chapter.setId(chapter.getBookId().getId() + "-" + chapter.getNumber());
        if(this.chapterRepository.existsById(chapter.getId())) {
            log.warning("elemento gia presente in archivio");
            return false;
        }else{
            this.chapterRepository.save(chapter);
            this.bookService.addChapter(chapter);
            log.info("libro salvato correttamente");
            return true;
        }
    }

}

package com.biblestorm.bible.services;

import com.biblestorm.bible.entitys.Chapter;
import com.biblestorm.bible.entitys.Verse;
import com.biblestorm.bible.repositories.BookRepository;
import com.biblestorm.bible.repositories.ChapterRepository;
import com.biblestorm.bible.repositories.VerseRepository;
import lombok.extern.java.Log;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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
        if (chapter.getBookId().getId()==null){
            log.warning("libro non specificato operazione fallita");
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

    public void addVerse(Verse verse){
        List<Verse> verses;
        if(verse.getChapterId().getVerses() == null){
            verses = new ArrayList<>();
        }else {
            verses = verse.getChapterId().getVerses();
        }

        verses.add(verse);
        verse.getChapterId().setVerses(verses);
        this.chapterRepository.save(verse.getChapterId());
        log.info("capitolo aggiunto al libro");
    }

}

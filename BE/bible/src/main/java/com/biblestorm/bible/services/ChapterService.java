package com.biblestorm.bible.services;

import com.biblestorm.bible.entitys.Chapter;
import com.biblestorm.bible.entitys.Verse;
import com.biblestorm.bible.repositories.ChapterRepository;
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
        if (chapter.getBook().getId()==null){
            log.warning("libro non specificato operazione fallita");
            return false;
        }
        chapter.setId(chapter.getBook().getId() + "-" + chapter.getNumber());
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
        if(verse.getChapter().getVerses() == null){
            verses = new ArrayList<>();
        }else {
            verses = verse.getChapter().getVerses();
        }

        verses.add(verse);
        verse.getChapter().setVerses(verses);
        this.chapterRepository.save(verse.getChapter());
        log.info("capitolo aggiunto al libro");
    }

    public Chapter getChapter(String id){
        return this.chapterRepository.findById(id).get();
    }

}

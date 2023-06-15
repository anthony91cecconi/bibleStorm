package com.biblestorm.bible.services;

import com.biblestorm.bible.entitys.Chapter;
import com.biblestorm.bible.entitys.Verse;
import com.biblestorm.bible.repositories.VerseRepository;
import lombok.extern.java.Log;
import org.springframework.stereotype.Service;

@Service
@Log
public class VerseService {

    VerseRepository verseRepository;
    ChapterService chapterService;
    public VerseService(VerseRepository repository1, ChapterService service1){
        this.chapterService = service1;
        this.verseRepository = repository1;
    }

    public boolean newVerse(Verse verse){
        if (verse.getChapterId().getId()==null){
            log.warning("capitolo non specificato operazione fallita");
            return false;
        }
        verse.setId(verse.getChapterId().getId() + ":" + verse.getNumber());
        if(this.verseRepository.existsById(verse.getId())) {
            log.warning("elemento gia presente in archivio");
            return false;
        }else{
            this.verseRepository.save(verse);
            this.chapterService.addVerse(verse);
            log.info("verso salvato correttamente");
            return true;
        }
    }

}

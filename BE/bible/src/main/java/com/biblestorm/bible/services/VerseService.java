package com.biblestorm.bible.services;

import com.biblestorm.bible.entitys.Sentence;
import com.biblestorm.bible.entitys.Verse;
import com.biblestorm.bible.repositories.SentenceRepository;
import com.biblestorm.bible.repositories.VerseRepository;
import lombok.extern.java.Log;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Log
public class VerseService {

    VerseRepository verseRepository;
    ChapterService chapterService;
    SentenceRepository sentenceRepository;
    public VerseService(VerseRepository repository1, ChapterService service1, SentenceRepository repository2){
        this.chapterService = service1;
        this.verseRepository = repository1;
        this.sentenceRepository = repository2;
    }

    public boolean newVerse(Verse verse){
        if (verse.getChapter().getId()==null){
            log.warning("capitolo non specificato operazione fallita");
            return false;
        }
        verse.setId(verse.getChapter().getId() + ":" + verse.getNumber());
        if(this.verseRepository.existsById(verse.getId())) {
            log.warning("elemento gia presente in archivio");
            return false;
        }else{
            if ( verse.getSentences() != null){
                final int[] index = {1};
                List<Sentence> sentences = verse.getSentences().stream().map(el -> {
                    el.setId(verse.getId() + "(" + index[0] + ")");
                    index[0]++;
                    el.setVerse(verse);
                    return el;
                }).toList();
                verse.setSentences(sentences);
            }
            this.chapterService.addVerse(verse);
            this.verseRepository.save(verse);
            log.info("verso salvato correttamente");
            return true;
        }
    }

    public Verse getVerse(String id){
        return this.verseRepository.findById(id).get();
    }

}

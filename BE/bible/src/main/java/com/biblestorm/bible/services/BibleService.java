package com.biblestorm.bible.services;

import com.biblestorm.bible.entitys.Bible;
import com.biblestorm.bible.repositories.BibleRepository;
import org.springframework.stereotype.Service;

@Service
public class BibleService {
    BibleRepository bibleRepository;
    public BibleService(BibleRepository repository1){
        this.bibleRepository = repository1;
    }

    public boolean newBible(Bible bible){
        bible.setId( bible.getName()+"("+bible.getEdition().getYear()+")");

        if(this.bibleRepository.existsById(bible.getId())) {
            return false;
        }else{
            this.bibleRepository.save(bible);
            return true;
        }
    }
}

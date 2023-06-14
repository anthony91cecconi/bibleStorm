package com.biblestorm.bible.services;

import com.biblestorm.bible.repositories.BibleRepository;
import org.springframework.stereotype.Service;

@Service
public class BibleService {
    BibleRepository bibleRepository;
    public BibleService(BibleRepository repository1){
        this.bibleRepository = repository1;
    }


}

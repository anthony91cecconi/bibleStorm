package com.biblestorm.bible.entitys;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

import java.io.Serializable;

@Entity
public class Book implements Serializable {
    @Id
    String id;
    String name;
    Object chapter;
    @ManyToOne(fetch = FetchType.LAZY)
    Bible bibleId;

}

package com.biblestorm.bible.entitys;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Entity
@Data
public class Book implements Serializable {
    @Id
    String id;
    String name;
    List<Object> chapters;

    @ManyToOne(fetch = FetchType.LAZY)
    Bible bibleId;

}

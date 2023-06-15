package com.biblestorm.bible.entitys;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

import java.io.Serializable;

@Entity
@Data
public class Verse implements Serializable {
    @Id
    String id;
    int number;
    String content;

    @ManyToOne(fetch = FetchType.LAZY)
    Chapter chapterId;
}

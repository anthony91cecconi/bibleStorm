package com.biblestorm.bible.entitys;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

import java.io.Serializable;

@Entity
@Data
public class Sentence implements Serializable {
    @Id
    String id;
    String content;
    int number;
    @ManyToOne(fetch = FetchType.EAGER)
    Verse verse;
}

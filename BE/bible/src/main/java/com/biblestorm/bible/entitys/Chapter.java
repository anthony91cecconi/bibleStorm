package com.biblestorm.bible.entitys;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Entity
@Data
public class Chapter implements Serializable {
    @Id
    String id;
    int number;

    @OneToMany(fetch = FetchType.EAGER)
    List<Verse> verses;

    @ManyToOne(fetch = FetchType.LAZY)
    Book bookId;
}

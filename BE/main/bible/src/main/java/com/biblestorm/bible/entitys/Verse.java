package com.biblestorm.bible.entitys;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Entity
@Data
public class Verse implements Serializable {
    @Id
    String id;
    int number;

    @OneToMany(fetch = FetchType.EAGER)
    List<Sentence> sentences;

    @ManyToOne(fetch = FetchType.LAZY)
    Chapter chapter;

    @Override
    public String toString() {
        return "Verse{" +
                "id='" + id + '\'' +
                ", number=" + number +
                '}';
    }
}

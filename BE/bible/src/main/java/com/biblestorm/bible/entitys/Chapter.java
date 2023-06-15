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
public class Chapter implements Serializable {
    @Id
    String id;
    int number;
    List<Object> verses;

    @ManyToOne(fetch = FetchType.LAZY)
    Book bookId;
}

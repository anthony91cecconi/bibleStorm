package com.biblestorm.bible.entitys;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Data
public class Bible implements Serializable {

    @Id
    String id;
    String name;
    Date edition;

    @OneToMany(fetch = FetchType.EAGER)
    List<Book> books;

    String publisher;
}

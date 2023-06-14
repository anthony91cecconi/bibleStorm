package com.biblestorm.bible.entitys;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Data
public class Bible implements Serializable {

    @Id
    Long id;
    String name;
    Date edition;
    List<Object> books;
    String publisher;
}

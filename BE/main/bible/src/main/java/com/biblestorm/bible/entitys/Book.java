package com.biblestorm.bible.entitys;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Entity
@Data
public class Book implements Serializable {
    @Id
    String id;
    String name;

    @OneToMany(fetch = FetchType.EAGER)
    List<Chapter> chapters;

    @ManyToOne(fetch = FetchType.LAZY)
    Bible bible;

}

package com.biblestorm.bible.repositories;

import com.biblestorm.bible.entitys.Sentence;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SentenceRepository extends JpaRepository<Sentence,String> {
}

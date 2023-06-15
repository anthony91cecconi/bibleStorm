package com.biblestorm.bible.repositories;

import com.biblestorm.bible.entitys.Verse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VerseRepository extends JpaRepository<Verse,String> {
}

package com.biblestorm.bible.repositories;

import com.biblestorm.bible.entitys.Bible;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BibleRepository extends JpaRepository<Bible,String> {
}

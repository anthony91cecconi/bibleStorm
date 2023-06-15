package com.biblestorm.bible;

import com.biblestorm.bible.controllers.BibleController;
import com.biblestorm.bible.entitys.Bible;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.Date;

@SpringBootTest
class BibleApplicationTests {

	@Autowired
	private BibleController bibleController;

	Bible bibleForTest(){
		Bible bible = new Bible();
		bible.setName("test");
		bible.setEdition(new Date(2023,1,1));
		bible.setPublisher("prova");

		return bible;
	}





	@Test
	@Order(1)
	void newBible() {
		this.bibleController.newBible(this.bibleForTest());
	}

}

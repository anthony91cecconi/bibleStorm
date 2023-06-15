package com.biblestorm.bible;

import com.biblestorm.bible.controllers.BibleController;
import com.biblestorm.bible.entitys.Bible;
import com.biblestorm.bible.entitys.Book;
import com.biblestorm.bible.entitys.Chapter;
import com.biblestorm.bible.entitys.Verse;
import lombok.extern.java.Log;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.Date;

@SpringBootTest
@Log
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class BibleApplicationTests {
	String bibleId = "";
	String bookId = "";
	String chapterId = "";
	String verseId = "";


	@Autowired
	private BibleController bibleController;

	Bible bibleForTest(){
		Bible bible = new Bible();
		bible.setName("test");
		bible.setEdition(new Date(2023,1,1));
		bible.setPublisher("prova");
		this.bibleId = bible.getName()+"("+ bible.getEdition().getYear()+")";
		bible.setId(this.bibleId);
		return bible;
	}
	Book bookForTest(){
		Book book = new Book();
		book.setName("genprov");
		book.setBibleId(this.bibleForTest());
		this.bookId = this.bibleId + "_" + book.getName();
		book.setId(this.bookId);
		return book;
	}
	Chapter chapterForTest(){
		Chapter chapter=new Chapter();
		chapter.setNumber(1);
		chapter.setBookId(this.bookForTest());
		this.chapterId = this.bookId + "-" + chapter.getNumber();
		chapter.setId(this.chapterId);
		return chapter;
	}

	Verse verseForTest(){
		Verse verse=new Verse();
		verse.setNumber(1);
		verse.setContent("prova");
		verse.setChapterId(this.chapterForTest());
		this.verseId = this.chapterId + ":" + verse.getNumber();
		verse.setId(this.chapterId);
		return verse;
	}



	@Test
	@Order(1)
	void newBible() {
		this.bibleController.newBible(this.bibleForTest());
	}
	@Test
	@Order(2)
	void newBook() {
		this.bibleController.newBook(this.bookForTest());
	}
	@Test
	@Order(3)
	void findBible(){
		Bible bible = this.bibleController.getBible("test(2023)");
		log.info("nome della bibbia "+ bible.getName() + " contiene libri " + bible.getBooks().size());
	}

	@Test
	@Order(4)
	void newChapter(){
		this.bibleController.newChapter(this.chapterForTest());
	}

	@Test
	@Order(5)
	void findBook(){
		Book book = this.bibleController.getBook("test(2023)=genprov");
		log.info("nome libro "+ book.getName());// + " contiene capitoli " + book.getChapters().size());
	}

	@Test
	@Order(6)
	void newVerse(){
		this.bibleController.newVerse(this.verseForTest());
	}
}

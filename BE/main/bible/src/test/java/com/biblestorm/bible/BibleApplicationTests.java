package com.biblestorm.bible;

import com.biblestorm.bible.controllers.BibleController;
import com.biblestorm.bible.entitys.*;
import lombok.extern.java.Log;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SpringBootTest
@Log
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class BibleApplicationTests {
	String bibleId = "";
	String bookId = "";
	String chapterId = "";
	String verseId = "";
	String sentenceId = "";


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
		book.setBible(this.bibleForTest());
		this.bookId = this.bibleId + "_" + book.getName();
		book.setId( this.bibleId + "_" + book.getName());
		return book;
	}
	Chapter chapterForTest(){
		Chapter chapter=new Chapter();
		chapter.setNumber(1);
		chapter.setBook(this.bookForTest());
		this.chapterId = this.bookId + "-" + chapter.getNumber();
		chapter.setId(this.bookId + "-" + chapter.getNumber());
		return chapter;
	}

	Verse verseForTest(){
		Verse verse=new Verse();
		verse.setNumber(1);
		verse.setChapter(this.chapterForTest());

		if(verse.getSentences() == null){
			List<Sentence> sentences = new ArrayList<Sentence>();
			Sentence sentence = new Sentence();
			sentence.setContent("test1");
			sentence.setNumber(1);
			this.sentenceId = this.verseId + "(" + sentence.getNumber() + ")";
			sentence.setId(this.verseId + "(" + sentence.getNumber() + ")");
			sentences.add(sentence);
			verse.setSentences(sentences);
		}
		this.verseId = this.chapterId + ":" + verse.getNumber();
		verse.setId(this.chapterId + ":" + verse.getNumber());
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
		Book book = this.bibleController.getBook(this.bookForTest().getId());
		log.info("nome libro "+ book.getName() + " contiene capitoli " + book.getChapters().size());
	}

	@Test
	@Order(6)
	void newVerse(){
		this.bibleController.newVerse(this.verseForTest());
	}

	@Test
	@Order(7)
	void findChapter(){
		Chapter chapter = this.bibleController.getChapter(this.chapterForTest().getId());
		log.info("numero capitolo "+ chapter.getNumber() + " contiene versi " + chapter.getVerses().size());
	}

	@Test
	@Order(8)
	void findVerse(){
/*		Verse verse = this.bibleController.getVerse(this.verseForTest().getId());
		log.info("numero verso "+ verse.getNumber() + " contiene frasi " + verse.getSentences().size());

 */
	}
}

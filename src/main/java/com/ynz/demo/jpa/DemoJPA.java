package com.ynz.demo.jpa;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Import;

@Import(JPAConfiguration.class)
public class DemoJPA {

  public static void main(String[] args) {
    ApplicationContext context = new AnnotationConfigApplicationContext(JPAConfiguration.class);
    var bookRepository = context.getBean(BookRepository.class);
    var bookService = context.getBean(BookService.class);

    // persist a book
    var book = new Book();
    book.setName("Java functional programming");

    bookRepository.save(book);
    System.out.println("Persisted Book PK: " + book.getId());

    var found = bookService.findBookByName(book.getId());
    System.out.println("Found: " + found);
  }
}

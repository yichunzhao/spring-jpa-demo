package com.ynz.demo.jpa;

import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class BookService {
  private final BookRepository bookRepository;

  public BookService(BookRepository bookRepository) {
    this.bookRepository = bookRepository;
  }

  public Book findBookByName(Long id) {
    return bookRepository.findBookById(id)
        .orElseThrow(
            () ->
                new NoSuchElementException(
                    String.format("Person with id : %d is not found. ", id)));
  }
}

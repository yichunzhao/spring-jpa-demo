package com.ynz.demo.jpa;

import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Optional;

@Repository
public class BookRepository {
  private final EntityManager em;

  private SimpleJpaRepository<Book, Long> simpleJpaRepository;

  public BookRepository(EntityManager em) {
      this.em = em;
    simpleJpaRepository = new SimpleJpaRepository<Book, Long>(Book.class, em);
  }

  public Optional<Book> findBookById(Long bookId) {
    return simpleJpaRepository.findById(bookId);
  }
}

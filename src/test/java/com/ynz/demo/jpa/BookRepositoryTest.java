package com.ynz.demo.jpa;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ContextConfiguration(classes = {JPAConfiguration.class})
@ExtendWith(SpringExtension.class)
class BookRepositoryTest {
  @Autowired private BookRepository bookRepository;

  @Test
  @Sql(
      statements = "INSERT INTO book VALUES (1, 'my book')",
      executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
  @Transactional
  void findByName() {
    var expected = "my book";
    var found = bookRepository.findByName(expected);
    assertTrue(found.isPresent());
    assertEquals(expected, found.get().getName());
  }
}

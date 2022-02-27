package com.ynz.demo.jpa;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Import;

import javax.persistence.EntityManagerFactory;

@Import(JPAConfiguration.class)
public class DemoJPA {

  public static void main(String[] args) {
    ApplicationContext context = new AnnotationConfigApplicationContext(JPAConfiguration.class);
    printoutContextBeans(context);

    var emf = context.getBean(EntityManagerFactory.class);
    var em = emf.createEntityManager();

    System.out.printf("contains Person entity? %b%n", em.contains(Book.class));
  }

  private static void printoutContextBeans(ApplicationContext context) {
    //
    for (String name : context.getBeanDefinitionNames()) {
      System.out.println(name);
    }
  }
}

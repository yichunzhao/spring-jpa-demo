# Spring-JPA-Demo

How to set up JPA-Hibernate with Spring DI, without SpringBoot

1. It needs a database driver, a maven dependency, for this case, we use PostgreSQL.
2. In order to use JPA-Hibernate in this project, it is found that the easiest way is to include Spring Boot JPA starter directly.
3. It uses a Spring-Context to carry out DI.
4. It needs an external JAX binding maven dependency, for it is not a part of JDK anymore.

@ContextConfiguration defines class-level metadata that is used to determine how to load and configure an ApplicationContext for integration tests.


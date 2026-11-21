package com.hendisantika;

import com.hendisantika.universum.ComicUniversum;
import com.hendisantika.universum.Hero;
import com.hendisantika.universum.HeroRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Uses the Testcontainers JDBC URL ({@code jdbc:tc:mysql:...}) configured in
 * {@code src/test/resources/application.properties}, so a throwaway MySQL
 * container is started automatically for the Spring context.
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
class SpringBootMysqlTestcontainerApplicationTests {

    @Autowired
    private HeroRepository heroRepository;

    @BeforeEach
    void setUp() {
        heroRepository.deleteAll();
    }

    @Test
    void contextLoadsAndPersistsHeroes() {
        heroRepository.saveAll(List.of(
                new Hero("Batman", "Gotham City", ComicUniversum.DC_COMICS),
                new Hero("Superman", "Metropolis", ComicUniversum.DC_COMICS),
                new Hero("Spider-Man", "New York", ComicUniversum.MARVEL)));

        List<Hero> heroes = heroRepository.findAll();

        assertThat(heroes).hasSize(3)
                .extracting(Hero::getName)
                .containsExactlyInAnyOrder("Batman", "Superman", "Spider-Man");
    }
}

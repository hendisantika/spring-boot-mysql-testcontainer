package com.hendisantika;

import com.hendisantika.universum.ComicUniversum;
import com.hendisantika.universum.Hero;
import com.hendisantika.universum.HeroClassicJpaRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.util.Collection;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-mysql-testcontainer
 * User: powercommerce
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 9/3/22
 * Time: 09:21
 * To change this template use File | Settings | File Templates.
 */
//@SpringBootTest
//@Testcontainers
@Testcontainers
@SpringBootTest(
        properties = {
                "management.endpoint.health.show-details=always",
                "spring.datasource.url=jdbc:tc:mysql:9.1.0:///heroesDB"
        },
        webEnvironment = RANDOM_PORT
)
class HeroClassicJpaRepositoryIT {
    @Container
    private static final MySQLContainer database = new MySQLContainer(MySQLTestImages.MYSQL_910_IMAGE);

    @Autowired
    private HeroClassicJpaRepository repositoryUnderTest;

    @Test
    void findAllHeroes() {
        int numberHeroes = repositoryUnderTest.allHeroes().size();

        repositoryUnderTest.addHero(new Hero("Batman", "Gotham City", ComicUniversum.DC_COMICS));
        repositoryUnderTest.addHero(new Hero("Superman", "Metropolis", ComicUniversum.DC_COMICS));

        Collection<Hero> heroes = repositoryUnderTest.allHeroes();

        assertThat(heroes).hasSize(numberHeroes + 2);
    }

    @Test
    void findHeroByCriteria() {
        repositoryUnderTest.addHero(new Hero("Batman", "Gotham City", ComicUniversum.DC_COMICS));

        Collection<Hero> heroes = repositoryUnderTest.findHeroesBySearchCriteria("Batman");

        assertThat(heroes).contains(new Hero("Batman", "Gotham City", ComicUniversum.DC_COMICS));
    }

//    @DynamicPropertySource
//    static void databaseProperties(DynamicPropertyRegistry registry) {
//        registry.add("spring.datasource.url", database::getJdbcUrl);
//        registry.add("spring.datasource.username", database::getUsername);
//        registry.add("spring.datasource.password", database::getPassword);
//    }
}

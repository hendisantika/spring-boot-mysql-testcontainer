package com.hendisantika;

import com.hendisantika.universum.ComicUniversum;
import com.hendisantika.universum.Hero;
import com.hendisantika.universum.HeroClassicJpaRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Collection;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-mysql-testcontainer
 * User: powercommerce
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 9/3/22
 * Time: 09:23
 * To change this template use File | Settings | File Templates.
 */
@SpringBootTest
class HeroClassicJpaRepositoryReuseDatabaseIT extends DatabaseBaseTest {

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
}

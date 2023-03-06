package com.hendisantika;

import com.hendisantika.universum.ComicUniversum;
import com.hendisantika.universum.Hero;
import com.hendisantika.universum.HeroSpringDataJpaRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Collection;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-mysql-testcontainer
 * User: powercommerce
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 9/3/22
 * Time: 09:28
 * To change this template use File | Settings | File Templates.
 */
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class HeroSpringDataJpaRepositoryReuseDatabaseIT extends DatabaseBaseTest {

    @Autowired
    private HeroSpringDataJpaRepository repositoryUnderTest;

    @Test
    void findHeroesBySearchCriteria() {
        repositoryUnderTest.save(new Hero(1L, "Batman", "Gotham City", ComicUniversum.DC_COMICS));

        Collection<Hero> heroes = repositoryUnderTest.findHerosBySearchCriteria("Batman");

        assertThat(heroes).contains(new Hero("Batman", "Gotham City", ComicUniversum.DC_COMICS));
    }
}

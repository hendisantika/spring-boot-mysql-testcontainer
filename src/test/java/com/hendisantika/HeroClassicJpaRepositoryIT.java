package com.hendisantika;

import com.hendisantika.universum.ComicUniversum;
import com.hendisantika.universum.Hero;
import com.hendisantika.universum.HeroClassicJDBCRepository;
import com.hendisantika.universum.HeroClassicJpaRepository;
import com.mysql.cj.jdbc.MysqlDataSource;
import com.sun.istack.NotNull;
import org.junit.jupiter.api.Test;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.ext.ScriptUtils;
import org.testcontainers.jdbc.JdbcDatabaseDelegate;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import javax.sql.DataSource;
import java.util.Collection;

import static org.assertj.core.api.Assertions.assertThat;

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
@Testcontainers
class HeroClassicJpaRepositoryIT {
    @Container
    private static final MySQLContainer database = new MySQLContainer(MySQLTestImages.MYSQL_80_IMAGE);

    //    @Autowired
    private HeroClassicJpaRepository repositoryUnderTest;

    @Test
    void findAllHeroes() {
        ScriptUtils.runInitScript(new JdbcDatabaseDelegate(database, ""), "ddl.sql");
        repositoryUnderTest = new HeroClassicJDBCRepository(dataSource());
        repositoryUnderTest.addHero(new Hero("Batman", "Gotham City", ComicUniversum.DC_COMICS));
        repositoryUnderTest.addHero(new Hero("Superman", "Metropolis", ComicUniversum.DC_COMICS));

        Collection<Hero> heroes = repositoryUnderTest.allHeroes();
        int numberHeroes = repositoryUnderTest.allHeroes().size();

        assertThat(heroes).hasSize(numberHeroes + 2);
    }

    @Test
    void findHeroByCriteria() {
        repositoryUnderTest.addHero(new Hero(1L, "Batman", "Gotham City", ComicUniversum.DC_COMICS));

        Collection<Hero> heroes = repositoryUnderTest.findHeroesBySearchCriteria("Batman");

        assertThat(heroes).contains(new Hero("Batman", "Gotham City", ComicUniversum.DC_COMICS));
    }

//    @DynamicPropertySource
//    static void databaseProperties(DynamicPropertyRegistry registry) {
//        registry.add("spring.datasource.url", database::getJdbcUrl);
//        registry.add("spring.datasource.username", database::getUsername);
//        registry.add("spring.datasource.password", database::getPassword);
//    }

    @NotNull
    private DataSource dataSource() {
        MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setUrl(database.getJdbcUrl());
        dataSource.setUser(database.getUsername());
        dataSource.setPassword(database.getPassword());
        return dataSource;
    }
}

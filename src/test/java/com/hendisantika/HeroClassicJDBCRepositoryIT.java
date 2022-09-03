package com.hendisantika;

import com.hendisantika.universum.ComicUniversum;
import com.hendisantika.universum.Hero;
import com.hendisantika.universum.HeroClassicJDBCRepository;
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
 * Time: 09:16
 * To change this template use File | Settings | File Templates.
 */
@Testcontainers
class HeroClassicJDBCRepositoryIT {
    @Container
    private final MySQLContainer database = new MySQLContainer();

    private HeroClassicJDBCRepository repositoryUnderTest;

    @Test
    void testInteractionWithDatabase() {
        ScriptUtils.runInitScript(new JdbcDatabaseDelegate(database, ""), "ddl.sql");
        repositoryUnderTest = new HeroClassicJDBCRepository(dataSource());

        repositoryUnderTest.addHero(new Hero("Batman", "Gotham City", ComicUniversum.DC_COMICS));

        Collection<Hero> heroes = repositoryUnderTest.allHeros();

        assertThat(heroes).hasSize(1);
    }

    @NotNull
    private DataSource dataSource() {
        MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setUrl(database.getJdbcUrl());
        dataSource.setUser(database.getUsername());
        dataSource.setPassword(database.getPassword());
        return dataSource;
    }
}

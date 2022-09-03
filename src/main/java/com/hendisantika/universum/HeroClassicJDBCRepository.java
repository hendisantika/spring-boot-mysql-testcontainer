package com.hendisantika.universum;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.Collection;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-mysql-testcontainer
 * User: powercommerce
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 9/3/22
 * Time: 08:55
 * To change this template use File | Settings | File Templates.
 */
@Repository
public class HeroClassicJDBCRepository {

    private final JdbcTemplate jdbcTemplate;

    public HeroClassicJDBCRepository(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public void addHero(Hero hero) {
        jdbcTemplate.update("insert into hero (city, name, universum) values (?,?,?)",
                hero.getCity(), hero.getName(), hero.getUniversum().name());
    }

    public Collection<Hero> allHeros() {
        return jdbcTemplate.query("select * From hero",
                (resultSet, i) -> new Hero(resultSet.getString("name"),
                        resultSet.getString("city"),
                        ComicUniversum.valueOf(resultSet.getString("universum"))));
    }
}

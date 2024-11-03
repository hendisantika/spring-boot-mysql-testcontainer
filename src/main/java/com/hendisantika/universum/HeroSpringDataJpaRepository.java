package com.hendisantika.universum;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-mysql-testcontainer
 * User: powercommerce
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 9/3/22
 * Time: 08:58
 * To change this template use File | Settings | File Templates.
 */
public interface HeroSpringDataJpaRepository extends CrudRepository<Hero, Long> {

    @Query("SELECT hero FROM Hero hero where hero.city LIKE :searchCriteria OR hero.name LIKE :searchCriteria OR hero.universum = :searchCriteria")
    List<Hero> findHeroesBySearchCriteria(@Param("searchCriteria") String searchCriteria);

}


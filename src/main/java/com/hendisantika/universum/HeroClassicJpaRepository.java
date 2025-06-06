package com.hendisantika.universum;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-mysql-testcontainer
 * User: powercommerce
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 9/3/22
 * Time: 08:57
 * To change this template use File | Settings | File Templates.
 */
@Repository
public class HeroClassicJpaRepository {

    @PersistenceContext
    private EntityManager em;

    @Transactional
    public void addHero(Hero hero) {
        em.persist(hero);
    }

    public Collection<Hero> allHeroes() {
        return em.createQuery("Select hero FROM Hero hero", Hero.class).getResultList();
    }

    public Collection<Hero> findHeroesBySearchCriteria(String searchCriteria) {
        return em.createQuery("SELECT hero FROM Hero hero " +
                                "where hero.city LIKE :searchCriteria OR " +
                                "hero.name LIKE :searchCriteria OR " +
                                "hero.universum = :searchCriteria",
                        Hero.class)
                .setParameter("searchCriteria", searchCriteria).getResultList();
    }
}

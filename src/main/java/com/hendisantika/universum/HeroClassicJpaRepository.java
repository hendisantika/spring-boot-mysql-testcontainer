package com.hendisantika.universum;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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

}

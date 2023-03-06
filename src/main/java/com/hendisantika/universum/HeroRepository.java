package com.hendisantika.universum;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-mysql-testcontainer
 * User: powercommerce
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 9/14/22
 * Time: 09:46
 * To change this template use File | Settings | File Templates.
 */
public interface HeroRepository extends JpaRepository<Hero, Long> {
}

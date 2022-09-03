package com.hendisantika.controller;

import com.hendisantika.universum.HeroSpringDataJpaRepository;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-mysql-testcontainer
 * User: powercommerce
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 9/3/22
 * Time: 09:00
 * To change this template use File | Settings | File Templates.
 */
@RestController
public class HeroRestController {

    private final HeroSpringDataJpaRepository heroRepository;

    public HeroRestController(HeroSpringDataJpaRepository heroRepository) {
        this.heroRepository = heroRepository;
    }
}

package com.hendisantika.controller;

import com.hendisantika.universum.HeroClassicJpaRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-mysql-testcontainer
 * User: powercommerce
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 9/3/22
 * Time: 09:01
 * To change this template use File | Settings | File Templates.
 */
@Controller
public class HeroController {

    private final HeroClassicJpaRepository heroRepository;

    public HeroController(HeroClassicJpaRepository heroRepository) {
        this.heroRepository = heroRepository;
    }

    @GetMapping("/hero")
    public String viewStartPage(Model model) {
        model.addAttribute("ipAddress", inspectLocalHost());
        return "hero/hero.search.html";
    }

}

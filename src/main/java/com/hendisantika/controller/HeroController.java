package com.hendisantika.controller;

import com.hendisantika.universum.Hero;
import com.hendisantika.universum.HeroClassicJpaRepository;
import com.hendisantika.universum.NewHeroModel;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.net.Inet4Address;
import java.net.UnknownHostException;
import java.util.Collection;

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

    @GetMapping("/hero/list")
    public String viewHeros(@RequestParam(value = "search", required = false) String search, Model model) {
        model.addAttribute("heros", collectHeroes(search));
        model.addAttribute("ipAddress", inspectLocalHost());

        return "hero/hero.list.html";
    }

    private Collection<Hero> collectHeroes(String search) {
        if (StringUtils.isBlank(search) || StringUtils.isEmpty(search)) {
            return heroRepository.allHeroes();
        } else {
            return heroRepository.findHeroesBySearchCriteria(search);
        }
    }

    @GetMapping("/hero/new")
    public String newHero(Model model) {
        model.addAttribute("newHero", new NewHeroModel());
        return "hero/hero.new.html";
    }

    @PostMapping("/hero/new")
    public String addNewHero(@ModelAttribute("newHero") NewHeroModel newHeroModel) {
        heroRepository.addHero(newHeroModel.getHero());
        return "redirect:/hero/list";
    }

    private String inspectLocalHost() {
        try {
            return Inet4Address.getLocalHost().getHostAddress();
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        }
    }
}

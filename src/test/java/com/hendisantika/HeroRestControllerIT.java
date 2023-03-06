package com.hendisantika;

import com.hendisantika.universum.ComicUniversum;
import com.hendisantika.universum.Hero;
import com.hendisantika.universum.HeroSpringDataJpaRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-mysql-testcontainer
 * User: powercommerce
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 9/3/22
 * Time: 09:24
 * To change this template use File | Settings | File Templates.
 */
@SpringBootTest
@AutoConfigureMockMvc
@Testcontainers
class HeroRestControllerIT {

    @Container
    private static final MySQLContainer database = new MySQLContainer(MySQLTestImages.MYSQL_80_IMAGE);

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private HeroSpringDataJpaRepository heroRepository;

    @Test
    void allHeroes() throws Exception {
        heroRepository.save(new Hero("Batman", "Gotham City", ComicUniversum.DC_COMICS));
        heroRepository.save(new Hero("Superman", "Metropolis", ComicUniversum.DC_COMICS));

        mockMvc.perform(get("/heros"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[*].name", containsInAnyOrder("Batman", "Superman")));
    }

    @DynamicPropertySource
    static void databaseProperties(DynamicPropertyRegistry registry) {
        registry.add("spring.datasource.url", database::getJdbcUrl);
        registry.add("spring.datasource.username", database::getUsername);
        registry.add("spring.datasource.password", database::getPassword);
    }
}

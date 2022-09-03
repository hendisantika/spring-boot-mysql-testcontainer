package com.hendisantika;

import com.hendisantika.universum.HeroSpringDataJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

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
    private static final MySQLContainer database = new MySQLContainer();

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private HeroSpringDataJpaRepository heroRepository;
}

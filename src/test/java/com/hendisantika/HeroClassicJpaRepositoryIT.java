package com.hendisantika;

import com.hendisantika.universum.HeroClassicJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
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
 * Time: 09:21
 * To change this template use File | Settings | File Templates.
 */
@SpringBootTest
@Testcontainers
class HeroClassicJpaRepositoryIT {
    @Container
    private static final MySQLContainer database = new MySQLContainer();

    @Autowired
    private HeroClassicJpaRepository repositoryUnderTest;
}

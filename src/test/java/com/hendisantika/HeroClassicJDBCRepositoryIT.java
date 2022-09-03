package com.hendisantika;

import com.hendisantika.universum.HeroClassicJDBCRepository;
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
 * Time: 09:16
 * To change this template use File | Settings | File Templates.
 */
@Testcontainers
class HeroClassicJDBCRepositoryIT {
    @Container
    private final MySQLContainer database = new MySQLContainer();

    private HeroClassicJDBCRepository repositoryUnderTest;

}

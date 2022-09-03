package com.hendisantika;

import com.hendisantika.universum.HeroClassicJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-mysql-testcontainer
 * User: powercommerce
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 9/3/22
 * Time: 09:23
 * To change this template use File | Settings | File Templates.
 */
@SpringBootTest
class HeroClassicJpaRepositoryReuseDatabaseIT extends DatabaseBaseTest {

    @Autowired
    private HeroClassicJpaRepository repositoryUnderTest;

}

package com.hendisantika;

import org.testcontainers.utility.DockerImageName;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-mysql-testcontainer
 * User: powercommerce
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 9/4/22
 * Time: 06:00
 * To change this template use File | Settings | File Templates.
 */
public class MySQLTestImages {
    public static final DockerImageName MYSQL_56_IMAGE = DockerImageName.parse("mysql:5.6.51");

    public static final DockerImageName MYSQL_57_IMAGE = DockerImageName.parse("mysql:5.7.34");

    public static final DockerImageName MYSQL_80_IMAGE = DockerImageName.parse("mysql:8.4.0");

    public static final DockerImageName MYSQL_910_IMAGE = DockerImageName.parse("mysql:9.1.0");
}

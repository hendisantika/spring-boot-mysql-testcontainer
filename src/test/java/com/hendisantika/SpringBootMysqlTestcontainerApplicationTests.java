package com.hendisantika;

import com.hendisantika.universum.Hero;
import com.hendisantika.universum.HeroRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.testcontainers.containers.MySQLContainer;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
class SpringBootMysqlTestcontainerApplicationTests {

    private static final MySQLContainer<?> mySQLContainer;

    static {
        mySQLContainer = (MySQLContainer<?>) new MySQLContainer("mysql:9.1.0")
                .withDatabaseName("demo")
                .withUsername("root")
                .withPassword("root");
//                .withInitScript("/start.sql");
        mySQLContainer.start();

//        rabbitMQContainer= new RabbitMQContainer("rabbitmq:management")
//                .withAdminPassword("guest");

    }

//    private static RabbitMQContainer rabbitMQContainer;

    @Autowired
    private HeroRepository heroRepository;

    @Test
    void testAllEmployees() {
        List<Hero> lists = heroRepository.findAll();
        assertThat(lists).hasSize(18);
    }

	/*

	.withEnv(Map.of());
	.withCopyFileToContainer(MountableFile.forHostPath("/tmp/dump.json"), "/tmp/dump.json")
	.waitingFor(Wait.forLogMessage(".*Initialized\\.\n", 1))
	.withReuse(true)
	 ~/.testcontainers.properties   testcontainers.reuse.enable=true
	 static GenericContainer<?> keycloak =
  new GenericContainer<>(DockerImageName.parse("jboss/keycloak:11.0.0"))
    .waitingFor(Wait.forHttp("/auth").forStatusCode(200))
    .withExposedPorts(8080)
    .withClasspathResourceMapping("/config/test.txt", "/tmp/test.txt", BindMode.READ_WRITE)
    .withEnv(Map.of(
      "KEYCLOAK_USER", "testcontainers",
      "KEYCLOAK_PASSWORD", "testcontainers",
      "DB_VENDOR", "h2"
));
.withCommand("/bin/sh", "-c",
        "while true; do echo \"$MAGIC_NUMBER\" | nc -l -p 80; done")

	static class Initializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {
        public void initialize(ConfigurableApplicationContext configurableApplicationContext) {
            TestPropertyValues.of(
              "spring.datasource.url=" + mySQLContainer.getJdbcUrl(),
              "spring.datasource.username=" + mySQLContainer.getUsername(),
              "spring.datasource.password=" + mySQLContainer.getPassword(),
			  "spring.rabbitmq.host=" + rabbitMQContainer.getContainerIpAddress(),
			  "spring.rabbitmq.port=" + rabbitMQContainer.getMappedPort(5672)
            ).applyTo(configurableApplicationContext.getEnvironment());
        }
    }


	*/
}

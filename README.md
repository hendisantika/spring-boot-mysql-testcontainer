# spring-boot-mysql-testcontainer

[![Java CI with Maven](https://github.com/hendisantika/spring-boot-mysql-testcontainer/actions/workflows/maven.yml/badge.svg)](https://github.com/hendisantika/spring-boot-mysql-testcontainer/actions/workflows/maven.yml)
![Java](https://img.shields.io/badge/Java-25-orange?logo=openjdk)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-4.1-6DB33F?logo=springboot)
![Testcontainers](https://img.shields.io/badge/Testcontainers-2.x-2D9CDB)
![MySQL](https://img.shields.io/badge/MySQL-9.1-4479A1?logo=mysql&logoColor=white)
![Dependabot](https://img.shields.io/badge/Dependabot-enabled-025E8C?logo=dependabot)

Sample Spring Boot application that stores comic **heroes** in MySQL and shows several ways of
testing the persistence layer against a real MySQL database using [Testcontainers](https://testcontainers.com/).

## Tech Stack

| Component        | Version |
|------------------|---------|
| Java (JDK)       | 25      |
| Spring Boot      | 4.1.x   |
| Testcontainers   | 2.x     |
| JUnit Jupiter    | 6.x     |
| MySQL            | 9.1.0   |
| Maven            | 3.8+    |

Other libraries: Spring Data JPA, Spring MVC + Thymeleaf, Actuator, Lombok, WebJars (Bootstrap, Font Awesome).

## Project Structure

```
src/main/java/com/hendisantika
├── controller
│   ├── HeroController.java          # Thymeleaf UI (list / search / new hero)
│   └── HeroRestController.java      # REST endpoint
└── universum
    ├── Hero.java                    # JPA entity
    ├── HeroRepository.java          # Spring Data JPA repository
    ├── HeroSpringDataJpaRepository.java
    ├── HeroClassicJpaRepository.java  # EntityManager based repository
    └── HeroClassicJDBCRepository.java # plain JDBC repository

src/test/java/com/hendisantika
├── SpringBootMysqlTestcontainerApplicationTests.java  # unit phase (Surefire)
└── *IT.java                                           # integration tests (Failsafe)
```

## Prerequisites

- JDK 25 (e.g. [Eclipse Temurin](https://adoptium.net/))
- Maven 3.8+ (or the bundled `./mvnw`)
- Docker (required by Testcontainers and Docker Compose)

## Running the Application

The project contains a [`compose.yml`](compose.yml) with a MySQL 9.1.0 service. Thanks to
`spring-boot-docker-compose`, the database is started automatically when you run the app:

```bash
./mvnw spring-boot:run
```

Or start MySQL manually:

```bash
docker compose up -d
```

> Database data is stored in the local `mysql910/` folder (ignored by git).

Useful URLs:

- Search hero (UI): <http://localhost:8080/hero>
- List heroes (UI): <http://localhost:8080/hero/list>
- New hero (UI): <http://localhost:8080/hero/new>
- REST – all heroes: `GET http://localhost:8080/heros`
- REST – add hero: `POST http://localhost:8080/hero`
- Health check: <http://localhost:8080/actuator/health>

## Running the Tests

Tests start a throwaway MySQL container through Testcontainers, so Docker must be running.

```bash
# Unit phase (what CI runs)
./mvnw -B package

# Unit + integration tests (*IT.java via maven-failsafe-plugin)
./mvnw -B verify
```

`src/test/resources/application.properties` uses the Testcontainers JDBC URL
(`jdbc:tc:mysql:9.1.0:///hero`), which spins up MySQL automatically for the Spring context.

## Continuous Integration

GitHub Actions workflow: [`.github/workflows/maven.yml`](.github/workflows/maven.yml)

- Runs on every push / pull request to `main` (and manually via *workflow_dispatch*).
- Builds with **JDK 25 (Temurin)** and caches Maven dependencies.
- Uses [Testcontainers Cloud](https://testcontainers.com/cloud/) when the `TC_CLOUD_TOKEN`
  secret is available; otherwise (e.g. Dependabot or fork PRs) it falls back to the runner's Docker.
- On pushes to `main`, submits the Maven dependency graph to GitHub for better Dependabot alerts.

## Dependency Updates

[Dependabot](.github/dependabot.yml) keeps dependencies up to date:

| Ecosystem       | Schedule              | Grouped updates                                                          |
|-----------------|-----------------------|--------------------------------------------------------------------------|
| Maven           | daily 05:00 WIB       | Spring Boot, Testcontainers, test libraries, WebJars, Maven plugins, DB   |
| GitHub Actions  | daily 05:00 WIB       | all actions in one PR                                                    |
| Docker Compose  | weekly (Monday)       | images in `compose.yml`                                                  |

PRs are labelled (`dependencies`, `java`, `github_actions`, `docker`) and use conventional commit prefixes
(`chore(deps): ...`, `chore(deps-dev): ...`, `ci(deps): ...`).

## Author

**Hendi Santika**

- Email: hendisantika@gmail.com
- Telegram: [@hendisantika34](https://t.me/hendisantika34)
- Link: [s.id/hendisantika](https://s.id/hendisantika)

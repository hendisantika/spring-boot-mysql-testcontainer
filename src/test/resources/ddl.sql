CREATE TABLE IF NOT EXISTS hero
(
    id        bigint AUTO_INCREMENT PRIMARY KEY,
    city      varchar(255),
    name      varchar(255),
    universum varchar(255)
) engine = InnoDB;

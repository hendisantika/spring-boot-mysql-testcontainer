CREATE TABLE hero
(
    id        bigint AUTO_INCREMENT PRIMARY KEY,
    city      varchar(255),
    name      varchar(255),
    universum varchar(255)
) engine=InnoDB;

-- CREATE SEQUENCE hero_seq
--     INCREMENT 1
--     START 5;

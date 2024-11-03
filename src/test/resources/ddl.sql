create table hero
(
    hero_id bigint AUTO_INCREMENT PRIMARY KEY,
    city      varchar(255),
    name      varchar(255),
--     universum varchar(255)
    universum tinyint CHECK (universum BETWEEN 0 AND 1),
) engine=InnoDB;

CREATE TABLE hero_seq
(
    next_val bigint
) engine=InnoDB;

create table if not exists cat
(
    id   bigint NOT NULL AUTO_INCREMENT,
    name varchar(255),
    age  int,
    primary key (id)
);
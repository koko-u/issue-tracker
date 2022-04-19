DROP TABLE IF EXISTS issues;
CREATE TABLE issues
(
    id          BIGINT        NOT NULL AUTO_INCREMENT,
    summary     VARCHAR(256)  NOT NULL,
    description VARCHAR(1000) NULL,
    PRIMARY KEY (id)
);

DROP TABLE IF EXISTS users;
CREATE TABLE users (
    username    VARCHAR(256) NOT NULL,
    password    VARCHAR(100) NOT NULL,
    PRIMARY KEY (username)
)

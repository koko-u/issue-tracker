DROP TABLE IF EXISTS issues;
CREATE TABLE issues
(
    id          BIGINT        NOT NULL AUTO_INCREMENT,
    summary     VARCHAR(256)  NOT NULL,
    description VARCHAR(1000) NULL,
    PRIMARY KEY (id)
);
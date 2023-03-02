--liquibase formatted sql

--changeset pruglo-ve:20230223-1 failOnError:true
--comment: Create jobs table.
--preconditions onFail:MARK_RAN onError:HALT
--precondition-sql-check expectedResult:0 select count(*) from information_schema.tables where table_name = 'jobs';
CREATE TABLE IF NOT EXISTS jobs (
    id          BIGSERIAL,
    job         VARCHAR(50) NOT NULL,
    type        VARCHAR(50) NOT NULL,
    user        VARCHAR(50) NOT NULL,
    device      VARCHAR(50) NOT NULL,
    amount      REAL,
    time        TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP
);

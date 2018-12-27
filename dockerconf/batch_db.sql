CREATE DATABASE batch_test;

CREATE USER batch_user WITH password '123' CREATEDB;

GRANT ALL PRIVILEGES ON DATABASE batch_test to batch_user

CREATE DATABASE IF NOT EXISTS batch_test;
DROP USER IF EXISTS 'batch_user'@'%';
FLUSH PRIVILEGES;
CREATE USER 'batch_user'@'%' identified by '123';
GRANT ALL PRIVILEGES ON batch_test.* TO 'batch_user'@'%';
CREATE DATABASE IF NOT EXISTS batch_test;


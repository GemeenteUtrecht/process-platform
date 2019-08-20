CREATE USER 'camunda'@'%' IDENTIFIED BY 'camunda';
CREATE DATABASE camunda;
GRANT ALL PRIVILEGES ON camunda.* TO 'camunda'@'%';
FLUSH PRIVILEGES;

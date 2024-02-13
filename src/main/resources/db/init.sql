CREATE DATABASE IF NOT EXISTS articleshub;
USE articleshub;

CREATE USER IF NOT EXISTS 'sharphurt'@'%' IDENTIFIED BY 'password';
GRANT ALL PRIVILEGES ON articleshub.* TO 'sharphurt'@'%' WITH GRANT OPTION;
FLUSH PRIVILEGES;
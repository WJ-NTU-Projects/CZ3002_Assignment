CREATE DATABASE IF NOT EXISTS `ase`;
USE `ase`;

CREATE TABLE IF NOT EXISTS `users`(
	`id` INT(11) UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
	`username` VARCHAR(20) NOT NULL UNIQUE,
    `password` VARCHAR(20) NOT NULL
);

INSERT INTO `users` (`username`, `password`) VALUES ('test', 'test');
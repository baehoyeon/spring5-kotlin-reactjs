CREATE TABLE `spring_kotlin_example`.`users` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(100) NOT NULL,
  `phoneNumber` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`id`));

INSERT INTO `spring_kotlin_example`.`users` (`name`, `phoneNumber`) VALUES ('qoo', '010-1234-1234');
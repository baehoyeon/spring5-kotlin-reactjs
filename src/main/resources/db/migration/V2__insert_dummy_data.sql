SELECT @UserId := max(id) FROM `spring_kotlin_example`.`users`;

INSERT INTO `spring_kotlin_example`.`users` (`id`, `name`, `phoneNumber`) VALUES ((@UserId := @UserId + 1), 'pooh', '010-1234-4321');
INSERT INTO `spring_kotlin_example`.`users` (`id`, `name`, `phoneNumber`) VALUES ((@UserId := @UserId + 1), 'kotlin', '010-4321-1234');
INSERT INTO `spring_kotlin_example`.`users` (`id`, `name`, `phoneNumber`) VALUES ((@UserId := @UserId + 1), 'java', '010-4321-4321');
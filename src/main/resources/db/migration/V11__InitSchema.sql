CREATE TABLE `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(255) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
);

insert into user(user_name, password, email) VALUES
('admin', '123', 'admin@gmail.com'),
('user', '123', 'user@gmail.com');
CREATE TABLE `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(255) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `activated` boolean default true,
  PRIMARY KEY (`id`)
);

insert into user(user_name, password, email) VALUES
('admin', '123', 'admin@gmail.com'),
('user', '123', 'user@gmail.com');

create table authority(name varchar(50) primary key);
insert into authority VALUES('ROLE_USER'), ('ROLE_ADMIN');

create table user_authority(
    user_id bigint not null references user(id),
    authority_name varchar(50) not null references authority(name),
    primary key(user_id, authority_name)
);

insert into user_authority(user_id, authority_name) VALUES
(1, 'ROLE_ADMIN'), (1, 'ROLE_USER'), (2, 'ROLE_USER');


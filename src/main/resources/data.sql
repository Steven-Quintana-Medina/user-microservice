INSERT INTO `user` (
    `name`,
    `surname`,
    `dni_number`,
    `phone`,
    `birth_date`,
    `mail`,
    `password`,
    `id_rol`

  )
VALUES
  (
    "daniela",
    "castillo",
    "4443335",
    "+573004014079",
    "01-05-2002",
    "steven0@gmail.com",
    "$2a$10$WbDy3xcppa4UZiyWjFCUGudx5Z4VIfH31q.TdOMQPxWvvVOmE.3ay",
    '1'
  );


INSERT INTO `role` (`id`, `description`, `name`) VALUES ('1', 'ROLE_ADMIN', 'ROLE_ADMIN');
INSERT INTO `role` (`id`, `description`, `name`) VALUES ('2', 'ROLE_ADMIN', 'ROLE_OWNER');
INSERT INTO `role` (`id`, `description`, `name`) VALUES ('3', 'ROLE_USER', 'ROLE_EMPLOYEE');
INSERT INTO `role` (`id`, `description`, `name`) VALUES ('4', 'ROLE_USER', 'ROLE_USER');
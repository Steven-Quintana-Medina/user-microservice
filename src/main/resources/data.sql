INSERT INTO `user` (
    `id`,
    `name`,
    `surname`,
    `dni_number`,
    `phone`,
    `birth_date`,
    `mail`,
    `password`,
    `id_role`

  )
VALUES
  (
    '1',
    "daniela",
    "castillo",
    "4443335",
    "+573004014079",
    "01-05-2002",
    "steven0@gmail.com",
    "$2a$10$GlsGSNhkbVon6ZOSNMptOu5RikedRzlCAhMa7YpwvUSS0c88WT99S",
    '1'
  );


INSERT INTO `role` (`id`, `description`, `name`) VALUES ('1', 'ROLE_ADMIN', 'ROLE_ADMIN');
INSERT INTO `role` (`id`, `description`, `name`) VALUES ('2', 'ROLE_ADMIN', 'ROLE_OWNER');
INSERT INTO `role` (`id`, `description`, `name`) VALUES ('3', 'ROLE_USER', 'ROLE_EMPLOYEE');
INSERT INTO `role` (`id`, `description`, `name`) VALUES ('4', 'ROLE_USER', 'ROLE_USER');
insert into users (id, name, password, email, is_locked) values (1, 'Martin Ruiz', '12345', 'martin.ruiz@sciodev.com', 0);
insert into users (id, name, password, email, is_locked) values (2, 'Luisa Ruiz', '6789', 'luisita@gmail.com', 0);
insert into users (id, name, password, email, is_locked) values (3, 'Ivan Guerrero', '101112', 'ivgrocar@gmail.com', 0);
insert into posts (id, content, user_name) values (1, 'This is my test post!', 'Ivan Guerrero');
insert into comments (id, name, content, post_id) values (1, 'Ivan', 'Nice Test!', 1);
insert into comments (id, name, content, post_id) values (2, 'Ivan', 'Test', 1);
insert into posts (id, content, user_name) values (2, 'Hello World', 'Luisa Ruiz');
insert into comments (id, name, content, post_id) values (3, 'Ivan', 'Well Done', 2);


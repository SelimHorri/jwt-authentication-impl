
INSERT INTO employees (fname, lname, email, image_url, hiredate) VALUES
('selim', 'horri', 'slim__horri@hotmail.com', 'https://bootdey.com/img/Content/avatar/avatar7.png', '2019-04-15'),
('omar', 'derouiche', 'omar.derouiche@gmail.com', 'https://bootdey.com/img/Content/avatar/avatar6.png', '2020-04-01'),
('amine', 'ladjimi', 'amine.ladjimi@yahoo.fr', 'https://bootdey.com/img/Content/avatar/avatar5.png', '2021-04-01');



INSERT INTO credentials (username, password, role, is_enabled, employee_id) VALUES
('selimhorri', '0000', 'ROLE_ADMIN', true, 1),
('omarderouiche', '0000', 'ROLE_EMP', true, 2),
('amineladjimi', '0000', 'ROLE_EMP', true, 3);



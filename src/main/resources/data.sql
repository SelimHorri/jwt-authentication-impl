
INSERT INTO employees (fname, lname, email, image_url, hiredate) VALUES
('selim', 'horri', 'slim__horri@hotmail.com', 'https://bootdey.com/img/Content/avatar/avatar7.png', '2019-04-15'),
('omar', 'derouiche', 'omar.derouiche@gmail.com', 'https://bootdey.com/img/Content/avatar/avatar6.png', '2020-04-01'),
('amine', 'ladjimi', 'amine.ladjimi@yahoo.fr', 'https://bootdey.com/img/Content/avatar/avatar5.png', '2021-04-01');



INSERT INTO credentials (username, password, role, is_enabled, employee_id) VALUES
('selimhorri', '$2y$04$Q9pzEAa6PXL3mkZbBShMKexmLf7ssB0AM0C4yz56bqXXtAnxET1Y6', 'ROLE_ADMIN', true, 1),
('omarderouiche', '$2y$04$Ayjxb8KGrI2834PBry1kxuqKpoqJsGX6pz31RaD9wnBRFotITmb1m', 'ROLE_EMP', true, 2),
('amineladjimi', '$2y$04$DIaM/W.iu9K2d0ONEAc1nO.d1k55TPPBMGAn9RGzCX0UQYJ.mIBui', 'ROLE_EMP', true, 3);



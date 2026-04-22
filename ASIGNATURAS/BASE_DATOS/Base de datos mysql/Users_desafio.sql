-- 1. INSERTAR UN USUARIO QUE SERÁ ADMINISTRADOR
use casino;

-- 1. INSERTAR EL USUARIO PADRE (Jorge)
INSERT INTO usuarios (nombre, edad, email, contraseña)
VALUES ('Jorge Ferrando', 20, 'jorh845@gmail.com', 'caballos2026');


INSERT INTO usuarios (nombre, edad, email, contraseña) 
VALUES ('Alberto', 20, 'alberto@gmail.com', 'caballos2026');

INSERT INTO usuarios (nombre, edad, email, contraseña) 
VALUES ('Anthony', 20 , 'anthony@gmail.com', 'caballos2026');

INSERT INTO usuarios (nombre, edad, email, contraseña) 
VALUES ('Fernando Alonso', 44, 'usuario1@gmail.com', 'usuario123');

-- 2. CREAR CABALLOS (5)

-- CABALLO 1
INSERT INTO caballos (id_caballo,nombre, color) 
VALUES (1, "Josep", "Rojo");

-- CABALLO 2
INSERT INTO caballos (id_caballo,nombre, color) 
VALUES (2, "Javier", 'Verde');

-- CABALLO 3
INSERT INTO caballos (id_caballo,nombre, color) 
VALUES (3, "Alberto", 'Blanco');


-- CABALLO 4
INSERT INTO caballos (id_caballo,nombre, color) 
VALUES (4, "Edgar", 'Marron');

-- CABALLO 5
INSERT INTO caballos (id_caballo,nombre, color) 
VALUES (5, "Sionne", 'Negro');

-- Caballo 6
Insert Into caballos (id_caballo,nombre, color) 
VALUES (6, "Lucas", 'Amarillo');
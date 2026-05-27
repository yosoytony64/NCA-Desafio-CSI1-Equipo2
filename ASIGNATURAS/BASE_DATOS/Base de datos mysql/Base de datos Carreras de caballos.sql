create database casino;

use casino;

-- 1. TABLA: USUARIOS
-- Es la tabla "padre" de la jerarquía de usuarios.
-- Contiene los datos comunes para el inicio de sesión.

CREATE TABLE Usuarios (
	-- PK: Identificador único universal para cualquier persona en el sistema.
    id_usuario INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    contraseña VARCHAR(255) NOT NULL,
    edad int not null,
	saldo DECIMAL(10,2) DEFAULT 500.0 CHECK (saldo >= 500)

);
-- TABLA 2 CLIENTES(HERENCIA DE USUARIOS)
-- Especialización de Usuarios. Relación 1:1.
-- El id_usuario es PK y FK a la vez.
-- PK: Identificador único del cliente. 
-- FK: Conecta con Usuarios.id_usuario para obtener sus datos personales.
-- RELACIÓN: Si borras el usuario, el registro de cliente se elimina (CASCADE).
create table Clientes(
	id_usuario INT PRIMARY KEY,
	FOREIGN KEY (id_usuario) REFERENCES Usuarios(id_usuario)
	ON DELETE CASCADE ON UPDATE CASCADE
);

-- TABLA 3 ADMINISTRADORES
-- Especialización de Usuarios. Relación 1:1.
-- PK: Identificador único del administrador.
-- FK: Conecta con Usuarios.id_usuario (Relación 1 a 1).
-- RELACIÓN: Vinculación obligatoria con la tabla padre Usuarios.
CREATE TABLE Administradores (
    id_usuario INT PRIMARY KEY,
    nivel_acceso ENUM('Usuario', 'Administrador', 'SuperAdmin') NOT NULL,
   
    FOREIGN KEY (id_usuario) REFERENCES Usuarios(id_usuario)
    
        ON DELETE CASCADE ON UPDATE CASCADE
);
-- 4. CABALLOS
-- Entidad padre que contiene la información de los caballos.
-- PK: ID único para identificar a cada caballo en el sistema.
CREATE TABLE Caballos (
    id_caballo INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100),
    color VARCHAR(50),
    probabilidad INT
);

-- 5. TABLA CARRERAS
-- PK: ID único para cada evento de carrera.
CREATE TABLE Carreras (
    id_carrera INT AUTO_INCREMENT PRIMARY KEY,
    fecha_hora DATETIME NOT NULL,
    estado ENUM("Pendiente", "En curso", "Finalizada") DEFAULT "Pendiente"
    );
    
-- 6. APUESTAS (Conecta directamente con Clientes, Caballos y Carreras)
-- PK: ID único para cada ticket de apuesta generado.
-- FK1: Indica qué CLIENTE realizó la apuesta. Conecta con Clientes para saber quién paga/cobra.
-- FK2: Indica por qué CABALLO se apostó. Conecta con Caballos. Impide borrar caballos con apuestas (RESTRICT).
-- FK3: Indica en qué CARRERA se realizó la apuesta.  Conecta con Carreras. Impide borrar carreras con apuestas (RESTRICT).
CREATE TABLE Apuestas (
    id_apuesta INT AUTO_INCREMENT PRIMARY KEY,
    id_usuario INT,
    id_caballo INT,
    id_carrera INT,
    importe DECIMAL(10, 2) NOT NULL,
    resultado ENUM('Pendiente', 'Ganada', 'Perdida') DEFAULT 'Pendiente',
    cuota DECIMAL(5, 2) NOT NULL,
    -- Si el cliente se borra, sus apuestas desaparecen (CASCADE)
    FOREIGN KEY (id_usuario) REFERENCES Clientes(id_usuario),
    FOREIGN KEY (id_caballo) REFERENCES Caballos(id_caballo),
    FOREIGN KEY (id_carrera) REFERENCES Carreras(id_carrera)
		ON DELETE RESTRICT
        
    );

-- 7. TABLA: RESULTADOS     
-- Relación 1:1 con Carreras. Guarda el ganador.
-- FK: Identificador del caballo que ganó (conecta con Caballos).
-- PK y FK: Identificador de la carrera (Relación 1 a 1 con Carreras).
-- FK1 Vincula el podio con su carrera correspondiente.
-- FK2 Asegura que el ganador sea un caballo existente.

CREATE TABLE Resultados (
    id_carrera INT PRIMARY KEY,
    id_ganador INT,
    FOREIGN KEY (id_carrera) REFERENCES Carreras(id_carrera),
    FOREIGN KEY (id_ganador) REFERENCES Caballos(id_caballo)
);
-- 8. MOVIMIENTOS
-- Registra cada cambio de dinero.
-- PK: ID único para cada registro de auditoría financiera
-- FK: Indica a qué USUARIO pertenece este movimiento de dinero. Histórico vinculado al usuario para trazabilidad.
CREATE TABLE Movimientos (
    id_movimientos INT AUTO_INCREMENT PRIMARY KEY,
    id_usuario INT,
    id_apuesta INT NULL, -- Opcional: para saber qué apuesta generó el movimiento
    monto DECIMAL(10, 2) NOT NULL,
    fecha TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    tipo_movimiento ENUM('Ingreso', 'Apuesta', 'Premio', 'Donacion'),
    FOREIGN KEY (id_usuario) REFERENCES Usuarios(id_usuario),
    FOREIGN KEY (id_apuesta) REFERENCES Apuestas(id_apuesta)
		ON DELETE CASCADE
);

CREATE TABLE Donaciones (
    
    id_donacion INT AUTO_INCREMENT PRIMARY KEY,
    id_usuario INT,
    id_apuesta INT,
    monto_donado DECIMAL(10,2) NOT NULL, 
    fecha TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (id_usuario) REFERENCES Usuarios(id_usuario) ON DELETE CASCADE,
    FOREIGN KEY (id_apuesta) REFERENCES Apuestas(id_apuesta) ON DELETE CASCADE
);

create table ONGS(
	id_ong int auto_increment primary key,
    nombre varchar(100),
    area varchar(100),
    donacion_total varchar(100)
);
insert into ONGS(id_ong, nombre, area, donacion_total) 
values( 1, "Medicos sin fronteras","Salud","2.400M");

INSERT INTO ONGS (id_ong, nombre, area, donacion_total)
VALUES (2, 'Cruz Roja', 'Emergencias', '1.80M');

INSERT INTO ONGS (id_ong, nombre, area, donacion_total) 
VALUES (3, 'UNICEF', 'Infancia', '300M'); 

INSERT INTO ONGS (id_ong, nombre, area, donacion_total) 
VALUES (4, 'WWF', 'Medio Ambiente', '1.200M'); 

INSERT INTO ONGS (id_ong, nombre, area, donacion_total) 
VALUES (5, 'Save the Children', 'Educacion', '9.50M');

INSERT INTO ONGS (id_ong, nombre, area, donacion_total)
VALUES (6, 'Amnesty International', 'Derechos Humanos', '850M');

INSERT INTO ONGS (id_ong, nombre, area, donacion_total)
VALUES (7, 'Greenpeace', 'Medio Ambiente', '1.500M');

INSERT INTO ONGS (id_ong, nombre, area, donacion_total)
VALUES (8, 'Oxfam', 'Pobreza y Desarrollo', '2.100M');

INSERT INTO ONGS (id_ong, nombre, area, donacion_total)
VALUES (9, 'World Vision', 'Infancia y Desarrollo', '980M');

INSERT INTO ONGS (id_ong, nombre, area, donacion_total)
VALUES (10, 'Caritas', 'Asistencia Social', '1.750M');

INSERT INTO ONGS (id_ong, nombre, area, donacion_total)
VALUES (11, 'Doctors of the World', 'Salud', '620M');

INSERT INTO ONGS (id_ong, nombre, area, donacion_total)
VALUES (12, 'Mercy Corps', 'Ayuda Humanitaria', '1.300M');

INSERT INTO ONGS (id_ong, nombre, area, donacion_total)
VALUES (13, 'ActionAid', 'Pobreza y Justicia Social', '540M');

INSERT INTO ONGS (id_ong, nombre, area, donacion_total)
VALUES (14, 'Plan International', 'Infancia', '1.100M');

INSERT INTO ONGS (id_ong, nombre, area, donacion_total)
VALUES (15, 'Habitat for Humanity', 'Vivienda', '770M');
-- CAMBIOS/MODIFICACIONES BASE DATOS
select * from administradores;
SELECT * FROM Usuarios;
select * from caballos;

ALTER TABLE Usuarios
ADD COLUMN nivel_acceso INT NOT NULL DEFAULT 1;

ALTER TABLE Usuarios 
MODIFY COLUMN nivel_acceso ENUM('Usuario', 'Administrador', 'SuperAdmin') NOT NULL;

ALTER TABLE Usuarios 
ADD COLUMN edad INT NOT NULL ;

ALTER TABLE usuarios ADD CONSTRAINT chk_edad CHECK (edad >= 18);
SET FOREIGN_KEY_CHECKS = 0;

TRUNCATE TABLE administradores;
TRUNCATE TABLE clientes;
TRUNCATE TABLE usuarios;
SET FOREIGN_KEY_CHECKS = 1;
ALTER TABLE usuarios ADD CONSTRAINT chk_edad CHECK (edad >= 18);
SELECT * FROM usuarios WHERE edad > 18;
DELETE FROM Usuarios WHERE id_usuario = 3;

ALTER TABLE Usuarios 
DROP COLUMN nivel_acceso;

ALTER TABLE Administradores 
ADD COLUMN nivel_acceso ENUM('Usuario', 'Administrador', 'SuperAdmin') NOT NULL;

ALTER TABLE Administradores 
ADD COLUMN nivel_acceso ENUM('Usuario', 'Administrador', 'SuperAdmin') NOT NULL;

ALTER TABLE Administradores DROP COLUMN nivel_acceso;

ALTER TABLE Apuestas DROP FOREIGN KEY apuestas_ibfk_1;

ALTER TABLE Apuestas 
ADD CONSTRAINT fk_apuestas_usuario
FOREIGN KEY (id_usuario) REFERENCES Usuarios(id_usuario)
ON DELETE CASCADE;

DELETE FROM caballos WHERE id_caballo = 5;
ALTER TABLE clientes 
ALTER COLUMN saldo SET DEFAULT 500.0;
ALTER TABLE Usuarios ADD COLUMN saldo DECIMAL(10,2) DEFAULT 500.0;
ALTER TABLE Clientes DROP COLUMN saldo;



















-- consultas

-- 1. Mostrar todas las ONGs registradas
SELECT * 
FROM ONGS;


-- 2. Mostrar solo el nombre y el área de cada ONG
SELECT nombre, area 
FROM ONGS;


-- 3. Obtener todas las ONGs que pertenecen al área de Salud
SELECT * 
FROM ONGS
WHERE area = 'Salud';


-- 4. Buscar ONGs cuyo área contenga la palabra "Infancia"
SELECT * 
FROM ONGS
WHERE area LIKE '%Infancia%';


-- 5. Ordenar las ONGs alfabéticamente por nombre
SELECT * 
FROM ONGS
ORDER BY nombre ASC;


-- 6. Ordenar las ONGs por donación total (orden descendente)
-- NOTA: se ordena como texto porque el campo es VARCHAR
SELECT * 
FROM ONGS
ORDER BY donacion_total DESC;


-- 7. Contar el número total de ONGs registradas
SELECT COUNT(*) AS total_ongs 
FROM ONGS;


-- 8. Mostrar los nombres de las ONGs del área "Medio Ambiente"
SELECT nombre 
FROM ONGS
WHERE area = 'Medio Ambiente';


-- 9. Buscar una ONG específica por su nombre (UNICEF)
SELECT * 
FROM ONGS
WHERE nombre = 'UNICEF';


-- 10. Mostrar las ONGs que NO pertenecen al área de Salud
SELECT * FROM ONGS
WHERE area <> 'Salud';


-- 11. Mostrar ONGs cuyo nombre comienza con la letra "M"
SELECT * 
FROM ONGS
WHERE nombre LIKE 'M%';


-- 12. Agrupar ONGs por área y contar cuántas hay en cada una
SELECT area, COUNT(*) AS cantidad
FROM ONGS
GROUP BY area;


-- 13. Buscar ONGs con donaciones que contienen "1." (simulación)
-- NOTA: esto es solo una aproximación porque el campo es texto
SELECT * 
FROM ONGS
WHERE donacion_total LIKE '%1.%';

-- 14. Mostrar la ONG con la mayor donación (usando subconsulta)
SELECT * FROM ONGS
WHERE donacion_total = (
    SELECT MAX(donacion_total) FROM ONGS
);


-- 15. Mostrar ONGs que tienen la misma área que UNICEF
SELECT * FROM ONGS
WHERE area = (
    SELECT area FROM ONGS
    WHERE nombre = 'UNICEF'
);


-- 16. Mostrar ONGs cuya donación es mayor que la de "Cruz Roja"
SELECT * FROM ONGS
WHERE donacion_total > (
    SELECT donacion_total FROM ONGS
    WHERE nombre = 'Cruz Roja'
);


-- 17. Mostrar ONGs que pertenecen a áreas con más de una ONG
SELECT * FROM ONGS
WHERE area IN (
    SELECT area FROM ONGS
    GROUP BY area
    HAVING COUNT(*) > 1
);


-- 18. Mostrar ONGs que NO están en el área de Salud (usando subconsulta)
SELECT * FROM ONGS
WHERE area NOT IN (
    SELECT area FROM ONGS
    WHERE area = 'Salud'
);


-- 19. Mostrar ONGs cuya donación es igual al promedio (simulado)
SELECT * FROM ONGS
WHERE donacion_total = (
    SELECT AVG(donacion_total) FROM ONGS
);


-- 20. Mostrar ONGs que tienen la misma donación que otra ONG
SELECT * FROM ONGS
WHERE donacion_total IN (
    SELECT donacion_total FROM ONGS
    GROUP BY donacion_total
    HAVING COUNT(*) > 1
);


-- 21. Mostrar la ONG con la menor donación
SELECT * FROM ONGS
WHERE donacion_total = (
    SELECT MIN(donacion_total) FROM ONGS
);


-- 22. Mostrar ONGs cuya área está entre las más repetidas
SELECT * FROM ONGS
WHERE area IN (
    SELECT area FROM ONGS
    GROUP BY area
    ORDER BY COUNT(*) DESC
    LIMIT 3
);

-- 23. CREAR USUARIO
CREATE USER 'usuario_ong'@'localhost' IDENTIFIED BY '1234';


-- 24. CREAR ROL
CREATE ROLE 'rol_ong';


-- 25. ASIGNAR PRIVILEGIOS AL ROL
GRANT SELECT, INSERT ON ONGS TO 'rol_ong';


-- 26. ASIGNAR ROL AL USUARIO
GRANT 'rol_ong' TO 'usuario_ong';


-- 27. ACTIVAR ROL POR DEFECTO
SET DEFAULT ROLE 'rol_ong' TO 'usuario_ong';


-- 28. CREAR VISTA DE ONGS DE SALUD
CREATE VIEW vista_salud AS
SELECT nombre, area, donacion_total
FROM ONGS
WHERE area = 'Salud';


-- 29. CONSULTAR VISTA DE SALUD
SELECT * FROM vista_salud;


-- 30. CREAR VISTA DE DONACIONES ALTAS
CREATE VIEW vista_donaciones_altas AS
SELECT nombre, donacion_total
FROM ONGS
WHERE donacion_total LIKE '1.%';


-- 31. CREAR ÍNDICE POR NOMBRE
CREATE INDEX idx_nombre ON ONGS(nombre);


-- 32. CREAR ÍNDICE POR ÁREA
CREATE INDEX idx_area ON ONGS(area);


-- 33. PROCEDIMIENTO: ONGS POR ÁREA
DELIMITER //

CREATE PROCEDURE obtenerONGsPorArea(IN areaBuscada VARCHAR(100))
BEGIN
    SELECT * FROM ONGS
    WHERE area = areaBuscada;
END //

DELIMITER ;


-- 34. EJECUTAR PROCEDIMIENTO
CALL obtenerONGsPorArea('Salud');


-- 35. TRIGGER: VALIDAR NOMBRE NO VACÍO
DELIMITER //

CREATE TRIGGER validar_nombre
BEFORE INSERT ON ONGS
FOR EACH ROW
BEGIN
    IF NEW.nombre = '' THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'El nombre no puede estar vacío';
    END IF;
END //

DELIMITER ;


-- 36. FUNCIÓN: CONTAR ONGS POR ÁREA
DELIMITER //

CREATE FUNCTION contarONGs(areaBuscada VARCHAR(100))
RETURNS INT
DETERMINISTIC
BEGIN
    DECLARE total INT;

    SELECT COUNT(*) INTO total
    FROM ONGS
    WHERE area = areaBuscada;

    RETURN total;
END //

DELIMITER ;


-- 37. USAR FUNCIÓN
SELECT contarONGs('Salud');


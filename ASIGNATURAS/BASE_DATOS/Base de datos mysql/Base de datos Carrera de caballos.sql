create database casino;

use casino;

CREATE TABLE Usuarios (
    id_usuario INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    contraseña VARCHAR(255) NOT NULL
);


create table clientes(
	id_usuario INT PRIMARY KEY,
	saldo DECIMAL(10,2) DEFAULT 0 CHECK (saldo >= 0),
	FOREIGN KEY (id_usuario) REFERENCES Usuarios(id_usuario)
	ON DELETE CASCADE ON UPDATE CASCADE
);


CREATE TABLE Administradores (
    id_usuario INT PRIMARY KEY,
    nivel_acceso INT DEFAULT 1,
    FOREIGN KEY (id_usuario) REFERENCES Usuarios(id_usuario)
        ON DELETE CASCADE ON UPDATE CASCADE
);
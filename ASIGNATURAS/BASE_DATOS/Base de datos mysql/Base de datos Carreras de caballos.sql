create database casino;

use casino;

-- 1. TABLA PADRE
CREATE TABLE Usuarios (
    id_usuario INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    contraseña VARCHAR(255) NOT NULL
);

-- 2 y 3. TABLAS HIJAS (CLIENTES Y ADMINISTRADOR)
create table Clientes(
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
-- 4. CABALLOS
CREATE TABLE Caballos (
    id_caballo INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100),
    color VARCHAR(50),
    probabilidad INT
);

-- 4. TABLA CARRERAS
CREATE TABLE Carreras (
    id_carrera INT AUTO_INCREMENT PRIMARY KEY,
    fecha_hora DATETIME NOT NULL,
    estado ENUM("Pendiente", "En curso", "Finalizada") DEFAULT "Pendiente"
    );
    
-- 5. APUESTAS (Conecta directamente con Clientes, Caballos y Carreras)
CREATE TABLE Apuestas (
    id_apuesta INT AUTO_INCREMENT PRIMARY KEY,
    id_usuario INT,
    id_caballo INT,
    id_carrera INT,
    importe DECIMAL(10, 2) NOT NULL,
    resultado ENUM('Pendiente', 'Ganada', 'Perdida') DEFAULT 'Pendiente',
    FOREIGN KEY (id_usuario) REFERENCES Clientes(id_usuario),
    FOREIGN KEY (id_caballo) REFERENCES Caballos(id_caballo),
    FOREIGN KEY (id_carrera) REFERENCES Carreras(id_carrera)
		ON DELETE RESTRICT
        
    );

-- 6. TABLA: RESULTADOS     
CREATE TABLE Resultados (
    id_carrera INT PRIMARY KEY,
    id_ganador INT,
    FOREIGN KEY (id_carrera) REFERENCES Carreras(id_carrera),
    FOREIGN KEY (id_ganador) REFERENCES Caballos(id_caballo)
);
-- 7. MOVIMIENTOS
CREATE TABLE Movimientos (
    id_movimientos INT AUTO_INCREMENT PRIMARY KEY,
    id_usuario INT,
    id_apuesta INT NULL, -- Opcional: para saber qué apuesta generó el movimiento
    monto DECIMAL(10, 2) NOT NULL,
    fecha TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    tipo_movimiento ENUM('Ingreso', 'Apuesta', 'Premio', 'Retiro'),
    FOREIGN KEY (id_usuario) REFERENCES Usuarios(id_usuario),
    FOREIGN KEY (id_apuesta) REFERENCES Apuestas(id_apuesta)
		ON DELETE CASCADE
);




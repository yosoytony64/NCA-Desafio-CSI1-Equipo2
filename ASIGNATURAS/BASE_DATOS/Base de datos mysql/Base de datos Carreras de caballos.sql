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
    contraseña VARCHAR(255) NOT NULL
);

-- TABLA 2 CLIENTES(HERENCIA DE USUARIOS)
-- Especialización de Usuarios. Relación 1:1.
-- El id_usuario es PK y FK a la vez.
-- PK: Identificador único del cliente. 
-- FK: Conecta con Usuarios.id_usuario para obtener sus datos personales.
-- RELACIÓN: Si borras el usuario, el registro de cliente se elimina (CASCADE).
create table Clientes(
	id_usuario INT PRIMARY KEY,
	aura DECIMAL(10,2) DEFAULT 0 CHECK (aura >= 0),
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
    nivel_acceso INT DEFAULT 1,
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
    tipo_movimiento ENUM('Ingreso', 'Apuesta', 'Premio', 'Retiro'),
    FOREIGN KEY (id_usuario) REFERENCES Usuarios(id_usuario),
    FOREIGN KEY (id_apuesta) REFERENCES Apuestas(id_apuesta)
		ON DELETE CASCADE
);
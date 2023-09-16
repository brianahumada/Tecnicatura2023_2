use  estudiantes;
create TABLE Estudiantes (
    idEstudiante INT PRIMARY KEY,
    nombre VARCHAR(255),
    apellido VARCHAR(255),
    telefono VARCHAR(15),
    email VARCHAR(255)
);
-- Insertar 10 registros aleatorios en la tabla "Estudiantes"
INSERT INTO Estudiantes (idEstudiante, nombre, apellido, telefono, email)
VALUES
    (1, 'Juan', 'Perez', '555-1234', 'juan.perez@email.com'),
    (2, 'María', 'González', '555-5678', 'maria.gonzalez@email.com'),
    (3, 'Carlos', 'Martínez', '555-9876', 'carlos.martinez@email.com'),
    (4, 'Laura', 'Rodríguez', '555-4321', 'laura.rodriguez@email.com'),
    (5, 'Pedro', 'López', '555-8765', 'pedro.lopez@email.com'),
    (6, 'Ana', 'Sánchez', '555-2345', 'ana.sanchez@email.com'),
    (7, 'Javier', 'Díaz', '555-6789', 'javier.diaz@email.com'),
    (8, 'Marta', 'Fernández', '555-3456', 'marta.fernandez@email.com'),
    (9, 'Sergio', 'Ramírez', '555-7890', 'sergio.ramirez@email.com'),
    (10, 'Luis', 'Torres', '555-6543', 'luis.torres@email.com');

-- Mostrar todos los datos de la tabla "Estudiantes"
SELECT * FROM Estudiantes;
-- Agregar un nuevo registro a la tabla "Estudiantes"
INSERT INTO Estudiantes (idEstudiante, nombre, apellido, telefono, email)
VALUES (11, 'Elena', 'Gómez', '555-1234', 'elena.gomez@email.com');
-- Modificar el teléfono de un estudiante existente
UPDATE Estudiantes
SET telefono = '555-5555'
WHERE idEstudiante = 5;
-- Eliminar un estudiante de la tabla
DELETE FROM Estudiantes
WHERE idEstudiante = 8;

-- cambio el nombre de IdEstudiante a idestudiante`estudiantes`
USE estudiantes;

-- Primero, elimina la clave primaria existente si la hay
ALTER TABLE Estudiantes DROP PRIMARY KEY;

-- Luego, cambia el nombre de la columna idEstudiante a idestudiante
ALTER TABLE Estudiantes CHANGE idEstudiante idestudiante INT;

-- Finalmente, vuelve a establecer la columna idestudiante como clave primaria
ALTER TABLE Estudiantes ADD PRIMARY KEY (idestudiante);

-- cambiar el nombre de la tabla
ALTER TABLE estudiantes RENAME TO estudiante;





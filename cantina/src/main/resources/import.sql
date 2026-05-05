-- Insertar Alumnos
INSERT INTO alumno (nombre, curso, telefono) VALUES ('Juan Pérez', '1º DAM', '600111222');
INSERT INTO alumno (nombre, curso, telefono) VALUES ('María López', '2º DAW', '600333444');
INSERT INTO alumno (nombre, curso, telefono) VALUES ('Carlos Ruiz', '1º ASIR', '600555666');

-- Insertar Productos
INSERT INTO producto (nombre, precio, stock) VALUES ('Bocadillo de Jamón', 3.50, 15);
INSERT INTO producto (nombre, precio, stock) VALUES ('Café con leche', 1.20, 50);
INSERT INTO producto (nombre, precio, stock) VALUES ('Zumo de Naranja', 2.00, 5);
INSERT INTO producto (nombre, precio, stock) VALUES ('Donut de Chocolate', 1.50, 0); -- Sin stock para probar validación
-- Limpiar la tabla si existe
DELETE FROM usuarios;

-- Insertar el usuario admin con la contraseña 'admin123' (hash generado con BCrypt)
INSERT INTO usuarios (id, email, nombre, apellido, password, rol) 
VALUES (1, 'admin@vetra.com', 'Admin', 'Admin', '$2a$10$xIaPWXqgBSEyQ6Otl2hNPOQ.ij4dTT1CxFJ2kh1EmzEAtLpCnAacq', 'ADMIN'); 
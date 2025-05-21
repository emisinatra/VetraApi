-- Insertar un usuario de prueba (la contraseña es 'password123' encriptada con BCrypt)
INSERT INTO usuarios (email, nombre, password, rol)
VALUES ('admin@vetra.com', 'Admin', '$2a$10$GRLdNijSQMUvl/au9ofL.eDwmoohzzS7.rmNSJZ.0FxO/BTk76klW', 'ADMIN')
ON CONFLICT (email) DO NOTHING; 
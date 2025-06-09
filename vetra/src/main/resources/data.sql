-- Limpiar la tabla si existe
DELETE
FROM usuarios;

-- Insertar el usuario admin con la contraseña 'admin123' (hash generado con BCrypt)
INSERT INTO usuarios (id, email, nombre, apellido, password, rol)
VALUES (1, 'admin@vetra.com', 'Admin', 'Admin', '$2a$10$xIaPWXqgBSEyQ6Otl2hNPOQ.ij4dTT1CxFJ2kh1EmzEAtLpCnAacq',
        'ADMIN');

-- Insertar categorías (sintaxis compatible con H2)
INSERT INTO categorias (id, nombre)
VALUES (1, 'zapatillas'),
       (2, 'camperas'),
       (3, 'hombre'),
       (4, 'mujer'),
       (5, 'niño');

-- Insertar talles
INSERT INTO talles (id, talle)
VALUES (1, 'XS'),
       (2, 'S'),
       (3, 'M'),
       (4, 'L'),
       (5, 'XL'),
       (6, 'XXL'),
       (7, '26'),
       (8, '28'),
       (9, '30'),
       (10, '32'),
       (11, '34'),
       (12, '36'),
       (13, '38'),
       (14, '40'),
       (15, '42'),
       (16, '44'),
       (17, '46');

-- Insertar descuentos
INSERT INTO descuentos (id, fecha_inicio, fecha_cierre, porcentaje)
VALUES (1, '2023-11-01', '2025-11-30', 15.0),
       (2, '2023-12-01', '2025-12-31', 20.0),
       (3, '2023-10-01', '2025-10-31', 10.0),
       (4, '2023-01-01', '2026-12-31', 0.0);

-- Insertar direcciones
INSERT INTO domicilios (id, calle, codpost)
VALUES (1, 'Av. Corrientes 1234', 1043),
       (2, 'Calle Florida 567', 1005),
       (3, 'Av. Santa Fe 789', 1012);

-- Insertar clientes
INSERT INTO usuarios (id, email, password, nombre, apellido, rol)
VALUES (2, 'cliente1@mail.com', '$2a$10$xyz123', 'Juan', 'Pérez', 'USUARIO'),
       (3, 'cliente2@mail.com', '$2a$10$abc456', 'María', 'Gómez', 'USUARIO'),
       (4, 'cliente3@mail.com', '$2a$10$def789', 'Carlos', 'López', 'USUARIO');


-- Relacionar usuarios con direcciones
INSERT INTO usuarios_direcciones (usuario_id, direccion_id)
VALUES (2, 1),
       (3, 2),
       (4, 3);

-- Insertar zapatillas (20 modelos)
INSERT INTO productos (id, nombre, descripcion, precio, stock, color, marca, imagen, descuento_id)
VALUES (1, 'Runner Velocity 4.0', 'Zapatillas running con amortiguación AirMax', 25990, 50, 'Negro', 'SportMax', '', 1),
       (2, 'Urban Flex', 'Zapatillas urbanas unisex', 18990, 35, 'Blanco', 'UrbanWalk', '', 4),
       (3, 'Trail Blazer', 'Zapatillas para trail running', 27990, 20, 'Azul', 'OutdoorPro', '', 4),
       (4, 'Cloud Cushion', 'Zapatillas con máxima amortiguación', 22990, 40, 'Gris', 'SkyStep', '', 1),
       (5, 'Speed Lite', 'Zapatillas ligeras para velocidad', 20990, 30, 'Rojo', 'FastTrack', '', 4),
       (6, 'All Day Comfort', 'Zapatillas para uso diario', 17990, 60, 'Negro', 'DailyWalk', '', 4),
       (7, 'Winter Grip', 'Zapatillas con suela antideslizante', 23990, 25, 'Azul Marino', 'SeasonGear', '', 4),
       (8, 'Air Spring', 'Zapatillas con tecnología de rebote', 24990, 15, 'Blanco/Rojo', 'JumpHigh', '', 2),
       (9, 'Eco Walk', 'Zapatillas fabricadas con materiales reciclados', 19990, 45, 'Verde', 'NatureStep', '', 4),
       (10, 'Pro Trainer', 'Zapatillas para entrenamiento profesional', 26990, 18, 'Negro/Amarillo', 'FitPro', '', 4),
       (11, 'Street Style', 'Zapatillas urbanas de moda', 21990, 32, 'Blanco/Negro', 'UrbanChic', '', 1),
       (12, 'Kids Runner', 'Zapatillas para niños resistentes', 15990, 28, 'Azul/Rojo', 'LittleFeet', '', 4),
       (13, 'Gym Flex', 'Zapatillas para gimnasio', 18990, 22, 'Negro/Gris', 'PowerGym', '', 4),
       (14, 'Trail Expert', 'Zapatillas para senderismo técnico', 29990, 12, 'Marrón', 'MountainGo', '', 2),
       (15, 'City Walker', 'Zapatillas cómodas para caminar', 16990, 38, 'Gris', 'UrbanLife', '', 4),
       (16, 'Bounce Pro', 'Zapatillas con máxima elasticidad', 23990, 17, 'Amarillo', 'EnergyStep', '', 4),
       (17, 'Summer Breeze', 'Zapatillas transpirables para verano', 19990, 29, 'Blanco', 'FreshAir', '', 1),
       (18, 'Night Glow', 'Zapatillas con detalles reflectantes', 22990, 14, 'Negro/Plateado', 'SafeNight', '', 4),
       (19, 'Ultra Light', 'Zapatillas ultraligeras', 20990, 19, 'Azul', 'FeatherStep', '', 4),
       (20, 'Classic Retro', 'Zapatillas estilo retro', 18990, 26, 'Blanco/Rojo', 'VintageStep', '', 4);


-- Camperas con MERGE INTO para H2 (tabla 'productos')
INSERT INTO productos (id, nombre, descripcion, precio, stock, color, marca, imagen, descuento_id)
VALUES (21, 'Winter Shield Pro', 'Campera impermeable con capucha desmontable', 45990, 18, 'Negro', 'OutdoorPro', '',
        1),
       (22, 'Urban Jacket Slim', 'Campera urbana ajustada con múltiples bolsillos', 32990, 25, 'Azul Marino',
        'CityStyle', '', 4),
       (23, 'Puffer Lite 2.0', 'Campera acolchada ultraligera para invierno', 38990, 15, 'Gris Antracita',
        'WinterComfort', '', 2),
       (24, 'Wind Breaker XT', 'Rompevientos deportivo con tecnología antiviento', 27990, 22, 'Rojo Ferrari',
        'SportMax', '', 4),
       (25, 'Denim Classic', 'Campera de jean con detalles en cuero', 34990, 20, 'Azul Indigo', 'UrbanChic', '', 4),
       (26, 'Arctic Parka', 'Parka térmica para -20°C con forro polar', 51990, 10, 'Verde Militar', 'PolarGear', '', 1),
       (27, 'Bomber Vintage', 'Campera bomber en cuero sintético', 36990, 16, 'Negro Mate', 'VintageWear', '', 4),
       (28, 'Storm Defender', 'Campera 100% impermeable con costuras selladas', 41990, 14, 'Amarillo Fluorescente',
        'WeatherShield', '', 4),
       (29, 'Fleece Mountain', 'Campera polar de alta densidad para montaña', 29990, 28, 'Gris Carbón', 'CozyWear', '',
        4),
       (30, 'Tech Softshell', 'Campera técnica con membrana transpirable', 44990, 12, 'Azul Noche', 'TechGear', '', 2),
       (31, 'Kids Snow', 'Campera infantil impermeable con capucha', 37990, 19, 'Rojo Brillante', 'LittleComfort', '',
        4),
       (32, 'Hoodie Street', 'Campera con capucha y bolsillo canguro', 31990, 24, 'Negro Basáltico', 'StreetStyle', '',
        1),
       (33, 'Packable Travel', 'Campera ultraligera que cabe en su bolsillo', 26990, 30, 'Verde Oliva', 'TravelLight',
        '', 4),
       (34, 'Thermal Extreme', 'Campera con tecnología de calefacción activa', 48990, 11, 'Negro Profundo',
        'ExtremeWarm', '', 4),
       (35, 'Blazer Executive', 'Campera estilo blazer para oficina', 35990, 17, 'Azul Marino', 'ElegantWear', '', 4),
       (36, 'Track Sport', 'Campera deportiva con rayas reflectantes', 33990, 21, 'Blanco/Negro', 'ActiveStyle', '', 4),
       (37, 'Alpine Shell', 'Campera para alta montaña con protección UV', 49990, 9, 'Naranja Salvaje', 'SummitGear',
        '', 1),
       (38, 'Vest Urban', 'Chaleco multifunción con 10 bolsillos', 28990, 23, 'Gris Plata', 'CityVibe', '', 4),
       (39, 'Eco Recycled', 'Campera hecha con botellas plásticas recicladas', 39990, 13, 'Verde Bosque', 'NatureWear',
        '', 4),
       (40, 'Leather Premium', 'Campera estilo cuero con forro de lana', 54990, 8, 'Marrón Café', 'ClassicLook', '', 2);


-- Relacionar productos con categorías
INSERT INTO producto_categorias (producto_id, categoria_id)
VALUES (1, 1),
       (1, 3),
       (2, 1),
       (2, 4),
       (3, 2),
       (3, 4),
       (5, 5),
       (5, 1),
       (10, 1),
       (10, 3),
       (15, 2),
       (15, 4),
       (31, 5),
       (32, 3),
       (32, 4),
       (34, 1),
       (34, 3),
       (35, 1),
       (36, 2),
       (37, 3),
       (39, 4);


-- Relacionar productos con talles
INSERT INTO producto_talle (producto_id, talle_id)
VALUES (1, 7),
       (1, 8),
       (2, 9),
       (2, 10),
       (3, 8),
       (3, 9),
       (4, 10),
       (4, 11),
       (5, 7),
       (5, 8),
       (6, 7),
       (6, 8),
       (7, 9),
       (7, 10),
       (8, 7),
       (8, 8),
       (9, 9),
       (9, 10),
       (10, 11),
       (10, 12),
       (11, 7),
       (11, 8),
       (12, 13),
       (12, 14),
       (13, 7),
       (13, 8),
       (14, 9),
       (14, 10),
       (15, 7),
       (15, 8),
       (16, 9),
       (16, 10),
       (17, 7),
       (17, 8),
       (18, 9),
       (18, 10),
       (19, 7),
       (19, 8),
       (20, 9),
       (20, 10),
       (21, 1),
       (21, 2),
       (22, 3),
       (22, 4),
       (23, 5),
       (23, 6),
       (24, 1),
       (24, 2),
       (25, 3),
       (25, 4),
       (26, 5),
       (26, 6),
       (27, 1),
       (27, 2),
       (28, 3),
       (28, 4),
       (29, 5),
       (29, 6),
       (30, 7),
       (30, 8),
       (31, 9),
       (31, 10),
       (32, 11),
       (32, 12),
       (33, 13),
       (33, 14),
       (34, 15),
       (34, 16),
       (35, 1),
       (35, 2),
       (36, 3),
       (36, 4),
       (37, 5),
       (37, 6),
       (38, 7),
       (38, 8),
       (39, 9),
       (39, 10),
       (40, 11),
       (40, 12);

-- Insertar pedidos de ejemplo
INSERT INTO pedidos (id, usuario_id, estado, fecha_creacion)
VALUES (1, 2, 'APROBADO', '2023-10-15 10:30:00'),
       (2, 3, 'ENPROCESO', '2023-10-16 14:45:00'),
       (3, 4, 'PENDIENTE', '2023-10-17 09:15:00');


-- Insertar items de pedido
INSERT INTO pedido_items (cantidad, id, pedido_id, producto_id)
VALUES (1, 1, 1, 2),
       (1, 2, 1, 21),
       (1, 3, 2, 5),
       (1, 4, 2, 25),
       (1, 5, 3, 12),
       (1, 6, 3, 31);


-- Insertar órdenes de compra
INSERT INTO ordenes_compra (id, pedido_id, fecha_orden, monto_total, medio_pago)
VALUES (1, 1, '2023-10-15 10:35:00', 97990, 'MERCADOPAGO'),
       (2, 2, '2023-10-16 14:50:00', 58990, 'TARJETA_CREDITO'),
       (3, 3, '2023-10-17 09:20:00', 53990, 'TRANSFERENCIA');


-- Insertar detalles de orden
INSERT INTO detalle_ordenes (id, orden_compra_id, producto_id, cantidad, precio_unitario)
VALUES (1, 1, 1, 2, 25990),
       (2, 1, 21, 1, 45990),
       (3, 2, 5, 1, 20990),
       (4, 2, 25, 1, 34990),
       (5, 3, 12, 1, 15990),
       (6, 3, 31, 1, 37990);

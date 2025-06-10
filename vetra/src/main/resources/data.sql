-- Limpiar la tabla si existe
DELETE
FROM usuarios;

-- Insertar el usuario admin con la contraseña 'admin123' (hash generado con BCrypt)
INSERT INTO usuarios (email, nombre, apellido, password, rol)
VALUES ( 'admin@vetra.com', 'Admin', 'Admin', '$2a$10$xIaPWXqgBSEyQ6Otl2hNPOQ.ij4dTT1CxFJ2kh1EmzEAtLpCnAacq',
        'ADMIN');

-- Insertar categorías (sintaxis compatible con H2)
INSERT INTO categorias (id, nombre)
VALUES (1, 'Zapatillas'),
       (2, 'Camperas'),
       (3, 'Hombre'),
       (4, 'Mujer'),
       (5, 'Chicos');

-- Insertar talles
INSERT INTO talles (talle)
VALUES ('XS'),
       ('S'),
       ('M'),
       ('L'),
       ('XL'),
       ('XXL'),
       ('26'),
       ('28'),
       ('30'),
       ('32'),
       ('34'),
       ('36'),
       ('38'),
       ('40'),
       ('42'),
       ('44'),
       ('46');

-- Insertar descuentos
INSERT INTO descuentos (fecha_inicio, fecha_cierre, porcentaje)
VALUES ( '2023-11-01', '2025-11-30', 0.0),
       ( '2023-12-01', '2025-12-31', 20.0),
       ( '2023-10-01', '2025-10-31', 35.0),
       ( '2023-01-01', '2026-12-31', 15.0);

-- Insertar direcciones
INSERT INTO domicilios (calle, codpost)
VALUES ( 'Av. San Martín 770', 5500),
       ( 'Cervantes 400', 5501),
       ( 'Godoy Cruz 1212', 5518);

-- Insertar clientes
INSERT INTO usuarios (email, password, nombre, apellido, rol)
VALUES ( 'cliente1@mail.com', '$2a$10$xyz123', 'Juan', 'Pérez', 'USUARIO'),
       ( 'cliente2@mail.com', '$2a$10$abc456', 'María', 'Gómez', 'USUARIO'),
       ( 'cliente3@mail.com', '$2a$10$def789', 'Carlos', 'López', 'USUARIO');


-- Relacionar usuarios con direcciones
INSERT INTO usuarios_direcciones (usuario_id, direccion_id)
VALUES (2, 1),
       (3, 2),
       (4, 3);

-- Insertar zapatillas (20 modelos)
INSERT INTO productos (nombre, descripcion, precio, stock, color, marca, imagen, descuento_id)
VALUES ( 'Runner Velocity 4.0', 'Zapatillas running con amortiguación AirMax', 160000, 50, 'Negro', 'SportMax',
        'https://res.cloudinary.com/danzaburou/image/upload/v1749471216/zap1_exgvwl.png', 4),
       ( 'Urban Flex', 'Zapatillas urbanas unisex', 150000, 35, 'Blanco', 'UrbanWalk',
        'https://res.cloudinary.com/danzaburou/image/upload/v1749471215/zap2_dahzj1.jpg', 1),
       ( 'Trail Blazer', 'Zapatillas para trail running', 135000, 20, 'Azul', 'OutdoorPro',
        'https://res.cloudinary.com/danzaburou/image/upload/v1749471214/zap3_v6f8b8.jpg', 1),
       ( 'Cloud Cushion', 'Zapatillas con máxima amortiguación', 150000, 40, 'Gris', 'SkyStep',
        'https://res.cloudinary.com/danzaburou/image/upload/v1749471214/zap4_d3ohmy.jpg', 4),
       ( 'Speed Lite', 'Zapatillas ligeras para velocidad', 130000, 30, 'Rojo', 'FastTrack',
        'https://res.cloudinary.com/danzaburou/image/upload/v1749471215/zap5_lxpiit.png', 1),
       ( 'All Day Comfort', 'Zapatillas para uso diario', 120000, 60, 'Negro', 'DailyWalk',
        'https://res.cloudinary.com/danzaburou/image/upload/v1749471215/zap6_crshsb.png', 1),
       ( 'Winter Grip', 'Zapatillas con suela antideslizante', 125000, 25, 'Azul Marino', 'SeasonGear',
        'https://res.cloudinary.com/danzaburou/image/upload/v1749471215/zap7_vby6hd.png', 1),
       ( 'Air Spring', 'Zapatillas con tecnología de rebote', 135000, 15, 'Blanco/Rojo', 'JumpHigh',
        'https://res.cloudinary.com/danzaburou/image/upload/v1749471215/zap8_epsqkp.jpg', 3),
       ( 'Eco Walk', 'Zapatillas fabricadas con materiales reciclados', 100000, 45, 'Verde', 'NatureStep',
        'https://res.cloudinary.com/danzaburou/image/upload/v1749471216/zap9_d36p5x.png', 1),
       ( 'Pro Trainer', 'Zapatillas para entrenamiento profesional', 170000, 18, 'Negro/Amarillo', 'FitPro',
        'https://res.cloudinary.com/danzaburou/image/upload/v1749471215/zap10_lhbqwy.png', 1),
       ( 'Street Style', 'Zapatillas urbanas de moda', 120000, 32, 'Blanco/Negro', 'UrbanChic',
        'https://res.cloudinary.com/danzaburou/image/upload/v1749471216/zap1_exgvwl.png', 4),
       ( 'Kids Runner', 'Zapatillas para niños resistentes', 90000, 28, 'Azul/Rojo', 'LittleFeet',
        'https://res.cloudinary.com/danzaburou/image/upload/v1749471215/zap2_dahzj1.jpg', 1),
       ( 'Gym Flex', 'Zapatillas para gimnasio', 18990, 22, 'Negro/Gris', 'PowerGym',
        'https://res.cloudinary.com/danzaburou/image/upload/v1749471214/zap3_v6f8b8.jpg', 1),
       ( 'Trail Expert', 'Zapatillas para senderismo técnico', 29990, 12, 'Marrón', 'MountainGo',
        'https://res.cloudinary.com/danzaburou/image/upload/v1749471214/zap4_d3ohmy.jpg', 2),
       ( 'City Walker', 'Zapatillas cómodas para caminar', 16990, 38, 'Gris', 'UrbanLife',
        'https://res.cloudinary.com/danzaburou/image/upload/v1749471215/zap5_lxpiit.png', 1),
       ( 'Bounce Pro', 'Zapatillas con máxima elasticidad', 23990, 17, 'Amarillo', 'EnergyStep',
        'https://res.cloudinary.com/danzaburou/image/upload/v1749471215/zap6_crshsb.png', 1),
       ( 'Summer Breeze', 'Zapatillas transpirables para verano', 19990, 29, 'Blanco', 'FreshAir',
        'https://res.cloudinary.com/danzaburou/image/upload/v1749471215/zap7_vby6hd.png', 4),
       ( 'Night Glow', 'Zapatillas con detalles reflectantes', 22990, 14, 'Negro/Plateado', 'SafeNight',
        'https://res.cloudinary.com/danzaburou/image/upload/v1749471215/zap8_epsqkp.jpg', 1),
       ( 'Ultra Light', 'Zapatillas ultraligeras', 20990, 19, 'Azul', 'FeatherStep',
        'https://res.cloudinary.com/danzaburou/image/upload/v1749471216/zap9_d36p5x.png', 1),
       ( 'Classic Retro', 'Zapatillas estilo retro', 18990, 26, 'Blanco/Rojo', 'VintageStep',
        'https://res.cloudinary.com/danzaburou/image/upload/v1749471215/zap10_lhbqwy.png', 1);


-- Insertar camperas (20 modelos tambien)
INSERT INTO productos (nombre, descripcion, precio, stock, color, marca, imagen, descuento_id)
VALUES ( 'Winter Shield Pro', 'Campera impermeable con capucha desmontable', 45990, 18, 'Negro', 'OutdoorPro',
        'https://res.cloudinary.com/danzaburou/image/upload/v1749473424/camp01_tkpafe.jpg',
        4),
       ( 'Urban Jacket Slim', 'Campera urbana ajustada con múltiples bolsillos', 32990, 25, 'Azul Marino',
        'CityStyle', 'https://res.cloudinary.com/danzaburou/image/upload/v1749473424/camp02_pctaun.jpg', 1),
       ( 'Puffer Lite 2.0', 'Campera acolchada ultraligera para invierno', 38990, 15, 'Gris Antracita',
        'WinterComfort', 'https://res.cloudinary.com/danzaburou/image/upload/v1749473424/camp03_eo659i.jpg', 2),
       ( 'Wind Breaker XT', 'Rompevientos deportivo con tecnología antiviento', 27990, 22, 'Rojo Ferrari',
        'SportMax', 'https://res.cloudinary.com/danzaburou/image/upload/v1749473423/camp04_zjgolv.png', 1),
       ( 'Denim Classic', 'Campera de jean con detalles en cuero', 34990, 20, 'Azul Indigo', 'UrbanChic',
        'https://res.cloudinary.com/danzaburou/image/upload/v1749473540/camp05_uuc50s.jpg', 3),
       ( 'Arctic Parka', 'Parka térmica para -20°C con forro polar', 51990, 10, 'Verde Militar', 'PolarGear',
        'https://res.cloudinary.com/danzaburou/image/upload/v1749473423/camp06_myzzyu.jpg', 4),
       ( 'Bomber Vintage', 'Campera bomber en cuero sintético', 36990, 16, 'Negro Mate', 'VintageWear',
        'https://res.cloudinary.com/danzaburou/image/upload/v1749473424/camp07_r6h9kc.png', 1),
       ( 'Storm Defender', 'Campera 100% impermeable con costuras selladas', 41990, 14, 'Amarillo Fluorescente',
        'WeatherShield', 'https://res.cloudinary.com/danzaburou/image/upload/v1749473423/camp08_qddv6y.jpg', 1),
       ( 'Fleece Mountain', 'Campera polar de alta densidad para montaña', 29990, 28, 'Gris Carbón', 'CozyWear',
        'https://res.cloudinary.com/danzaburou/image/upload/v1749473423/camp09_hct9hm.jpg',
        1),
       ( 'Tech Softshell', 'Campera técnica con membrana transpirable', 44990, 12, 'Azul Noche', 'TechGear',
        'https://res.cloudinary.com/danzaburou/image/upload/v1749473423/camp10_ibtsaq.jpg', 2),
       ( 'Kids Snow', 'Campera infantil impermeable con capucha', 37990, 19, 'Rojo Brillante', 'LittleComfort',
        'https://res.cloudinary.com/danzaburou/image/upload/v1749473424/camp01_tkpafe.jpg',
        1),
       ( 'Hoodie Street', 'Campera con capucha y bolsillo canguro', 31990, 24, 'Negro Basáltico', 'StreetStyle',
        'https://res.cloudinary.com/danzaburou/image/upload/v1749473424/camp02_pctaun.jpg',
        4),
       ( 'Packable Travel', 'Campera ultraligera que cabe en su bolsillo', 26990, 30, 'Verde Oliva', 'TravelLight',
        'https://res.cloudinary.com/danzaburou/image/upload/v1749473424/camp03_eo659i.jpg', 1),
       ( 'Thermal Extreme', 'Campera con tecnología de calefacción activa', 48990, 11, 'Negro Profundo',
        'ExtremeWarm', 'https://res.cloudinary.com/danzaburou/image/upload/v1749473423/camp04_zjgolv.png', 1),
       ( 'Blazer Executive', 'Campera estilo blazer para oficina', 35990, 17, 'Azul Marino', 'ElegantWear',
        'https://res.cloudinary.com/danzaburou/image/upload/v1749473540/camp05_uuc50s.jpg', 1),
       ( 'Track Sport', 'Campera deportiva con rayas reflectantes', 33990, 21, 'Blanco/Negro', 'ActiveStyle',
        'https://res.cloudinary.com/danzaburou/image/upload/v1749473423/camp06_myzzyu.jpg', 1),
       ( 'Alpine Shell', 'Campera para alta montaña con protección UV', 49990, 9, 'Naranja Salvaje', 'SummitGear',
        'https://res.cloudinary.com/danzaburou/image/upload/v1749473424/camp07_r6h9kc.png', 4),
       ( 'Vest Urban', 'Chaleco multifunción con 10 bolsillos', 28990, 23, 'Gris Plata', 'CityVibe',
        'https://res.cloudinary.com/danzaburou/image/upload/v1749473423/camp08_qddv6y.jpg', 1),
       ( 'Eco Recycled', 'Campera hecha con botellas plásticas recicladas', 39990, 13, 'Verde Bosque', 'NatureWear',
        'https://res.cloudinary.com/danzaburou/image/upload/v1749473423/camp09_hct9hm.jpg', 1),
       ( 'Leather Premium', 'Campera estilo cuero con forro de lana', 54990, 8, 'Marrón Café', 'ClassicLook',
        'https://res.cloudinary.com/danzaburou/image/upload/v1749473423/camp10_ibtsaq.jpg', 2);


-- Relacionar productos con categorías
INSERT INTO producto_categorias (producto_id, categoria_id)
VALUES
-- Zapatillas (1 al 20)
(1, 1), (1, 3),
(2, 1), (2, 4),
(3, 1), (3, 3), (3, 4),
(4, 1), (4, 5),
(5, 1), (5, 3),
(6, 1), (6, 4),
(7, 1), (7, 5),
(8, 1), (8, 3), (8, 4),
(9, 1), (9, 3),
(10, 1), (10, 4),
(11, 1), (11, 5),
(12, 1), (12, 3), (12, 4),
(13, 1), (13, 4),
(14, 1), (14, 3),
(15, 1), (15, 3), (15, 5),
(16, 1), (16, 4),
(17, 1), (17, 3),
(18, 1), (18, 5),
(19, 1), (19, 4),
(20, 1), (20, 3), (20, 4),

-- Camperas (21 al 40)
(21, 2), (21, 3),
(22, 2), (22, 4),
(23, 2), (23, 5),
(24, 2), (24, 3), (24, 4),
(25, 2), (25, 3),
(26, 2), (26, 4),
(27, 2), (27, 5),
(28, 2), (28, 3),
(29, 2), (29, 4), (29, 5),
(30, 2), (30, 3),
(31, 2), (31, 5),
(32, 2), (32, 3), (32, 4),
(33, 2), (33, 4),
(34, 2), (34, 3),
(35, 2), (35, 5),
(36, 2), (36, 3), (36, 4),
(37, 2), (37, 3),
(38, 2), (38, 4),
(39, 2), (39, 5),
(40, 2), (40, 3), (40, 4);



-- Relacionar productos con talles
INSERT INTO producto_talle (producto_id, talle_id)
VALUES
-- Productos 1 al 20 → talle_id 7 al 17
(1, 7), (1, 8), (1, 9), (1, 10), (1, 11),
(2, 7), (2, 8), (2, 9),
(3, 10), (3, 11), (3, 12), (3, 13),
(4, 7), (4, 8), (4, 9), (4, 10), (4, 11), (4, 12),
(5, 13), (5, 14), (5, 15),
(6, 8), (6, 9), (6, 10), (6, 11),
(7, 7), (7, 8), (7, 9),
(8, 10), (8, 11), (8, 12), (8, 13), (8, 14),
(9, 9), (9, 10),
(10, 11), (10, 12), (10, 13),
(11, 14), (11, 15), (11, 16), (11, 17),
(12, 7), (12, 8), (12, 9), (12, 10), (12, 11),
(13, 13), (13, 14),
(14, 15), (14, 16),
(15, 7), (15, 8), (15, 9),
(16, 10), (16, 11), (16, 12),
(17, 13), (17, 14), (17, 15), (17, 16),
(18, 11), (18, 12),
(19, 7), (19, 8), (19, 9), (19, 10),
(20, 15), (20, 16), (20, 17),

-- Productos 21 al 40 → talle_id 1 al 6
(21, 1), (21, 2), (21, 3),
(22, 2), (22, 3), (22, 4), (22, 5),
(23, 4), (23, 5),
(24, 1), (24, 2), (24, 3), (24, 4),
(25, 1), (25, 2),
(26, 3), (26, 4), (26, 5), (26, 6),
(27, 1), (27, 2), (27, 3),
(28, 4), (28, 5),
(29, 6),
(30, 1), (30, 2), (30, 3), (30, 4), (30, 5),
(31, 2), (31, 3), (31, 4),
(32, 5), (32, 6),
(33, 1), (33, 2), (33, 3),
(34, 4), (34, 5), (34, 6),
(35, 1), (35, 2),
(36, 3), (36, 4), (36, 5),
(37, 6),
(38, 1), (38, 2), (38, 3), (38, 4),
(39, 5), (39, 6),
(40, 1), (40, 2), (40, 3), (40, 4), (40, 5), (40, 6);


-- Insertar pedidos de ejemplo
INSERT INTO pedidos (usuario_id, estado, fecha_creacion)
VALUES ( 2, 'APROBADO', '2023-10-15 10:30:00'),
       ( 3, 'ENPROCESO', '2023-10-16 14:45:00'),
       ( 4, 'PENDIENTE', '2023-10-17 09:15:00');


-- Insertar items de pedido
INSERT INTO pedido_items (cantidad, pedido_id, producto_id)
VALUES (1,  1, 2),
       (1,  1, 21),
       (1,  2, 5),
       (1,  2, 25),
       (1,  3, 12),
       (1,  3, 31);


-- Insertar órdenes de compra
INSERT INTO ordenes_compra (pedido_id, fecha_orden, monto_total, medio_pago)
VALUES ( 1, '2023-10-15 10:35:00', 97990, 'MERCADOPAGO'),
       ( 2, '2023-10-16 14:50:00', 58990, 'TARJETA_CREDITO'),
       ( 3, '2023-10-17 09:20:00', 53990, 'TRANSFERENCIA');


-- Insertar detalles de orden
INSERT INTO detalle_ordenes (orden_compra_id, producto_id, cantidad, precio_unitario)
VALUES ( 1, 1, 2, 25990),
       ( 1, 21, 1, 45990),
       ( 2, 5, 1, 20990),
       ( 2, 25, 1, 34990),
       ( 3, 12, 1, 15990),
       ( 3, 31, 1, 37990);

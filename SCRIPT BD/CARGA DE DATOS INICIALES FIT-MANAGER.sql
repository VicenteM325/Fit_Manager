-- CARGA DE DATOS INICIALES FIT-MANAGER
SET search_path = fitmanager, public;

CREATE EXTENSION IF NOT EXISTS pgcrypto;


-- CARGA DE ROLES --
INSERT INTO rol (nombre) VALUES 
('Administrador'),
('Recepcionista'),
('Entrenador'),
('Inventario')
ON CONFLICT DO NOTHING;

-- SUCURSALES --
INSERT INTO sucursal (nombre, ubicacion, capacidad_maquinas) VALUES
('Sucursal Central', 'Zona 1, Quetzaltenango', 50),
('Sucursal Norte', 'Zona 3, Quetzaltenango', 30),
('Sucursal Sur', 'Zona 5, Quetzaltenango', 20),
('Bodega Central', 'Zona 7, Quetzaltenango', 50)
ON CONFLICT DO NOTHING;

-- USUARIO ADMINISTRADOR --
INSERT INTO empleado (nombre, apellido, telefono, id_rol, usuario_login, contrasena, id_sucursal)
VALUES ('Vicente', 'Matias', '+502 40270651',
        (SELECT id_rol FROM rol WHERE nombre='Administrador'),
        'vicente', crypt('vicente123', gen_salt('bf')), NULL);

-- EMPLEADOS SUCURSAL CENTRAL --

-- 3 RECEPCIONISTAS --
INSERT INTO rol (nombre) VALUES ('Recepcionista') ON CONFLICT DO NOTHING;
INSERT INTO empleado (nombre, apellido, telefono, id_rol, usuario_login, contrasena, id_sucursal)
VALUES ('Luis', 'Garcia', '+502 46552685',
        (SELECT id_rol FROM rol WHERE nombre='Recepcionista'),
        'luis', crypt('luis123', gen_salt('bf')), 1);

INSERT INTO empleado (nombre, apellido, telefono, id_rol, usuario_login, contrasena, id_sucursal)
VALUES ('Ana', 'Hernández', '+502 55478963',
        (SELECT id_rol FROM rol WHERE nombre='Recepcionista'),
        'ana', crypt('ana123', gen_salt('bf')), 1);

INSERT INTO empleado (nombre, apellido, telefono, id_rol, usuario_login, contrasena, id_sucursal)
VALUES ('Jorge', 'Mendoza', '+502 59784512',
        (SELECT id_rol FROM rol WHERE nombre='Recepcionista'),
        'jorge', crypt('jorge123', gen_salt('bf')), 1);

-- 5 INVENTARIOS --
INSERT INTO rol (nombre) VALUES ('Inventario') ON CONFLICT DO NOTHING;
INSERT INTO empleado (nombre, apellido, telefono, id_rol, usuario_login, contrasena, id_sucursal)
VALUES ('Rocael', 'Osorio', '+502 46565646',
        (SELECT id_rol FROM rol WHERE nombre='Inventario'),
        'rocael', crypt('rocael123', gen_salt('bf')), 1);

INSERT INTO empleado (nombre, apellido, telefono, id_rol, usuario_login, contrasena, id_sucursal)
VALUES ('Pedro', 'Castillo', '+502 55647895',
        (SELECT id_rol FROM rol WHERE nombre='Inventario'),
        'pedro', crypt('pedro123', gen_salt('bf')), 1);

INSERT INTO empleado (nombre, apellido, telefono, id_rol, usuario_login, contrasena, id_sucursal)
VALUES ('Lucía', 'Martínez', '+502 58741236',
        (SELECT id_rol FROM rol WHERE nombre='Inventario'),
        'lucia', crypt('lucia123', gen_salt('bf')), 1);

INSERT INTO empleado (nombre, apellido, telefono, id_rol, usuario_login, contrasena, id_sucursal)
VALUES ('Diego', 'Alvarado', '+502 53426781',
        (SELECT id_rol FROM rol WHERE nombre='Inventario'),
        'diego', crypt('diego123', gen_salt('bf')), 1);

INSERT INTO empleado (nombre, apellido, telefono, id_rol, usuario_login, contrasena, id_sucursal)
VALUES ('Sofía', 'Morales', '+502 54896327',
        (SELECT id_rol FROM rol WHERE nombre='Inventario'),
        'sofia', crypt('sofia123', gen_salt('bf')), 1);

-- 25 ENTRENADORES --
INSERT INTO rol (nombre) VALUES ('Entrenador') ON CONFLICT DO NOTHING;
INSERT INTO empleado (nombre, apellido, telefono, id_rol, usuario_login, contrasena, id_sucursal)
VALUES ('Alberto', 'Zacarias', '+502 47565646',
        (SELECT id_rol FROM rol WHERE nombre='Entrenador'),
        'alberto', crypt('alberto123', gen_salt('bf')), 1);
        
INSERT INTO empleado (nombre, apellido, telefono, id_rol, usuario_login, contrasena, id_sucursal)
VALUES 
('Luis', 'Pérez', '+502 50123401', (SELECT id_rol FROM rol WHERE nombre='Entrenador'), 'luis1', crypt('luis123', gen_salt('bf')), 1),
('María', 'González', '+502 50123402', (SELECT id_rol FROM rol WHERE nombre='Entrenador'), 'maria1', crypt('maria123', gen_salt('bf')), 1),
('Carlos', 'Ramírez', '+502 50123403', (SELECT id_rol FROM rol WHERE nombre='Entrenador'), 'carlos1', crypt('carlos123', gen_salt('bf')), 1),
('Ana', 'Hernández', '+502 50123404', (SELECT id_rol FROM rol WHERE nombre='Entrenador'), 'ana1', crypt('ana123', gen_salt('bf')), 1),
('Jorge', 'Mendoza', '+502 50123405', (SELECT id_rol FROM rol WHERE nombre='Entrenador'), 'jorge1', crypt('jorge123', gen_salt('bf')), 1),
('Claudia', 'Ruiz', '+502 50123406', (SELECT id_rol FROM rol WHERE nombre='Entrenador'), 'claudia1', crypt('claudia123', gen_salt('bf')), 1),
('Fernando', 'López', '+502 50123407', (SELECT id_rol FROM rol WHERE nombre='Entrenador'), 'fernando1', crypt('fernando123', gen_salt('bf')), 1),
('Patricia', 'Santos', '+502 50123408', (SELECT id_rol FROM rol WHERE nombre='Entrenador'), 'patricia1', crypt('patricia123', gen_salt('bf')), 1),
('Ricardo', 'García', '+502 50123409', (SELECT id_rol FROM rol WHERE nombre='Entrenador'), 'ricardo1', crypt('ricardo123', gen_salt('bf')), 1),
('Gabriela', 'Morales', '+502 50123410', (SELECT id_rol FROM rol WHERE nombre='Entrenador'), 'gabriela1', crypt('gabriela123', gen_salt('bf')), 1),
('Andrés', 'Castillo', '+502 50123411', (SELECT id_rol FROM rol WHERE nombre='Entrenador'), 'andres1', crypt('andres123', gen_salt('bf')), 1),
('Sofía', 'Ortiz', '+502 50123412', (SELECT id_rol FROM rol WHERE nombre='Entrenador'), 'sofia1', crypt('sofia123', gen_salt('bf')), 1),
('Héctor', 'Reyes', '+502 50123413', (SELECT id_rol FROM rol WHERE nombre='Entrenador'), 'hector1', crypt('hector123', gen_salt('bf')), 1),
('Diana', 'Luna', '+502 50123414', (SELECT id_rol FROM rol WHERE nombre='Entrenador'), 'diana1', crypt('diana123', gen_salt('bf')), 1),
('Manuel', 'Cano', '+502 50123415', (SELECT id_rol FROM rol WHERE nombre='Entrenador'), 'manuel1', crypt('manuel123', gen_salt('bf')), 1),
('Rosa', 'Alvarado', '+502 50123416', (SELECT id_rol FROM rol WHERE nombre='Entrenador'), 'rosa1', crypt('rosa123', gen_salt('bf')), 1),
('Esteban', 'Velásquez', '+502 50123417', (SELECT id_rol FROM rol WHERE nombre='Entrenador'), 'esteban1', crypt('esteban123', gen_salt('bf')), 1),
('Paola', 'Mejía', '+502 50123418', (SELECT id_rol FROM rol WHERE nombre='Entrenador'), 'paola1', crypt('paola123', gen_salt('bf')), 1),
('Diego', 'Castañeda', '+502 50123419', (SELECT id_rol FROM rol WHERE nombre='Entrenador'), 'diego1', crypt('diego123', gen_salt('bf')), 1),
('Laura', 'Jiménez', '+502 50123420', (SELECT id_rol FROM rol WHERE nombre='Entrenador'), 'laura1', crypt('laura123', gen_salt('bf')), 1),
('Mauricio', 'Gómez', '+502 50123421', (SELECT id_rol FROM rol WHERE nombre='Entrenador'), 'mauricio1', crypt('mauricio123', gen_salt('bf')), 1),
('Andrea', 'Salazar', '+502 50123422', (SELECT id_rol FROM rol WHERE nombre='Entrenador'), 'andrea1', crypt('andrea123', gen_salt('bf')), 1),
('Víctor', 'Herrera', '+502 50123423', (SELECT id_rol FROM rol WHERE nombre='Entrenador'), 'victor1', crypt('victor123', gen_salt('bf')), 1),
('Elena', 'Domínguez', '+502 50123424', (SELECT id_rol FROM rol WHERE nombre='Entrenador'), 'elena1', crypt('elena123', gen_salt('bf')), 1);


-- EMPLEADOS SUCURSAL NORTE --

-- 2 RECEPCIONISTAS --
INSERT INTO rol (nombre) VALUES ('Recepcionista') ON CONFLICT DO NOTHING;
INSERT INTO empleado (nombre, apellido, telefono, id_rol, usuario_login, contrasena, id_sucursal)
VALUES ('Juan', 'Gonzalez', '+502 46552685',
        (SELECT id_rol FROM rol WHERE nombre='Recepcionista'),
        'juan', crypt('juan123', gen_salt('bf')), 2);

INSERT INTO empleado (nombre, apellido, telefono, id_rol, usuario_login, contrasena, id_sucursal)
VALUES ('Fabian', 'Alameda', '+502 46252685',
        (SELECT id_rol FROM rol WHERE nombre='Recepcionista'),
        'fabian', crypt('fabian123', gen_salt('bf')), 2);

-- 3 INVENTARIOS --
INSERT INTO rol (nombre) VALUES ('Inventario') ON CONFLICT DO NOTHING;
INSERT INTO empleado (nombre, apellido, telefono, id_rol, usuario_login, contrasena, id_sucursal)
VALUES ('Julio', 'Ramírez', '+502 50234561',
        (SELECT id_rol FROM rol WHERE nombre='Inventario'),
        'julio', crypt('julio123', gen_salt('bf')), 2);

INSERT INTO empleado (nombre, apellido, telefono, id_rol, usuario_login, contrasena, id_sucursal)
VALUES ('Marta', 'García', '+502 50345672',
        (SELECT id_rol FROM rol WHERE nombre='Inventario'),
        'marta', crypt('marta123', gen_salt('bf')), 2);

INSERT INTO empleado (nombre, apellido, telefono, id_rol, usuario_login, contrasena, id_sucursal)
VALUES ('Esteban', 'Flores', '+502 50456783',
        (SELECT id_rol FROM rol WHERE nombre='Inventario'),
        'esteban', crypt('esteban123', gen_salt('bf')), 2);

-- 15 ENTRENADORES --
INSERT INTO empleado (nombre, apellido, telefono, id_rol, usuario_login, contrasena, id_sucursal)
VALUES
('Luis', 'Pérez', '+502 51111101', (SELECT id_rol FROM rol WHERE nombre='Entrenador'), 'luis2', crypt('luis123', gen_salt('bf')), 2),
('María', 'González', '+502 58161102', (SELECT id_rol FROM rol WHERE nombre='Entrenador'), 'maria2', crypt('maria123', gen_salt('bf')), 2),
('Carlos', 'Ramírez', '+502 52151103', (SELECT id_rol FROM rol WHERE nombre='Entrenador'), 'carlos2', crypt('carlos123', gen_salt('bf')), 2),
('Ana', 'Hernández', '+502 59161104', (SELECT id_rol FROM rol WHERE nombre='Entrenador'), 'ana2', crypt('ana123', gen_salt('bf')), 2),
('Jorge', 'Mendoza', '+502 41131105', (SELECT id_rol FROM rol WHERE nombre='Entrenador'), 'jorge2', crypt('jorge123', gen_salt('bf')), 2),
('Claudia', 'Ruiz', '+502 48131106', (SELECT id_rol FROM rol WHERE nombre='Entrenador'), 'claudia2', crypt('claudia123', gen_salt('bf')), 2),
('Fernando', 'López', '+502 31161107', (SELECT id_rol FROM rol WHERE nombre='Entrenador'), 'fernando2', crypt('fernando123', gen_salt('bf')), 2),
('Patricia', 'Santos', '+502 59611108', (SELECT id_rol FROM rol WHERE nombre='Entrenador'), 'patricia2', crypt('patricia123', gen_salt('bf')), 2),
('Ricardo', 'García', '+502 54481109', (SELECT id_rol FROM rol WHERE nombre='Entrenador'), 'ricardo2', crypt('ricardo123', gen_salt('bf')), 2),
('Gabriela', 'Morales', '+502 33111110', (SELECT id_rol FROM rol WHERE nombre='Entrenador'), 'gabriela2', crypt('gabriela123', gen_salt('bf')), 2),
('Andrés', 'Castillo', '+502 57181114', (SELECT id_rol FROM rol WHERE nombre='Entrenador'), 'andres2', crypt('andres123', gen_salt('bf')), 2),
('Sofía', 'Ortiz', '+502 59901112', (SELECT id_rol FROM rol WHERE nombre='Entrenador'), 'sofia2', crypt('sofia123', gen_salt('bf')), 2),
('Héctor', 'Reyes', '+502 51111113', (SELECT id_rol FROM rol WHERE nombre='Entrenador'), 'hector2', crypt('hector123', gen_salt('bf')), 2),
('Diana', 'Luna', '+502 51135114', (SELECT id_rol FROM rol WHERE nombre='Entrenador'), 'diana2', crypt('diana123', gen_salt('bf')), 2),
('Manuel', 'Cano', '+502 33251111', (SELECT id_rol FROM rol WHERE nombre='Entrenador'), 'manuel2', crypt('manuel123', gen_salt('bf')), 2);


-- EMPLEADOS SUCURSAL SUR --
-- 1 RECEPCIONISTA --
INSERT INTO empleado (nombre, apellido, telefono, id_rol, usuario_login, contrasena, id_sucursal)
VALUES ('Rosa', 'Martínez', '+502 60112233',
        (SELECT id_rol FROM rol WHERE nombre='Recepcionista'),
        'rosa3', crypt('rosa123', gen_salt('bf')), 3);

-- 1 INVENTARIO --
INSERT INTO empleado (nombre, apellido, telefono, id_rol, usuario_login, contrasena, id_sucursal)
VALUES ('Pablo', 'Domínguez', '+502 60223344',
        (SELECT id_rol FROM rol WHERE nombre='Inventario'),
        'pablo3', crypt('pablo123', gen_salt('bf')), 3);

-- 10 ENTRENADORES --
INSERT INTO empleado (nombre, apellido, telefono, id_rol, usuario_login, contrasena, id_sucursal)
VALUES
('Natalia', 'Guzmán', '+502 60334455', (SELECT id_rol FROM rol WHERE nombre='Entrenador'), 'natalia3', crypt('natalia123', gen_salt('bf')), 3),
('Raúl', 'Castañeda', '+502 60445566', (SELECT id_rol FROM rol WHERE nombre='Entrenador'), 'raul3', crypt('raul123', gen_salt('bf')), 3),
('Elena', 'Vásquez', '+502 60556677', (SELECT id_rol FROM rol WHERE nombre='Entrenador'), 'elena3', crypt('elena123', gen_salt('bf')), 3),
('Oscar', 'Jiménez', '+502 60667788', (SELECT id_rol FROM rol WHERE nombre='Entrenador'), 'oscar3', crypt('oscar123', gen_salt('bf')), 3),
('Mónica', 'Paredes', '+502 60778899', (SELECT id_rol FROM rol WHERE nombre='Entrenador'), 'monica3', crypt('monica123', gen_salt('bf')), 3),
('Hugo', 'Salazar', '+502 60889900', (SELECT id_rol FROM rol WHERE nombre='Entrenador'), 'hugo3', crypt('hugo123', gen_salt('bf')), 3),
('Verónica', 'Campos', '+502 60990011', (SELECT id_rol FROM rol WHERE nombre='Entrenador'), 'veronica3', crypt('veronica123', gen_salt('bf')), 3),
('Emilio', 'Rodas', '+502 61001122', (SELECT id_rol FROM rol WHERE nombre='Entrenador'), 'emilio3', crypt('emilio123', gen_salt('bf')), 3),
('Silvia', 'Aguilar', '+502 61112233', (SELECT id_rol FROM rol WHERE nombre='Entrenador'), 'silvia3', crypt('silvia123', gen_salt('bf')), 3),
('Tomás', 'Escobar', '+502 61223344', (SELECT id_rol FROM rol WHERE nombre='Entrenador'), 'tomas3', crypt('tomas123', gen_salt('bf')), 3);


-- 60 CLIENTES --
INSERT INTO cliente (nombre, apellido, telefono) VALUES 
('Carlos', 'Ramírez', '+502 50110001'),
('María', 'López', '+502 50110002'),
('José', 'Pérez', '+502 50110003'),
('Ana', 'García', '+502 50110004'),
('Luis', 'Hernández', '+502 50110005'),
('Marta', 'Castillo', '+502 50110006'),
('Pedro', 'Santos', '+502 50110007'),
('Lucía', 'Cordero', '+502 50110008'),
('Andrés', 'Cano', '+502 50110009'),
('Verónica', 'Salazar', '+502 50110010'),

('Fernando', 'Ortega', '+502 50110011'),
('Patricia', 'Gómez', '+502 50110012'),
('Ricardo', 'Cifuentes', '+502 50110013'),
('Claudia', 'Juárez', '+502 50110014'),
('Jorge', 'Morales', '+502 50110015'),
('Elena', 'Chacón', '+502 50110016'),
('Diego', 'Cruz', '+502 50110017'),
('Gabriela', 'Mendoza', '+502 50110018'),
('Mario', 'Barrios', '+502 50110019'),
('Camila', 'Estrada', '+502 50110020'),

('Raúl', 'Gálvez', '+502 50110021'),
('Daniela', 'Herrera', '+502 50110022'),
('Hugo', 'Reyes', '+502 50110023'),
('Karla', 'Silva', '+502 50110024'),
('Felipe', 'Torres', '+502 50110025'),
('Lorena', 'Domínguez', '+502 50110026'),
('Esteban', 'Vargas', '+502 50110027'),
('Isabel', 'Carrillo', '+502 50110028'),
('Oscar', 'Sierra', '+502 50110029'),
('Paola', 'Maldonado', '+502 50110030'),

('Julio', 'Figueroa', '+502 50110031'),
('Sandra', 'Leiva', '+502 50110032'),
('Manuel', 'Aguilar', '+502 50110033'),
('Rosa', 'Valdez', '+502 50110034'),
('Cristian', 'Martínez', '+502 50110035'),
('Sofía', 'Pineda', '+502 50110036'),
('Héctor', 'Alvarado', '+502 50110037'),
('Natalia', 'Méndez', '+502 50110038'),
('Víctor', 'Jiménez', '+502 50110039'),
('Carmen', 'Escobar', '+502 50110040'),

('Guillermo', 'Mejía', '+502 50110041'),
('Alejandra', 'Campos', '+502 50110042'),
('Rafael', 'Solís', '+502 50110043'),
('Silvia', 'Fuentes', '+502 50110044'),
('Edgar', 'Pérez', '+502 50110045'),
('Adriana', 'Ramírez', '+502 50110046'),
('Francisco', 'Coronado', '+502 50110047'),
('Andrea', 'Lara', '+502 50110048'),
('Samuel', 'Navarro', '+502 50110049'),
('Melisa', 'Palacios', '+502 50110050'),

('Tomás', 'Villagrán', '+502 50110051'),
('Regina', 'Cardona', '+502 50110052'),
('Cristina', 'Batres', '+502 50110053'),
('Rodrigo', 'Alonzo', '+502 50110054'),
('Teresa', 'Quezada', '+502 50110055'),
('Mauricio', 'Ixchíu', '+502 50110056'),
('Valeria', 'Castañeda', '+502 50110057'),
('Sebastián', 'Palomo', '+502 50110058'),
('Ingrid', 'Chávez', '+502 50110059'),
('Pablo', 'Recinos', '+502 50110060');

-- ENTRENADOR_CLIENTE --
-- Cliente 1-3 con Alberto Zacarias
INSERT INTO entrenador_cliente (id_entrenador, id_cliente) VALUES
((SELECT id_empleado FROM empleado WHERE usuario_login='alberto'), 1),
((SELECT id_empleado FROM empleado WHERE usuario_login='alberto'), 2),
((SELECT id_empleado FROM empleado WHERE usuario_login='alberto'), 3);

-- Cliente 4-6 con Luis Pérez
INSERT INTO entrenador_cliente (id_entrenador, id_cliente) VALUES
((SELECT id_empleado FROM empleado WHERE usuario_login='luis1'), 4),
((SELECT id_empleado FROM empleado WHERE usuario_login='luis1'), 5),
((SELECT id_empleado FROM empleado WHERE usuario_login='luis1'), 6);

-- Cliente 7-9 con María González
INSERT INTO entrenador_cliente (id_entrenador, id_cliente) VALUES
((SELECT id_empleado FROM empleado WHERE usuario_login='maria1'), 7),
((SELECT id_empleado FROM empleado WHERE usuario_login='maria1'), 8),
((SELECT id_empleado FROM empleado WHERE usuario_login='maria1'), 9);

-- Cliente 10-12 con Carlos Ramírez
INSERT INTO entrenador_cliente (id_entrenador, id_cliente) VALUES
((SELECT id_empleado FROM empleado WHERE usuario_login='carlos1'), 10),
((SELECT id_empleado FROM empleado WHERE usuario_login='carlos1'), 11),
((SELECT id_empleado FROM empleado WHERE usuario_login='carlos1'), 12);

-- Cliente 13-15 con Jorge Mendoza
INSERT INTO entrenador_cliente (id_entrenador, id_cliente) VALUES
((SELECT id_empleado FROM empleado WHERE usuario_login='jorge1'), 13),
((SELECT id_empleado FROM empleado WHERE usuario_login='jorge1'), 14),
((SELECT id_empleado FROM empleado WHERE usuario_login='jorge1'), 15);

-- Cliente 16-18 con Claudia Ruiz
INSERT INTO entrenador_cliente (id_entrenador, id_cliente) VALUES
((SELECT id_empleado FROM empleado WHERE usuario_login='claudia1'), 16),
((SELECT id_empleado FROM empleado WHERE usuario_login='claudia1'), 17),
((SELECT id_empleado FROM empleado WHERE usuario_login='claudia1'), 18);

-- Cliente 19-21 con Fernando López
INSERT INTO entrenador_cliente (id_entrenador, id_cliente) VALUES
((SELECT id_empleado FROM empleado WHERE usuario_login='fernando1'), 19),
((SELECT id_empleado FROM empleado WHERE usuario_login='fernando1'), 20),
((SELECT id_empleado FROM empleado WHERE usuario_login='fernando1'), 21);

-- Cliente 22-24 con Luis Perez (Sucursal 2)
INSERT INTO entrenador_cliente (id_entrenador, id_cliente) VALUES
((SELECT id_empleado FROM empleado WHERE usuario_login='luis2'), 22),
((SELECT id_empleado FROM empleado WHERE usuario_login='luis2'), 23),
((SELECT id_empleado FROM empleado WHERE usuario_login='luis2'), 24);

-- Cliente 25-27 con Maria Gonzalez
INSERT INTO entrenador_cliente (id_entrenador, id_cliente) VALUES
((SELECT id_empleado FROM empleado WHERE usuario_login='maria2'), 25),
((SELECT id_empleado FROM empleado WHERE usuario_login='maria2'), 26),
((SELECT id_empleado FROM empleado WHERE usuario_login='maria2'), 27);

-- Cliente 28-30 con Carlos Ramirez
INSERT INTO entrenador_cliente (id_entrenador, id_cliente) VALUES
((SELECT id_empleado FROM empleado WHERE usuario_login='carlos2'), 28),
((SELECT id_empleado FROM empleado WHERE usuario_login='carlos2'), 29),
((SELECT id_empleado FROM empleado WHERE usuario_login='carlos2'), 30);

-- Cliente 31-33 con Ana Hernandez
INSERT INTO entrenador_cliente (id_entrenador, id_cliente) VALUES
((SELECT id_empleado FROM empleado WHERE usuario_login='ana2'), 31),
((SELECT id_empleado FROM empleado WHERE usuario_login='ana2'), 32),
((SELECT id_empleado FROM empleado WHERE usuario_login='ana2'), 33);

-- Cliente 34-36 con Jorge Mendoza
INSERT INTO entrenador_cliente (id_entrenador, id_cliente) VALUES
((SELECT id_empleado FROM empleado WHERE usuario_login='jorge2'), 34),
((SELECT id_empleado FROM empleado WHERE usuario_login='jorge2'), 35),
((SELECT id_empleado FROM empleado WHERE usuario_login='jorge2'), 36);

-- Cliente 37-39 con Claudia Ruiz
INSERT INTO entrenador_cliente (id_entrenador, id_cliente) VALUES
((SELECT id_empleado FROM empleado WHERE usuario_login='claudia2'), 37),
((SELECT id_empleado FROM empleado WHERE usuario_login='claudia2'), 38),
((SELECT id_empleado FROM empleado WHERE usuario_login='claudia2'), 39);

-- Cliente 40-42 con Fernando Lopez
INSERT INTO entrenador_cliente (id_entrenador, id_cliente) VALUES
((SELECT id_empleado FROM empleado WHERE usuario_login='fernando2'), 40),
((SELECT id_empleado FROM empleado WHERE usuario_login='fernando2'), 41),
((SELECT id_empleado FROM empleado WHERE usuario_login='fernando2'), 42);

-- Cliente 43-45 con Patricia Santos
INSERT INTO entrenador_cliente (id_entrenador, id_cliente) VALUES
((SELECT id_empleado FROM empleado WHERE usuario_login='patricia2'), 43),
((SELECT id_empleado FROM empleado WHERE usuario_login='patricia2'), 44),
((SELECT id_empleado FROM empleado WHERE usuario_login='patricia2'), 45);
-----
-- Cliente 46-48 con Natalia Guzman (SUCURSAL SUR)
INSERT INTO entrenador_cliente (id_entrenador, id_cliente) VALUES
((SELECT id_empleado FROM empleado WHERE usuario_login='natalia3'), 46),
((SELECT id_empleado FROM empleado WHERE usuario_login='natalia3'), 47),
((SELECT id_empleado FROM empleado WHERE usuario_login='natalia3'), 48);

-- Cliente 49-51 con Raul Castañeda 
INSERT INTO entrenador_cliente (id_entrenador, id_cliente) VALUES
((SELECT id_empleado FROM empleado WHERE usuario_login='raul3'), 49),
((SELECT id_empleado FROM empleado WHERE usuario_login='raul3'), 50),
((SELECT id_empleado FROM empleado WHERE usuario_login='raul3'), 51);

-- Cliente 52-54 con Elena Vasquez
INSERT INTO entrenador_cliente (id_entrenador, id_cliente) VALUES
((SELECT id_empleado FROM empleado WHERE usuario_login='elena3'), 52),
((SELECT id_empleado FROM empleado WHERE usuario_login='elena3'), 53),
((SELECT id_empleado FROM empleado WHERE usuario_login='elena3'), 54);

-- Cliente 55-57 con Oscar Gimenez
INSERT INTO entrenador_cliente (id_entrenador, id_cliente) VALUES
((SELECT id_empleado FROM empleado WHERE usuario_login='oscar3'), 55),
((SELECT id_empleado FROM empleado WHERE usuario_login='oscar3'), 56),
((SELECT id_empleado FROM empleado WHERE usuario_login='oscar3'), 57);

-- Cliente 58-60 con Mónica Paredes
INSERT INTO entrenador_cliente (id_entrenador, id_cliente) VALUES
((SELECT id_empleado FROM empleado WHERE usuario_login='monica3'), 58),
((SELECT id_empleado FROM empleado WHERE usuario_login='monica3'), 59),
((SELECT id_empleado FROM empleado WHERE usuario_login='monica3'), 60);

-- MEMBRESIAS --
INSERT INTO tipo_membresia (nombre) VALUES
('Básica'),
('Premium'),
('VIP');

INSERT INTO membresia (id_tipo_membresia, descuento) VALUES
((SELECT id_tipo_membresia FROM tipo_membresia WHERE nombre='Básica'), 0.00),
((SELECT id_tipo_membresia FROM tipo_membresia WHERE nombre='Premium'), 10.00),
((SELECT id_tipo_membresia FROM tipo_membresia WHERE nombre='VIP'), 20.00);

-- CLIENTES MEMBRESIAS --

-- Asignar membresía BASICA a los primeros 25 clientes
INSERT INTO cliente_membresia (id_cliente, id_membresia, fecha_inicio)
SELECT c.id_cliente,
       (SELECT MIN(id_membresia) 
        FROM membresia 
        WHERE id_tipo_membresia = (SELECT id_tipo_membresia FROM tipo_membresia WHERE nombre='Básica')),
       current_date
FROM cliente c
WHERE c.id_cliente BETWEEN 1 AND 25;

-- Asignar membresía PREMIUM a los siguientes 25 clientes
INSERT INTO cliente_membresia (id_cliente, id_membresia, fecha_inicio)
SELECT c.id_cliente,
       (SELECT MIN(id_membresia) 
        FROM membresia 
        WHERE id_tipo_membresia = (SELECT id_tipo_membresia FROM tipo_membresia WHERE nombre='Premium')),
       current_date
FROM cliente c
WHERE c.id_cliente BETWEEN 26 AND 50;

-- Asignar membresía VIP a los últimos 10 clientes
INSERT INTO cliente_membresia (id_cliente, id_membresia, fecha_inicio)
SELECT c.id_cliente,
       (SELECT MIN(id_membresia) 
        FROM membresia 
        WHERE id_tipo_membresia = (SELECT id_tipo_membresia FROM tipo_membresia WHERE nombre='VIP')),
       current_date
FROM cliente c
WHERE c.id_cliente BETWEEN 51 AND 60;

-- TIPOS DE PAGOS --
INSERT INTO tipo_pago (nombre) VALUES
('BASICO'),
('SERVICIO_ADICIONAL');

-- PLANES BASICOS --
INSERT INTO plan_basico (nombre, duracion_meses, costo)
VALUES 
    ('Mensual', 1, 200.00),        
    ('Trimestral', 3, 550.00),     
    ('Anual', 12, 2000.00);

--SERVICIOS ADICIONALES --
INSERT INTO servicio_adicional (nombre, costo) VALUES
('Spinning', 50.00),
('Yoga', 40.00),
('Crossfit', 70.00),
('Entrenamiento Personal', 100.00),
('Pilates', 60.00),
('Zumba', 45.00),
('Natación', 80.00),
('Kickboxing', 65.00),
('Gimnasio Funcional', 55.00);

-- Pago Básico
INSERT INTO pago (id_tipo_pago, monto, fecha_inicio, fecha_fin, id_plan, id_cliente)
VALUES (
    (SELECT id_tipo_pago FROM tipo_pago WHERE nombre = 'BASICO'),
    200.00,
    '2025-09-01',
    '2025-10-01',
    (SELECT id_plan FROM plan_basico WHERE nombre='Mensual'),
    1
)
RETURNING id_pago;

-- Pago Servicio Adicional
INSERT INTO pago (id_tipo_pago, monto, id_cliente)
VALUES (
    (SELECT id_tipo_pago FROM tipo_pago WHERE nombre = 'SERVICIO_ADICIONAL'),
    150.00,
    1
)
RETURNING id_pago;


DO $$
DECLARE
    c INT;
    tipo_pago_basico INT := (SELECT id_tipo_pago FROM tipo_pago WHERE nombre='BASICO');
    tipo_pago_adicional INT := (SELECT id_tipo_pago FROM tipo_pago WHERE nombre='SERVICIO_ADICIONAL');
    plan_ids INT[];
    servicio_ids INT[];
    plan_id INT;
    pago_basico_id INT;
    pago_adicional_id INT;
    num_servicios INT;
    idx INT;
BEGIN
    -- Obtener array de IDs de planes
    SELECT array_agg(id_plan) INTO plan_ids FROM plan_basico;

    -- Obtener array de IDs de servicios
    SELECT array_agg(id_servicio) INTO servicio_ids FROM servicio_adicional;

    FOR c IN 1..60 LOOP
        -- Elegir plan aleatorio
        plan_id := plan_ids[1 + ((c-1) % array_length(plan_ids,1))]; -- Distribución cíclica

        -- INSERTAR PAGO BASICO
        INSERT INTO pago (id_tipo_pago, monto, fecha_inicio, fecha_fin, id_plan, id_cliente)
        VALUES (
            tipo_pago_basico,
            (SELECT costo FROM plan_basico WHERE id_plan = plan_id),
            current_date,
            current_date + (SELECT duracion_meses * interval '1 month' FROM plan_basico WHERE id_plan = plan_id),
            plan_id,
            c
        )
        RETURNING id_pago INTO pago_basico_id;

        -- INSERTAR PAGO SERVICIO_ADICIONAL
        INSERT INTO pago (id_tipo_pago, monto, id_cliente)
        VALUES (
            tipo_pago_adicional,
            0, -- monto total calculado luego
            c
        )
        RETURNING id_pago INTO pago_adicional_id;

        -- Elegir de 1 a 3 servicios aleatorios
        num_servicios := 1 + (c % 3); -- alterna 1,2,3 servicios por cliente

        FOR idx IN 1..num_servicios LOOP
            INSERT INTO pago_servicio (id_pago, id_servicio, cantidad)
            VALUES (
                pago_adicional_id,
                servicio_ids[ ((c + idx) % array_length(servicio_ids,1)) + 1 ],
                1 + ((c + idx) % 3) -- cantidad 1 a 3
            );
        END LOOP;

        -- Actualizar monto total del pago adicional
        UPDATE pago
        SET monto = (SELECT SUM(s.costo * ps.cantidad)
                     FROM pago_servicio ps
                     JOIN servicio_adicional s ON ps.id_servicio = s.id_servicio
                     WHERE ps.id_pago = pago_adicional_id)
        WHERE id_pago = pago_adicional_id;
    END LOOP;
END
$$;

-- INSERT EQUIPOS --
INSERT INTO equipo (nombre, estado, id_sucursal) VALUES

-- SUCURSAL 1 --
('Caminadora','Disponible',1),
('Bicicleta Estática','Disponible',1),
('Banco de Pesas','Disponible',1),
('Escaladora','Disponible',1),
('Elíptica','Disponible',1),
('Máquina de Remo','Disponible',1),
('Máquina de Piernas','Disponible',1),
('Máquina de Hombros','Disponible',1),
('Máquina de Abdominales','Disponible',1),
('Máquina de Glúteos','Disponible',1);

-- SUCURSAL 2 --
('Caminadora','Disponible',2),
('Bicicleta Estática','Disponible',2),
('Banco de Pesas','Disponible',2),
('Escaladora','Disponible',2),
('Elíptica','Disponible',2),
('Máquina de Remo','Disponible',2),
('Máquina de Piernas','Disponible',2),
('Máquina de Hombros','Disponible',2),
('Máquina de Abdominales','Disponible',2),
('Máquina de Glúteos','Disponible',2);

-- SUCURSAL 3 --
('Caminadora','Disponible',3),
('Bicicleta Estática','Disponible',3),
('Banco de Pesas','Disponible',3),
('Escaladora','Disponible',3),
('Elíptica','Disponible',3),
('Máquina de Remo','Disponible',3),
('Máquina de Piernas','Disponible',3),
('Máquina de Hombros','Disponible',3),
('Máquina de Abdominales','Disponible',3),
('Máquina de Glúteos','Disponible',3);


-- EJERCICIOS
-- Caminadora
INSERT INTO ejercicio (nombre, series, repeticiones, duracion_minutos, id_equipo) VALUES
('Caminata ligera', 1, 1, 20, 1),
('Caminata rápida', 1, 1, 15, 1),
('Intervalos de carrera', 1, 1, 10, 1);

-- Bicicleta Estática
INSERT INTO ejercicio (nombre, series, repeticiones, duracion_minutos, id_equipo) VALUES
('Pedaleo suave', 1, 1, 20, 2),
('Pedaleo intenso', 1, 1, 15, 2),
('Intervalos de velocidad', 1, 1, 10, 2);

-- Banco de Pesas
INSERT INTO ejercicio (nombre, series, repeticiones, duracion_minutos, id_equipo) VALUES
('Press de pecho', 3, 12, NULL, 3),
('Curl de bíceps', 3, 10, NULL, 3),
('Extensión de tríceps', 3, 10, NULL, 3);

-- Escaladora
INSERT INTO ejercicio (nombre, series, repeticiones, duracion_minutos, id_equipo) VALUES
('Subida continua',1,1,15,4),
('Subida rápida',1,1,10,4);

-- Elíptica
INSERT INTO ejercicio (nombre, series, repeticiones, duracion_minutos, id_equipo) VALUES
('Elíptica suave',1,1,20,5),
('Elíptica intensa',1,1,15,5);

-- Máquina de Remo
INSERT INTO ejercicio (nombre, series, repeticiones, duracion_minutos, id_equipo) VALUES
('Remo moderado',1,1,15,6),
('Remo intenso',1,1,10,6);

-- Máquinas de fuerza (Piernas, Hombros, Abdominales, Glúteos)
INSERT INTO ejercicio (nombre, series, repeticiones, duracion_minutos, id_equipo) VALUES
('Prensa de piernas',3,12,NULL,7),
('Press de hombros',3,12,NULL,8),
('Abdominales crunch',3,15,NULL,9),
('Glúteos en máquina',3,15,NULL,10);

-- RUTINAS --
DO $$
DECLARE
    c INT;
    rutina_id INT;
    ejercicios INT[];
    num_ejercicios INT;
    idx INT;
BEGIN
    -- Array con todos los IDs de ejercicios
    SELECT array_agg(id_ejercicio) INTO ejercicios FROM ejercicio;

    FOR c IN 1..60 LOOP
        -- Crear rutina para cada cliente
        INSERT INTO rutina (nombre, id_cliente, fecha_inicio)
        VALUES ('Rutina Cliente ' || c, c, current_date)
        RETURNING id_rutina INTO rutina_id;

        -- Determinar cuántos ejercicios tendrá la rutina (entre 4 y 7)
        num_ejercicios := 4 + ((c * 2) % 4); 

        -- Asignar ejercicios a la rutina de forma cíclica
        FOR idx IN 1..num_ejercicios LOOP
            INSERT INTO rutina_ejercicio (id_rutina, id_ejercicio, orden)
            VALUES (
                rutina_id,
                ejercicios[ ((c + idx) % array_length(ejercicios,1)) + 1 ],
                idx
            );
        END LOOP;
    END LOOP;
END
$$;

-- REGISTRO DE ASISTENCIAS --
DO $$
DECLARE
    c INT;
    num_asistencias INT;
    i INT;
    cliente_id INT;
    sucursal_id INT;
BEGIN
    -- Recorrer todos los clientes
    FOR cliente_id IN SELECT id_cliente FROM cliente LOOP

        -- Número aleatorio de asistencias entre 5 y 15
        num_asistencias := 5 + (cliente_id % 11); 

        FOR i IN 1..num_asistencias LOOP
            -- Elegir sucursal aleatoria
            sucursal_id := 1 + ( (cliente_id + i) % 3 ); -- 3 sucursales

            -- Insertar asistencia con fecha aleatoria dentro de los últimos 30 días
            INSERT INTO asistencia (fecha_hora, id_cliente, id_sucursal)
            VALUES (
                current_date - (i * (cliente_id % 5))::int,
                cliente_id,
                sucursal_id
            );
        END LOOP;
    END LOOP;
END
$$;
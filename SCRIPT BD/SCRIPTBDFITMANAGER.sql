-- SCRIPT POSTGRESQL FIT-MANAGER --

CREATE SCHEMA IF NOT EXISTS fitmanager;
SET search_path = fitmanager;

-- TABLA SUCURSAL --
CREATE TABLE sucursal (
id_sucursal SERIAL PRIMARY KEY,
nombre VARCHAR(30) NOT NULL,
ubicacion TEXT,
capacidad_maquinas INTEGER DEFAULT 0
);

-- TABLA TIPO DE MEMBRESIA
CREATE TABLE tipo_membresia (
    id_tipo_membresia SERIAL PRIMARY KEY,
    nombre VARCHAR(30) UNIQUE NOT NULL
);


-- TABLA MEMBRESIA --
CREATE TABLE membresia (
    id_membresia SERIAL PRIMARY KEY,
    id_tipo_membresia INT NOT NULL,
    descuento NUMERIC(5,2) NOT NULL DEFAULT 0,
    CONSTRAINT fk_tipo_membresia FOREIGN KEY (id_tipo_membresia)
        REFERENCES tipo_membresia (id_tipo_membresia)
        ON UPDATE CASCADE
        ON DELETE RESTRICT
);

-- TABLA ROL --
CREATE TABLE rol (
    id_rol SERIAL PRIMARY KEY,
    nombre VARCHAR(30) UNIQUE NOT NULL
);

-- TABLA EMPLEADO --
CREATE TABLE empleado (
    id_empleado SERIAL PRIMARY KEY,
    nombre VARCHAR(30) NOT NULL,
    apellido VARCHAR(30) NOT NULL,
    telefono VARCHAR(20) NOT NULL,
    id_rol INT NOT NULL REFERENCES rol(id_rol) ON UPDATE CASCADE ON DELETE RESTRICT,
    usuario_login VARCHAR(80) UNIQUE NOT NULL,
    contrasena VARCHAR(255) NOT NULL,
    id_sucursal INT REFERENCES sucursal(id_sucursal) ON DELETE SET NULL
);

-- TABLA CLIENTE --
CREATE TABLE cliente (
    id_cliente SERIAL PRIMARY KEY,
    nombre VARCHAR(30) NOT NULL,
    apellido VARCHAR(30) NOT NULL,
    telefono VARCHAR(20) NOT NULL,
    fecha_registro TIMESTAMP WITHOUT TIME ZONE DEFAULT now()
);

-- ENTIDAD DEBIL CLIENTE_MEMBRESIA --
CREATE TABLE cliente_membresia (
    id_cliente INT REFERENCES cliente(id_cliente) ON DELETE CASCADE,
    id_membresia INT REFERENCES membresia(id_membresia) ON DELETE CASCADE,
    fecha_inicio DATE NOT NULL DEFAULT current_date,
    fecha_fin DATE,
    PRIMARY KEY (id_cliente, id_membresia, fecha_inicio)
);

-- TABLA ENTRENADOR_CLIENTE --
CREATE TABLE entrenador_cliente (
    id_entrenador INTEGER REFERENCES empleado(id_empleado) ON DELETE CASCADE,
    id_cliente INTEGER REFERENCES cliente(id_cliente) ON DELETE CASCADE,
    fecha_asignacion DATE DEFAULT current_date,
    PRIMARY KEY (id_entrenador, id_cliente, fecha_asignacion)
);

-- TABLA RUTINA --
CREATE TABLE rutina (
    id_rutina SERIAL PRIMARY KEY,
    nombre VARCHAR(30) NOT NULL,
    fecha_inicio DATE NOT NULL DEFAULT current_date,
    id_cliente INTEGER REFERENCES cliente(id_cliente) ON DELETE CASCADE,
    id_entrenador INTEGER REFERENCES empleado(id_empleado) ON DELETE SET NULL
);

-- TABLA EQUIPO --
CREATE TABLE equipo (
    id_equipo SERIAL PRIMARY KEY,
    nombre VARCHAR(30) NOT NULL,
    estado VARCHAR(30) NOT NULL DEFAULT 'Disponible',
    id_sucursal INTEGER REFERENCES sucursal(id_sucursal) ON DELETE SET NULL
);

-- TABLA EJERCICIO --
CREATE TABLE ejercicio (
    id_ejercicio SERIAL PRIMARY KEY,
    nombre VARCHAR(30) NOT NULL,
    series INTEGER NOT NULL DEFAULT 3,
    repeticiones INTEGER NOT NULL DEFAULT 10,
    duracion_minutos INTEGER,
    id_equipo INTEGER REFERENCES equipo(id_equipo)
);

-- ENTIDAD DEBIL RUTINA_EJERCICIO --
CREATE TABLE rutina_ejercicio (
    id_rutina INTEGER REFERENCES rutina(id_rutina) ON DELETE CASCADE,
    id_ejercicio INTEGER REFERENCES ejercicio(id_ejercicio) ON DELETE CASCADE,
    orden INTEGER DEFAULT 1,
    PRIMARY KEY (id_rutina, id_ejercicio)
);

-- TABLA ASISTENCIA --
CREATE TABLE asistencia (
    id_asistencia BIGSERIAL PRIMARY KEY,
    fecha_hora TIMESTAMP WITHOUT TIME ZONE NOT NULL DEFAULT now(),
    id_cliente INTEGER REFERENCES cliente(id_cliente) ON DELETE CASCADE,
    id_sucursal INTEGER REFERENCES sucursal(id_sucursal) ON DELETE SET NULL
);

-- TABLA SERVICIO_ADICIONAL --
CREATE TABLE servicio_adicional (
    id_servicio SERIAL PRIMARY KEY,
    nombre VARCHAR(30) NOT NULL,
    costo NUMERIC(10,2) NOT NULL
);

-- TABLA PLAN BASICO
CREATE TABLE plan_basico (
    id_plan SERIAL PRIMARY KEY,
    nombre VARCHAR(20) NOT NULL,  
    duracion_meses INT NOT NULL,   
    costo NUMERIC(10,2) NOT NULL
);

-- TABLA TIPO_PAGO --
CREATE TABLE tipo_pago (
    id_tipo_pago SERIAL PRIMARY KEY,
    nombre VARCHAR(30) UNIQUE NOT NULL
);

-- TABLA PAGO --
CREATE TABLE pago (
    id_pago SERIAL PRIMARY KEY,
    id_tipo_pago INT NOT NULL REFERENCES tipo_pago(id_tipo_pago)
        ON UPDATE CASCADE
        ON DELETE RESTRICT, 
    monto NUMERIC(12,2) NOT NULL,
    fecha_pago TIMESTAMP WITHOUT TIME ZONE NOT NULL DEFAULT now(),
    fecha_inicio DATE,
    fecha_fin DATE,
    id_cliente INTEGER REFERENCES cliente(id_cliente) ON DELETE CASCADE
);

-- ENTIDAD DEBIL PAGO_SERVICIO --
CREATE TABLE pago_servicio (
    id_pago INTEGER REFERENCES pago(id_pago) ON DELETE CASCADE,
    id_servicio INTEGER REFERENCES servicio_adicional(id_servicio) ON DELETE CASCADE,
    cantidad INTEGER DEFAULT 1,
    PRIMARY KEY (id_pago, id_servicio)
);

-- ENTIDAD DEBIL PAGO_MEMBRESIA
CREATE TABLE pago_membresia (
    id_pago INT REFERENCES pago(id_pago) ON DELETE CASCADE,
    id_membresia INT REFERENCES membresia(id_membresia) ON DELETE CASCADE,
    PRIMARY KEY (id_pago, id_membresia)
);


-- TABLA PRODUCTO --
CREATE TABLE producto (
    id_producto SERIAL PRIMARY KEY,
    nombre VARCHAR(30) NOT NULL,
    stock INTEGER DEFAULT 0,
    precio NUMERIC(10,2) NOT NULL,
    id_sucursal INT NOT NULL REFERENCES sucursal(id_sucursal)
        ON UPDATE CASCADE
        ON DELETE CASCADE
);

-- TABLA PAGO_PRODUCTO --
CREATE TABLE pago_producto (
    id_pago INTEGER REFERENCES pago(id_pago) ON DELETE CASCADE,
    id_producto INTEGER REFERENCES producto(id_producto) ON DELETE CASCADE,
    cantidad INTEGER DEFAULT 1,
    PRIMARY KEY (id_pago, id_producto)
);

-- INDICES POR EFICIENCIA --
CREATE INDEX idx_asistencia_cliente_fecha ON asistencia (id_cliente, fecha_hora);
CREATE INDEX idx_pago_cliente_fecha ON pago (id_cliente, fecha_pago);


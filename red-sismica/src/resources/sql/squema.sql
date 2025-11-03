-- Esquema SQLite para las entidades (sin las clases específicas de EstadosSismografo)

PRAGMA foreign_keys = ON;

-- Rol
CREATE TABLE IF NOT EXISTS rol (
  id INTEGER PRIMARY KEY AUTOINCREMENT,
  nombre TEXT NOT NULL
);

-- Empleado
CREATE TABLE IF NOT EXISTS empleado (
  id INTEGER PRIMARY KEY AUTOINCREMENT,
  nombre TEXT,
  apellido TEXT,
  mail TEXT,
  telefono INTEGER,
  rol_id INTEGER,
  FOREIGN KEY (rol_id) REFERENCES rol(id) ON DELETE SET NULL
);

-- Usuario
CREATE TABLE IF NOT EXISTS usuario (
  id INTEGER PRIMARY KEY AUTOINCREMENT,
  contrasena TEXT,
  nombre_usuario TEXT UNIQUE,
  empleado_id INTEGER,
  FOREIGN KEY (empleado_id) REFERENCES empleado(id) ON DELETE SET NULL
);

-- Estacion Sismologica
CREATE TABLE IF NOT EXISTS estacion_sismologica (
  codigo_estacion INTEGER PRIMARY KEY,
  nombre TEXT,
  documento_certificacion_adq TEXT,
  fecha_solicitud_certificacion TEXT,
  latitud TEXT,
  longitud TEXT,
  nro_certificacion_adquisicion INTEGER
);

-- Estado (para OrdenInspeccion u otros ambitos)
CREATE TABLE IF NOT EXISTS estado (
  id INTEGER PRIMARY KEY AUTOINCREMENT,
  nombre TEXT,
  ambito TEXT
);

-- Orden Inspeccion
CREATE TABLE IF NOT EXISTS orden_inspeccion (
  nro_orden INTEGER PRIMARY KEY,
  fecha_inicio TEXT,
  fecha_finalizacion TEXT,
  fecha_hora_cierre TEXT,
  observacion_cierre TEXT,
  empleado_id INTEGER,
  estacion_codigo INTEGER,
  estado_id INTEGER,
  FOREIGN KEY (empleado_id) REFERENCES empleado(id) ON DELETE SET NULL,
  FOREIGN KEY (estacion_codigo) REFERENCES estacion_sismologica(codigo_estacion) ON DELETE SET NULL,
  FOREIGN KEY (estado_id) REFERENCES estado(id) ON DELETE SET NULL
);

-- Sismografo
CREATE TABLE IF NOT EXISTS sismografo (
  id_sismografo TEXT PRIMARY KEY,
  fecha_adquisicion TEXT,
  nro_serie INTEGER,
  estacion_codigo INTEGER,
  responsable_inspeccion_id INTEGER,
  estado_actual TEXT,
  FOREIGN KEY (estacion_codigo) REFERENCES estacion_sismologica(codigo_estacion) ON DELETE SET NULL,
  FOREIGN KEY (responsable_inspeccion_id) REFERENCES empleado(id) ON DELETE SET NULL
);

-- Cambio Estado (cada cambio asociado a un sismografo)
CREATE TABLE IF NOT EXISTS cambio_estado (
  id INTEGER PRIMARY KEY AUTOINCREMENT,
  sismografo_id TEXT,
  fecha_hora_inicio TEXT,
  fecha_hora_fin TEXT,
  estado_nombre TEXT,
  FOREIGN KEY (sismografo_id) REFERENCES sismografo(id_sismografo) ON DELETE CASCADE
);

-- MotivoTipo
CREATE TABLE IF NOT EXISTS motivo_tipo (
  id INTEGER PRIMARY KEY AUTOINCREMENT,
  descripcion TEXT
);

-- MotivoFueraServicio
CREATE TABLE IF NOT EXISTS motivo_fuera_servicio (
  id INTEGER PRIMARY KEY AUTOINCREMENT,
  comentario TEXT,
  tipo_id INTEGER,
  FOREIGN KEY (tipo_id) REFERENCES motivo_tipo(id) ON DELETE SET NULL
);

-- Relación N:N entre CambioEstado y MotivoFueraServicio
CREATE TABLE IF NOT EXISTS cambio_motivo (
  cambio_id INTEGER,
  motivo_id INTEGER,
  PRIMARY KEY (cambio_id, motivo_id),
  FOREIGN KEY (cambio_id) REFERENCES cambio_estado(id) ON DELETE CASCADE,
  FOREIGN KEY (motivo_id) REFERENCES motivo_fuera_servicio(id) ON DELETE CASCADE
);

-- Sesion
CREATE TABLE IF NOT EXISTS sesion (
  id INTEGER PRIMARY KEY AUTOINCREMENT,
  fecha_hora_inicio TEXT,
  fecha_hora_fin TEXT,
  usuario_id INTEGER,
  FOREIGN KEY (usuario_id) REFERENCES usuario(id) ON DELETE SET NULL
);

-- Índices útiles
CREATE INDEX IF NOT EXISTS idx_empleado_rol ON empleado(rol_id);
CREATE INDEX IF NOT EXISTS idx_usuario_empleado ON usuario(empleado_id);
CREATE INDEX IF NOT EXISTS idx_sismografo_estacion ON sismografo(estacion_codigo);
CREATE INDEX IF NOT EXISTS idx_cambio_sismografo ON cambio_estado(sismografo_id);

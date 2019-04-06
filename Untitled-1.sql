CREATE TABLE conductor (
  conductor_id INT PRIMARY KEY,
  nombre VARCHAR(40),
  apellidos VARCHAR(40),
  birth_day DATE,
  genero VARCHAR(1)
);

CREATE TABLE trailer(
	trailer_id INT PRIMARY KEY,
	placas VARCHAR(40),
	capacidad DECIMAL(11,2)
);

CREATE TABLE envios (
  conductor_id INT,
  trailer_id INT,
  tipo_envio VARCHAR(40),
  fecha_salida Date,
  cliente VARCHAR(40),
  estado VARCHAR(40),
  ciudad VARCHAR(40),
  direccion VARCHAR(60),
  estado_actual VARCHAR(40),
  PRIMARY KEY (conductor_id, trailer_id),
  FOREIGN KEY (conductor_id) REFERENCES conductor(conductor_id) ON DELETE CASCADE,
  FOREIGN KEY (trailer_id) REFERENCES trailer(trailer_id) ON DELETE CASCADE
);

CREATE TABLE envios_completados (
  envio_id INT PRIMARY KEY NOT NULL auto_increment,
  fecha_salida DATE,
  fecha_entrada DATE,
  cliente VARCHAR(40)
);
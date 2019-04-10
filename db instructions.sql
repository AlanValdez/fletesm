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
  fecha_entrada TIMESTAMP DEFAULT current_timestamp,
  cliente VARCHAR(40)
);

DELIMITER $$
CREATE
    TRIGGER autoCloseEnvio AFTER UPDATE
    ON envios
    FOR EACH ROW BEGIN
        IF NEW.estado_actual = 'Terminado' THEN
            INSERT INTO envios_completados(fecha_salida, cliente, conductor_id, trailer_id) VALUES(NEW.fecha_salida, NEW.cliente, NEW.conductor_id, NEW.trailer_id);
        END IF;
    END$$
DELIMITER ;

{"placas": "FHN-44A-KSM", "capacidad_toneladas": 27.26}

{"nombre": "test update 2", "apellidos": "valdez", "dia_nacimiento": "1997-02-01", "sexo": "m"}

PUT envios?cond=1&trai=1
# Servicios Restful Fletes Montemayor

## Descripción.

Servicio Restful para un sistema que administra Fletes, Conductores y los Viajes realizados.
El enfoque esta en llevar una buena administracion del los Viajes que realizan los fletes del negocio.

## Problema identificado.

Era tedioso y propenso a errores el archivar la llegada de cada flete al negocio.

## Solución.

Sistema para ver en tiempo real el estado de los fletes y con un solo click archivar en la base de datos un viaje terminado y ver los fletes y conductores disponibles.

## Requerimientos.

Tener instalado:
- Instalar maven y agregarlo a variable del sistema
- Instalar Java 1.8 y agregarlo a variable del sistema
- Instalar Heroku
- Instalar MySql

# Instalación
## Para correrlo de manera local

Asegurate de tener java, maven y heroku instalados.

```
$ git clone https://github.com/AlanValdez/fletesmservice.git
$ mvn install
$ heroku local
```

La aplicacion correra en: (http://localhost:5000/).

## Para montarlo en heroku

Primero inicia sesion con heroku:login
```sh
$ heroku create
$ git push heroku master
$ heroku open
```

## Configuracion

Abre MySql deje un .sql para crear la base de datos de manera local o en una base de datos en la nube.

Abre el archivo application.properties y cambia la base de datos con la que vayas a utilizar.

## Documentacion
Para mas informacion de heroku y java.

- [Java en Heroku](https://devcenter.heroku.com/categories/java)

## Service
https://fletesmservice.herokuapp.com/

# USO
## Endpoints

INGRESA A http://localhost:5000/


Accede a estos ENDPOINTS

Conductores

Traer todos los conductores

•	GET /conductores

Crear un conductor

•	POST /conductores/créate

Update a un conductor

•	POST /conductores/update

Traerte conductores con la lista especidifcada

•	GET /conductores_list?ids={id, id…}

Traerte conductor por id

•	GET /conductores/by?id={id}



Trailers

Traer todos los trailers

•	GET / trailers

Crear un trailers

•	POST / trailers/créate

Update a un trailers

•	POST / trailers/update

Traerte trailers con la lista especidifcada

•	GET / trailers_list?ids={id, id…}

Traerte trailers por id

•	GET / trailers/by?id={id}


Envíos

Traer todos los envios

•	GET / envios

Crear un envió

•	POST / envios /

Cerrar un envío

•	PUT / envios? cond={id}&trai={id}

Traerte conductor por id

•	GET / envios/byConductor?id={id}

Traerte envió mediante tráiler id

•	GET /envios/byTrailer?id={id}

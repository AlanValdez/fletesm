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

## Contribucion

1.- Clonamos este repositorio en nuestra cuenta local

$ git clone https://github.com/AlanValdez/fletesmservice.git

2.- Creamos un branch donde agregaremos nuestro nuevo feature.
$ git checkout -b feature-nombre-branch

3.- Agregamos / Editamos los archivos necesarios para nuestro feature.

4.- Agregamos nuestros cambios al repositorio (http://www.kernel.org/pub/software/scm/git/docs/git-add.html)
$ git add .

5.- Hacemos commit de nuestros cambios con algun mensaje descriptivo pero corto en la primera linea, desde la segunda línea en adelante podemos re-escribir el Corán si deseamos.
$ git commit -m 'Cambie archivo x' asi con cada cambio importante

6.- Una vez terminado los cambios, realizamos un push al repositorio
$ git push origin feature-nombre-branch:feature-nombre-branch
(con este comando estamos sincronizando nuestro branch local a un branch con el mismo nombre en github)

7.- Hacemos un pull request. Para esto en el menú superior derecho, vemos un boton que dice _Pull Request_, le hacemos clic y se nos mostrará una pantalla. En ella escribiremos que feature(s) se agregan con nuestros cambios y por qué debería ser aceptado.

Una vez escrita la descripcion del cambio y porque fue realizado y porque es mejor que lo que ya esta, seleccionamos el botón _Send pull request_

Una vez hecho el merge, github nos envía una notificación, y podremos ver nuestros cambios en el repositorio principal.

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

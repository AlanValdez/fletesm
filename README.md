# Servicios Restful Fletes Montemayor

A barebones Java app, which can easily be deployed to Heroku.

This application supports the [Getting Started with Java on Heroku](https://devcenter.heroku.com/articles/getting-started-with-java) article - check it out.

[![Deploy to Heroku](https://www.herokucdn.com/deploy/button.png)](https://heroku.com/deploy)

## Para correrlo de manera local

Asegurate de tener java, maven y heroku instalados.

```
$ git clone https://github.com/AlanValdez/fletesmservice.git
$ mvn install
$ heroku local
```

La aplicacion correra en: (http://localhost:5000/).

Deje un .sql para crear la base de datos de manera local.

## Para montar en heroku

Primero inicia sesion con heroku:login
```sh
$ heroku create
$ git push heroku master
$ heroku open
```

## Documentacion
Para mas informacion de heroku y java.

- [Java on Heroku](https://devcenter.heroku.com/categories/java)

## Endpoints
ENDPOINTS

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

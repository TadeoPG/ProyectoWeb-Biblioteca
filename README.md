# Sistema Web para una biblioteca

NOTA: El proyecto aún se encuentra en desarrollo

Este proyecto se centra en la gestión de préstamos de fondos bibliográficos para una biblioteca
orientado para el uso de los empleados, ya sea del director general, recepcionista y desarrollador.

# Flujo del negocio

El usuario puede elegir acercarse a la biblioteca donde solicitará al recepcionista sacar a préstamo determinado fondo
o podrá solicitarlo desde la página web de público acceso.

# Tecnologías usadas

### Frontend

* Angular 16
* HTML
* CSS
* Javascript
* Typescript

### Backend

* Java 17
* Spring Boot 3
* Spring Data JPA

### Base de datos

* SQL Server

# Desplegando el proyecto

Para desplegar correctamente el proyecto deberás de seguir estos pasos:

1. __Prerrequisitos__: Tener previamente instalado Java 17, SQL Server 19, Angular 16 y Node.js en el sistema operativo.
2. __Crear la base de datos__: Es necesario crear la base de datos manualmente antes de ejecutar el Backend ya que
   el `spring.jpa.hibernate.ddl-auto=update` está en update.
3. __Modificar el archivo `application.properties`__: Configurar el URL, usuario y contraseña de la base de datos
   especificada anteriormente.

```
spring.datasource.url=jdbc:sqlserver://localhost:1433;databaseName=XXXXXX;TrustServerCertificate=True
spring.datasource.username=XXXXX
spring.datasource.password=XXXXX
```

4. __Instalar el la carpeta `node_modules`__: Al clonar este repositorio no se tendrá la carpeta `node_modules` por lo
   que se tendrá que instalar manualmente.
   Abrir la terminal en el Visual Studio Code que es donde se tendrá corriendo el proyecto Angular y ejecutar lo
   siguiente:

```
npm install
```

5. __Instalar la librería Chart.js__: Esta librería ofrece gráficos estadísticos que implementa el proyecto en la
   sección de reportes. Desde la terminal ejecutar:

```
npm install chart.js
```

# Endpoints

Una vez ejecutado el backend se puede probar algunos endpoints se pueden utilizar las siguientes URL en el cliente o navegador:

### GET

1. ``localhost:8080/libros``: Obtiene el listado de libros. 

[![](https://user-images.githubusercontent.com/2389286/236301770-16f46d4f-4e23-4db5-9462-f578ec31e751.svg)](http://localhost:8080/libros)
2. ``localhost:8080/tesis``: Obtiene el listado de tesis.
   
[![](https://user-images.githubusercontent.com/2389286/236301770-16f46d4f-4e23-4db5-9462-f578ec31e751.svg)](http://localhost:8080/tesis)
3. ``localhost:8080/revistas``: Obtiene el listado de revistas.

[![](https://user-images.githubusercontent.com/2389286/236301770-16f46d4f-4e23-4db5-9462-f578ec31e751.svg)](http://localhost:8080/revistas)
4. ``localhost:8080/articulos``: Obtiene el listado de articulos.

[![](https://user-images.githubusercontent.com/2389286/236301770-16f46d4f-4e23-4db5-9462-f578ec31e751.svg)](http://localhost:8080/articulos)

### POST

Para añadir un nuevo libro: 

```locahost:8080/libros```

En el request body ejecutar lo siguiente:

````json
{
  "titulo": "Título 40",
  "numPaginas": 100,
  "fechaPublicacion": "2022-01-01T00:00:00",
  "disponibilidad": true,
  "numEstante": 6,
  "disciplina": "Disciplina 5",
  "bibliografia": "Bibliografía 6",
  "pubAutor": [
    {
      "autor": {
        "idPersona": 9
      }
    },
    {
      "autor": {
        "idPersona": 10
      }
    }
  ],
  "editorial": {
    "id": 1
  },
  "categoriaLC": {
    "idCategoria": 1
  },
  "pubPC": [
    {
      "palabrasClave": {
        "idPalabrasclave": 1
      }
    },
    {
      "palabrasClave": {
        "idPalabrasclave": 21
      }
    }
  ],
  "enabled": true,
  "isbn": "ISBN001",
  "sinopsis": "Sinopsis 1",
  "numEdicion": 1
}
````

### PUT
Para actualizar un libro:

``localhost:8080/libros/idDeCualquierLibro``

En el request body ejecutar lo siguiente:
````json
{
  "titulo": "Manual de APIs REST en español",
  "numPaginas": 100,
  "fechaPublicacion": "2022-01-01T00:00:00",
  "disponibilidad": true,
  "numEstante": 6,
  "disciplina": "Disciplina 5",
  "bibliografia": "Bibliografía 6",
  "pubAutor": [
    {
      "autor": {
        "idPersona": 9
      }
    },
    {
      "autor": {
        "idPersona": 10
      }
    }
  ],
  "editorial": {
    "id": 1
  },
  "categoriaLC": {
    "idCategoria": 1
  },
  "pubPC": [
    {
      "palabrasClave": {
        "idPalabrasclave": 1
      }
    },
    {
      "palabrasClave": {
        "idPalabrasclave": 21
      }
    }
  ],
  "enabled": true,
  "isbn": "ISBN001",
  "sinopsis": "Sinopsis 1",
  "numEdicion": 1
}

````

### DELETE
Para eliminar un determinado libro:

``localhost:8080/libros/idDeCualquierLibro``

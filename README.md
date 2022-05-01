# Proyecto Grupo DACA

Proyecto basado en un sistema funcional, con la lógica de poder generar registros relacionales.

Tesis  [Universidad Lomas de Zamora](https://www.unlz.edu.ar/ )

## Herramientas

1. Crear un proyecto [Spring Initializr](https://start.spring.io/ ).
2. Project Maven Project.
3. Lenguaje Java.
4. Spring Boot 2.6.4.
5. Packaging War.
6. Java 11.
7. IntelliJ IDEA.
8. Instalar Maven for Window/Linux.
9. Instalar Java for Window/Linux.

## Integrantes

| Nombre              |Cargos         | Redes Sociales                                                   |
|---------------------|---------------|------------------------------------------------------------------|
| Richard Campos      |`"Full Stack"` | [LinkedIn](https://www.linkedin.com/in/richard-campos-47123877/) |
| Mariano Fleming     |`"Full Stack"` | [LinkedIn](https://www.linkedin.com/in/mariano-fleming/)         |
| Maximiliano Carrion |`"Full Stack"` | [GitHub](https://github.com/MaxiCarrion)                         |
| Facundo             |`"Full Stack"` | [GitHub](https://github.com/fsalvia)                             |

## Modo Uso

1. Compilar las nueva dependencias.

```html

<artifactId>spring-boot-starter-data-jpa</artifactId>
```

```html

<artifactId>lombok</artifactId>
```

```html

<artifactId>mysql-connector-java</artifactId>
```

```html

<artifactId>argon2-jvm</artifactId>
```

```html

<artifactId>jjwt</artifactId>
```

```html

<artifactId>spring-boot-starter-web</artifactId>
```

```html

<artifactId>spring-boot-test</artifactId>
```

```html

<artifactId>spring-boot-starter-test</artifactId>
```

2. Crear la base de datos con el archivo sentencia.sql, se crea la base de datos con el nombre de dacagroup.
3. Si tienes creado la base de datos, entonces ejecutar el archivo Insert.sql.
4. Insert.sql es un archivo que contiene el usuario Admin y Daca.
5. Ejecutar Maven Plugins Clean.
6. Ejecutar Maven Plugins Run.
7. Iniciar con el puerto 8080 -> http://localhost:8080.

## Novedades

1. Diseño de Inicio de Sesión.
2. Diseño de Registro de Usuario.
3. Diseño de Restaurar contraseña.
4. Diseño beta de Admin2 for Guíe.
5. Creación de base de datos.
6. Creación de la tabla usuarios.
7. Lógica de registrar nuevos usuarios con db.
8. Lógica de Iniciar sesión match con db.
9. Lógica de mostrar en una tabla los usuarios creados.
10. Lógica de hashear los password en la db.

## Usuarios

1. admin@gmail.com / Pass: Cambio2022 / Rol: Administrador
1. daca@gmail.com / Pass: Cambio2022 / Rol: Daca

## Contribución

1. Fork it!
2. Create your feature branch: `git checkout -b my-new-feature`.
3. Commit your changes: `git commit -am 'Add some feature'`.
4. Push to the branch: `git push origin my-new-feature`.
5. Submit a pull request.

# Hackathon Skills for Women in tech

## _Equipo 3_
| Nombre | Tecnología | Discord | Github
| ------ | ------ | ------ | ------ |
| Faviola Carrillo | Backend Spring Boot | FaviolaCarrillo#1378 |
| Sonia Mae | Backend Spring Boot | Sonia Mae#5039 | 
| Tania Zitle | Backend Spring Boot | Tania.Zitle#9420 | [TaniaZitle](https://github.com/TaniaZitle)
| YuDi CC | Mobile React Native | YuDi CC#3066 | [YuDiCC](https://github.com/YuDiCC)

##  Problemática a resolver
1. Instituciones y organizaciones internacionales becan a estudiantes para que puedan realizar licenciaturas, maestrías y doctorados en el extranjero pero no se tiene un seguimiento de estos estudiantes.
    - ¿Cómo podemos llevar control de las personas becadas, de su estatus?
    - ¿Cómo podemos mantener comunicación con ellxs? 
    - ¿Cómo podemos generar comunidad entre ellxs?  


2. Las universidades a nivel internacional invierten mucho dinero en buscar estudiantes que quieran estudiar las carreras que ofrecen ahí, realizan eventos y actividades pero muchas veces quedan cortas con la cantidad de estudiantes que pueden reclutar.
    - Necesitamos tener un perfil donde los estudiantes puedan agregar intereses y gustos y un perfil donde las universidades puedan tener su información para que se genere un match entre el perfil del estudiante y el perfil de la universidad.

### Opciones
Puede ser una app web, una app móvil, un bot conectado a telegram o discord, puede estar recibiendo información de google docs o puede recibir datos desde un CSV.

### Reglas
- Debe de ser un prototipo funcional.
- Debe de estar desplegado para usarse
- El proyecto debe de estar desplegado más tardar el domingo a las 5 pm hora Ciudad de México y se debe de enviar el acceso a la solución y el repositorio de GitHub a <hola@hackademy.lat>
- Agrega puntos extras el subir un video de 3 minutos explicando la solución, pueden subirlo a youtube como oculto.
- ✨Magic ✨

## Solución
Decidimos realizar la solución del problema 2

### Historias de Usuario
1. Como **usuario** deseo poder registrarme con correo y contraseña, y seleccionar un tipo de usuario
    - Estudiante o Universidad
2. Como **estudiante** deseo poder registrar mis datos personales
    - Nombre
    - Apellido
    - Matricula
    - País
    - Dirección
3. Como **estudiante** deseo poder seleccionar de un catálogo mis intereses
4. Como **estudiante** deseo poder ver información sobre las carreras que se acoplan a mis intereses
    - Cada carrera mostrará la Universidad a la que pertenece
5. Como **estudiante** deseo poder ver el perfil de las Universidades que son afines a mis intereses
6. Como **universidad** deseo poder registrar los datos de mi institución
    - Nombre
    - Descripción
    - Contacto
    - País
    - Dirección
7. Como **universidad** deseo poder registrar información de las diferentes carreras que ofrezco
    - Nombre
    - Descripción
    - Nivel escolar
    - Requisitos
8. Como **universidad** deseo poder seleccionar de un catálogo las áreas de interés que conforman las carreras que ofrezco
9. Como **universidad** deseo poder ver el perfil de estudiantes con intereses afines

### Base de Datos
Se diseñó una base de datos relacionada para cubrir las historias de usuario   
[Base de Datos](https://drive.google.com/file/d/1zzr6J8IBkXSWRGNwDT1z8zyG5WHFdBsU/view?usp=sharing)

### Soluciones

> **Backend**

Generamos una apiRest con patrón de diseño MVC en Spring Boot con estructura: 

 Package | Contenido | Descripción 
| ------ | ------ | ------ |
| **.api** | Application.java | Aplicación principal
|**.api.controllers** | Controladores | Endpoints de Metodos
| **.api.models** | Modelos | Modelo para creación de entidades
| **.api.repositories** | Repositorios | Repositorios JPA de cada modelo
| **.api.services** | Servicios | Servicios
|  | Implementación de Servicios | Logica del negocio

Implementamos 3 perfiles en Spring Boot, 2 de desarrollo y 1 de producción, esto con la finalidad de poder realizar las pruebas de los endpoints y el CRUD a través de Postman de manera local en postgres y/o con el gestor de Base de Datos en memoria H2.
Para el ambiente de producción realizamos el despliegue del api en Heroku, configurando una base Postgres.       
[Heroku APP](https://hackathon-sfwit-team3.herokuapp.com/)

Los endpoints fueron diseñados y probados en Postman, con la liga de Heroku como baseUrl.        
[Collección en Postman](https://www.getpostman.com/collections/cda1eb3b28ae2bee5c2a)

> **Mobile**

✨✨**La idea principal de la creación de este bot es que al conversar con el usuario le pregunte por sus intereses y el usuario pueda seleccionarlos a través de un menu y cada respuesta el bot le envie una lista de las escuelas o instituciones disponibles que se relacionen con las carreras. Así mismo, invitarlos a un chat grupal de ese interés en la cual vendría funcionando para interactuar con otros usuarios con un interés en común, además de que las universidades tengan acceso a dicho chat y realicen sus promociones u actividades**


Se plantearon las siguientes soluciones de las cuales se tratan de la creacion de un bot en la red social de telegram realizada a traves del bot "general" BotFather donde se crea el perfil de nuestro bot, donde debemos colocar el nombre de usuario, la foto de perfil y la descripcion de la cuenta. 

Para esto se utilizó los siguientes comandos: 
| Comando | Descripción | 
| ------ | ------ |
| /newbot | Para crear un nuevo bot |
| /setname | Cambia el nombre del bot |
| /setdescription | Modifica la descripción |
| /setuserpic | Cambiar la imagen de perfil del bot |

Los comandos anteriores son los básicos como el de /cancel y /token, entre otros comandos que se pueden integrar al bot para realizar más operaciones si hace lo requiere. El token nos servirá para administrar el bot.

Sin embargo en la plataforma de Telegram podemos encontrar otros asistentes online que nos ayudará para darle mejoras a los comandos, ademas que agregan otras funciones como creacion de un menú, botones, personalizar tus propios comandos y hacer posible que el bot pueda entablar una conversacion con una persona u enviar mensajes por defecto e inclusive realizar publicaciones en otra red social como Twitter.

- Para lograr esto usamos Manybot una de las alternativas más populares que ademas todo la magia se logra en la misma plataforma solo enviando el token del bot creado. 

- Otra opción es MenuBuilderBot que es similar a los demas bot pero incluyendo los botones y funcionalidades propias.

✨✨**La otra solución es la creación de una página en la cual el estudiante podra elegir sus intereses y al hacer clic en ellas se muestra las universidades o instituciones que esten disoponibles y que este relacionado las carreras que imparten con los intereses del usuario y al elegir la institución que mas le agrade lo redirige a la página principal de la escuela**

https://drive.google.com/file/d/15YCTKG-hxsPOkU-zc5SXqbgVWYeL6_Ua/view?usp=sharing

- La pagina principal muestra información como una breve introducción 
- Las categorías o intereses disponibles para que el usuario elija
    - Al hacer clic en cualquier interés de su preferencia se muetra otra página con las universidades disponibles
    - Las escuelas se irán actualizando de acuerdo a la disponibilidad 
    - al hacer clic en cada institución se rediriger al usuario a la página princiapal de aquella institución 
- Se muestra la información de contacto y las redes sociales de la página 
- Un espacio par que el usuario se registre y pueda tener más accesibilidad o mayor información a través de su correo

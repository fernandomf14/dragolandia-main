# Manual de usuario de Dragolandia
**Autor:** Fernando Lázaro Masen Ferreiro

## Introducción
### ¿Qué es dragolandia?

Dragolandia es un pequeño projecto de clase para practicar el uso de hibernate. Utilizamos dos variantes para el ejercicio.

1. La programación pura contra hibernate (puro) mediante **Session**
2. La programación utilizando el mediador **EntityManagerFactory**.

### ¿Qué hace este programa?

Permite simular un combate tipo JRPG. En este combate participan distintos **personajes / criaturas / Lugar** tales como:

- El Mago
- El Dragon
- Los Monstruos
- El Bosque

Se crean las tablas, y también se añaden, modifican y eliminan datos de la base de datos.

## Requisitos del sistema

1. Tener instalado java en el equipo.
2. Tener instalado Docker para levantar el contenedor del repositorio.
3. Tener instalado un IDE para su ejecución.

## Instalación

1. Levantar un contenedor docker en la ruta donde se encuentra el docker-compose.yml como se muestra en la siguiente captura de pantalla:
![alt text](./imagenes%20del%20manual/imagen%20de%20docker.png)

1. Compilar / ejecutar el projecto mediante Principal.java o PrincipalManager mediate el IDE correspondiente. 

Ejemplo en Visual Studio Code:

1. Buscamos la clase 

![alt text](./imagenes%20del%20manual/image.png)

2. Luego ejecutamos el programa en la flecha.
![alt text](./imagenes%20del%20manual/imagen%20de%20ejecucion.png)

En la terminal se muestra tanto la creación de las tablas, como la inserción, modificación, y eliminación de los datos. También esta el combate.

NOTA: No es necesario insertar datos, solo comprobar la consola. **NO existe interacción con el usuario**, ya que no estaba en los planes.

## Explicación del proceso en la ejecución

Cuando el programa se ejecuta [ ya sea mediante **Principal.java** o **PrincipalManager.java** ] se crean todas las tablas y se insertan, modifican, y eliminan los datos.

Las reglas del combate son las siguientes:

**1.** Al iniciar el combate siempre ataca el mago, y luego sus enemigos.
**2.** El mago puede lanzar un hechizo cada dos turnos, y el dragón ayuda al mago solo en tercer turno para agilizar el proceso de combate.
**3.** El dragón es una entidad especial, que solo ayuda al mago, pero no puede ser derrotado en batalla.
**4.** El combate termina cuando la vida del mago o sus enemigos llegue a 0.

Al finalizar lo dicho anteriormente se inicia el combate y se muestra en la interfaz los resultados de cada ronda, asi como los datos del mago, y sus enemigos, y se actualiza la vida de cada personaje.

EL usuario no necesita interactuar a mayores con el programa, solo debe ejecutarlo y visualizar los datos en la consola. Esto puede mejorarse, y se podría crear un menu para que este pueda interactuar con el mismo.

### Gestión de personajes

Cada entidad tiene sus propios métodos de inserción, modificación y eliminación mediante su propia clase controlador. Por tanto el usuario solo debe visualizar el proceso.

## Resultados

Cuando el combate comience debe aparecer en la vista algo similar:

![alt text](./imagenes%20del%20manual/imagen%20de%20resultados.png)






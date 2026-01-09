# Projecto Dragonlandia
## Introducción

Es un projecto sencillo utilizando hibernate para crear unas tablas, introducir datos, y hacer una simulación de combate pequeña.

## Mejoras y cambios futuros para Dragolandia

1. **Más hechizos y efectos:** Añadir hechizos nuevos con distintos efectos (por ejemplo curación o paralizar varios enemigos).  

2. **Nuevos tipos de monstruos y dragones:** Introducir enemigos con habilidades especiales o resistencia distinta para hacer el juego más variado.  

3. **Guardar y cargar partidas:** Implementar la opción de guardar la partida y los datos en un fichero. 

5. **Estadísticas y ranking:** Mostrar estadísticas de los magos, monstruos y dragón al final del juego, como número de ataques o daño hecho.  

6. **Implementar un menu:**: Esto permite una mejor vista.

## Análisis
### **Diagrama de clase de dragolandia**

```mermaid
classDiagram
    %% Clases principales

    class Vista {
        +void imprimirMensage(String mensaje)
    }

    class Controlador {
        +Modelo modelo
        +Vista vista
        +void ComenzarCombate(Monstruo m)
    }

    class Principal {
        +Principal principal
        +Controlador controlador
    }

    class Modelo {
        +Modelo getInstancia()
        +void inicializarJuego()
    }

    class Mago {
        +int id
        +String nombre
        +int vida
        +int nivelMagia
        +List~Hechizo~ conjuros

        +void lanzarHechizo(Hechizo hechizo)
        +void aprenderHechizo(Hechizo hechizo)
        +Boolean comprobarHechizo(Hechizo hechizo)
        +void lanzarHechizo(Hechizo hechizo)
    }

    class Monstruo {
        +int id
        +String nombre
        +int vida
        +Tipo tipo
        +int fuerza

        +void atacar(Mago mago)
    }

    class Dragon {
        +String nombre
        +int intensidadFuego
        +int resistencia
    }

    class ControladorDragon {
        +agregarDragon(em: EntityManager, dragon: Dragon)
        +modificarDragonNombre(em: EntityManager, id: int, nombre: String)
        +modificarDragonIntensidadFuego(em: EntityManager, id: int, intensidad: int)
        +modificarDragonResistencia(em: EntityManager, id: int, resistencia: int)
        +borrarDragon(em: EntityManager, id: int)
        +obtenerDragones(em: EntityManager) List~Dragon~
        +agregarDragon(session: Session, dragon: Dragon)
        +modificarDragonNombre(session: Session, id: int, nombre: String)
        +modificarDragonIntensidadFuego(session: Session, id: int, intensidad: int)
        +modificarDragonResistencia(session: Session, id: int, resistencia: int)
        +borrarDragon(session: Session, id: int)
        +obtenerDragones(session: Session) List~Dragon~
    }

    class Hechizo {
        <<abstract>>
        +String nombre
        +void Efecto(Monstruo m)
    }

    class Bosque {
        +int id
        +String nombre
        +int nivelPeligro
        +Monstruo monstruoJefe
        +List~Monstruo~ monstruos

        +String mostrarJefe()
        +void cambiarJefe(Monstruo monstruo)
        +void addMonstruo(Monstruo monstruo)
        +void eliminarMonstruo(Monstruo monstruo)
        +void cambiarDragon(Dragon)
    }

    class ControladorMago {
        +agregarMago(em: EntityManager, mago: Mago)
        +modificarMagoNombre(em: EntityManager, id: int, nombre: String)
        +modificarMagoVida(em: EntityManager, id: int, vida: int)
        +modificarMagoNivelMagia(em: EntityManager, id: int, nivelMagia: int)
        +borrarMago(em: EntityManager, id: int)
        +obtenerMagos(em: EntityManager) List~Mago~
        +agregarMago(session: Session, mago: Mago)
        +modificarMagoNombre(session: Session, id: int, nombre: String)
        +modificarMagoVida(session: Session, id: int, vida: int)
        +modificarMagoNivelMagia(session: Session, id: int, nivelMagia: int)
        +borrarMago(session: Session, id: int)
        +obtenerMagos(session: Session) List~Mago~
    }

    class ControladorDragon {
        +agregarDragon(em: EntityManager, dragon: Dragon)
        +modificarDragonNombre(em: EntityManager, id: int, nombre: String)
        +modificarDragonIntensidadFuego(em: EntityManager, id: int, intensidad: int)
        +modificarDragonResistencia(em: EntityManager, id: int, resistencia: int)
        +borrarDragon(em: EntityManager, id: int)
        +obtenerDragones(em: EntityManager) List~Dragon~
        +agregarDragon(session: Session, dragon: Dragon)
        +modificarDragonNombre(session: Session, id: int, nombre: String)
        +modificarDragonIntensidadFuego(session: Session, id: int, intensidad: int)
        +modificarDragonResistencia(session: Session, id: int, resistencia: int)
        +borrarDragon(session: Session, id: int)
        +obtenerDragones(session: Session) List~Dragon~
    }

    class ControladorBosque {
        +agregarBosque(em: EntityManager, bosque: Bosque)
        +modificarBosqueNombre(em: EntityManager, id: int, nombre: String)
        +modificarBosqueNivelPeligro(em: EntityManager, id: int, nivel: int)
        +modificarBosqueMonstruoJefe(em: EntityManager, id: int, monstruo: Monstruo)
        +modificarBosqueDragon(em: EntityManager, id: int, dragon: Dragon)
        +modificarBosqueMonstruos(em: EntityManager, id: int, monstruo: Monstruo)
        +borrarBosque(em: EntityManager, id: int)
        +obtenerBosques(em: EntityManager) List~Bosque~
        +agregarBosque(session: Session, bosque: Bosque)
        +modificarBosqueNombre(session: Session, id: int, nombre: String)
        +modificarBosqueNivelPeligro(session: Session, id: int, nivel: int)
        +modificarBosqueMonstruoJefe(session: Session, id: int, monstruo: Monstruo)
        +modificarBosqueDragon(session: Session, id: int, dragon: Dragon)
        +modificarBosqueMonstruos(session: Session, id: int, monstruo: Monstruo)
        +borrarBosque(session: Session, id: int)
        +obtenerBosques(session: Session) List~Bosque~
    }

    class PrincipalManager {
        -Controlador controlador
        +static EntityManagerFactory emf
        +main(String[] args)
        +static EntityManagerFactory getEmf()
    }

    %% Enumerados
    class Tipo {
        <<enumeration>>
        ogro
        troll
        espectro
    }

    %% Relaciones
    Mago --> "0..*" Hechizo : conoce
    Bosque --> "0..*" Monstruo : contiene
    Bosque --> Monstruo : monstruoJefe
    Dragon --> Bosque : habita_en
    Principal --> Controlador : delega
    Controlador --> Vista : controla
    Controlador --> Modelo : controla
    Modelo --> Mago : agrupa
    Modelo --> Bosque : agrupa
    Modelo --> Monstruo : agrupa
    Modelo --> Dragon : agrupa
    BolaDeFuego --|> Hechizo
    BolaDeNieve --|> Hechizo
    DarkBean --|> Hechizo
    Rayo --|> Hechizo
    Tipo --> Monstruo : Es del tipo
    ControladorBosque --> Bosque
    ControladorDragon --> Dragon
    ControladorMonstruo --> Monstruo
    ControladorMago --> Mago
    PrincipalManager --> Controlador

```
## Diseño
### Entidad relacion:
```mermaid
erDiagram
    %% Entidades
    MAGO {
        int id PK
        string nombre
        int vida
        int nivelMagia
    }

    HECHIZO {
        int id PK
        string nombre
    }

    MONSTRUO {
        int id PK
        string nombre
        int vida
        string tipo
        int fuerza
    }

    BOSQUE {
        int id PK
        string nombre
        int nivelPeligro
    }

    DRAGON {
        int id PK
        string nombre
        int intensidadFuego
        int resistencia
    }

    %% Relaciones
    MAGO ||--o{ HECHIZO : conoce
    BOSQUE ||--o{ MONSTRUO : contiene
    BOSQUE ||--|| MONSTRUO : jefe
    DRAGON }o--|| BOSQUE : habita_en
    BOSQUE ||--o{ MAGO : participa


```
# Projecto Dragonlandia
## Introducción

Es un projecto sencillo utilizando hibernate para crear unas tablas, introducir datos, y hacer una simulación de combate pequeña.

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
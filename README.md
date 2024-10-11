### Lista de Tareas - Aplicación en Java

Esta es una aplicación de lista de tareas desarrollada en Java usando Swing para la interfaz gráfica de usuario.

El sistema permite a los usuarios registrarse, iniciar sesión y gestionar su lista de tareas personal.
Las características clave incluyen agregar, modificar, eliminar, completar e imprimir tareas.

### Características

- **Registro de Usuarios**: Registra nuevos usuarios con un nombre de usuario y contraseña.

- **Inicio de Sesión**: Inicia sesión con las credenciales para ver y gestionar una lista de tareas personal.

- **Gestión de Tareas**: 
  - Agregar tareas con nombre, fecha de vencimiento y prioridad (Alta, Media, Baja).
  - Marcar tareas como completadas.
  - Modificar detalles de las tareas.
  - Eliminar tareas.
  
- **Exportar Tareas**: Imprimir y exportar la lista de tareas a un archivo de texto.

- **Interfaz Elegante**: La aplicación utiliza colores y diseños personalizados para mejorar la experiencia del usuario.

### Tecnologías Utilizadas

- **Java**: El lenguaje central utilizado para la aplicación.
- **Swing**:  herramientas de Java para crear interfaces gráficas de usuario.
- **Libreria java.io**: Usado para persistir los datos de usuarios y tareas.

### Clases del Proyecto

- `InterfazGrafica.java`: La interfaz gráfica principal de la aplicación. Gestiona el inicio de sesión, registro y operaciones de tareas.

- `ListaDeTareas.java`: Maneja la lista de tareas de cada usuario. Permite agregar, eliminar y guardar tareas.

- `Tarea.java`: Representa un objeto tarea con propiedades como nombre, fecha, prioridad y estado de completado.

- `Usuario.java`: Gestiona los datos de los usuarios, incluyendo el guardado y la carga de usuarios desde un archivo.

- `Main.java`: Punto de entrada de la aplicación, inicializa la interfaz gráfica.

### Cómo Ejecutar

1. Clona el repositorio:
    ```bash
    https://github.com/JorgeDavidTorricoCopali/Documentacon-final.git
    ```
2. Abre el proyecto en tu compilador preferido (Eclipse, IntelliJ o VSCode).
3. Asegúrate de tener instalado el JDK.
4. Ejecuta la clase `Main.java` para iniciar la aplicación.
5. Usa la interfaz gráfica para registrar un usuario, iniciar sesión y gestionar tareas.

### Descripción de Clases

### `InterfazGrafica.java`

- **Propósito**: Gestiona la interfaz gráfica y las interacciones de los usuarios con las tareas.
- **Métodos Clave**:
  - `iniciarSesion()`: Maneja el inicio de sesión de usuarios.
  - `registrarUsuario()`: Permite registrar un nuevo usuario.
  - `mostrarListaDeTareas()`: Muestra la lista de tareas después de iniciar sesión.
  - `añadirTarea()`, `completarTarea()`, `modificarTarea()`, `eliminarTarea()`: Operaciones para gestionar las tareas.
  - `imprimirLista()`: Exporta la lista de tareas a un archivo de texto.

### `ListaDeTareas.java`

- **Propósito**: Gestiona las tareas del usuario, permitiendo agregar, eliminar y guardar tareas.
- **Métodos Clave**:
  - `agregarTarea(Tarea tarea)`: Agrega una nueva tarea.
  - `eliminarTarea(Tarea tarea)`: Elimina una tarea seleccionada.
  - `guardarTareas()`: Guarda la lista de tareas en un archivo.
  - `cargarTareas()`: Carga las tareas desde el archivo guardado del usuario.

### `Tarea.java`

- **Propósito**: Representa una tarea con propiedades como nombre, fecha de vencimiento, prioridad y estado de completado.
- **Propiedades Clave**:
  - `nombreTarea`: El nombre de la tarea.
  - `fechaTarea`: La fecha de vencimiento de la tarea.
  - `prioridadTarea`: Prioridad (Alta, Media, Baja).
  - `estadoCompletada`: Estado de completado de la tarea.

### `Usuario.java`
- **Propósito**: Gestiona la información del usuario y sus interacciones con las tareas.
- **Métodos Clave**:
  - `cargarUsuarios()`: Carga los usuarios desde un archivo.
  - `guardarUsuarios()`: Guarda la información del usuario.

### `Main.java`
- **Propósito**: Punto de entrada de la aplicación. Lanza la interfaz gráfica.
- **Método**: 
  - `main(String[] args)`: Inicializa la GUI.

## Persistencia de Datos

- **Usuarios**: Los datos de los usuarios se guardan en un archivo llamado `usuarios.txt`.
- **Tareas**: Cada usuario tiene un archivo de tareas llamado `<username>_tareas.txt` donde se guardan y cargan las tareas.

## Mejoras Futuras

- Implementar un mecanismo de encriptación de contraseñas para mayor seguridad.
- Agregar categorías o etiquetas a las tareas para una mejor organización.
- Permitir a los usuarios ordenar las tareas por prioridad o fecha de vencimiento.
- Integrar una base de datos para un almacenamiento más escalable.

## Autor

- **Jorge David Torrico Copali**
  -codigo sis: 202200286

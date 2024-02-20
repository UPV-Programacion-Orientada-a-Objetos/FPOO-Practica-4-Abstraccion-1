# Práctica 4 - Abstracción 1

A continuación se presenta el problema de un gestor de biblioteca y hemeroteca. Implemente el sistema de acuerdo a los requerimientos solicitados.


**Nota**

  > Esta práctica de deberá realizar en parejas y utilizando **ramas de git/github*
  >
  >  * Un integrante estará encargado de generar las pruebas unitarias y las prueblas de integración.
  >  * El segundo integrante estará encargado de generar el sistema que cumpla con las pruebas unitarias y con las pruebas de integración.

## Descripción de problema

**Descripción del Problema: Sistema de Gestión de Biblioteca y Hemeroteca con Almacenamiento en Formato CSV**

Una biblioteca y hemeroteca requieren un sistema de gestión para administrar sus recursos y usuarios. Los recursos incluyen libros, diarios, revistas y otras publicaciones periódicas. Los usuarios se dividen en tres categorías: estudiantes, profesores y bibliotecarios. Los estudiantes pueden tomar prestados hasta 3 recursos a la vez, mientras que los profesores pueden tomar prestados hasta 5. Los bibliotecarios son responsables de agregar, modificar y eliminar recursos, así como dar de alta a los otros usuarios. Además, los bibliotecarios pueden listar a los usuarios que tienen préstamos vencidos. Cada recurso tiene un título, un autor y un número de identificación único. Los usuarios pueden buscar recursos por título o autor, y los profesores también pueden agregar nuevos recursos a la biblioteca.

**Requerimientos Funcionales:**

1. **Registro de Usuarios:**
    - Los usuarios (estudiantes, profesores y bibliotecarios) deben poder registrarse en el sistema proporcionando su información personal. Los datos de los usuarios se almacenarán en un archivo CSV.

2. **Agregar Recursos (Bibliotecarios):**
    - Los bibliotecarios deben poder agregar nuevos libros, diarios, revistas y otras publicaciones periódicas al sistema. La información de los recursos se guardará en un archivo CSV.

3. **Modificar Recursos (Bibliotecarios):**
    - Los bibliotecarios deben poder modificar la información de los recursos existentes, como título, autor o número de identificación. Los cambios se reflejarán en el archivo CSV correspondiente.

4. **Eliminar Recursos (Bibliotecarios):**
    - Los bibliotecarios deben poder eliminar recursos del sistema. La información eliminada se actualizará en el archivo CSV.

5. **Buscar Recursos:**
    - Los usuarios deben poder buscar recursos por título o autor. La búsqueda se realizará en el archivo CSV correspondiente.

6. **Préstamo de Recursos:**
    - Los estudiantes pueden tomar prestados hasta 3 recursos a la vez.
    - Los profesores pueden tomar prestados hasta 5 recursos a la vez.
    - Los recursos prestados deben registrarse con la fecha de préstamo y la fecha de vencimiento. Los datos de los préstamos se guardarán en un archivo CSV.

7. **Devolución de Recursos:**
    - Los usuarios deben poder devolver los recursos prestados. La información de devolución se actualizará en el archivo CSV.

8. **Renovación de Préstamos:**
    - Los usuarios pueden renovar el préstamo de un recurso una vez por un período adicional. Los cambios se reflejarán en el archivo CSV.

9. **Listar Usuarios con Préstamos Vencidos (Bibliotecarios):**
    - Los bibliotecarios deben poder generar una lista de usuarios que tienen préstamos vencidos. La lista se obtendrá a partir del archivo CSV de préstamos.

10. **Herencia Abstracta:**
    - Utilizar herencia abstracta para definir una clase base Recurso que contenga atributos comunes como título, autor y número de identificación.
    - Utilizar herencia abstracta para definir una clase base Usuario que contenga los atributos comunes como nombre, apellidos, etc.

11. **Subclases de Recursos**:
    - Crear subclases para representar diferentes tipos de recursos: Libro, Diario, Revista, etc.
    - Crear subclases para representar diferentes tipos de usuarios.

**Requerimientos No Funcionales:**

1. **Usabilidad:**
    - La interfaz de línea de comandos debe ser intuitiva y fácil de usar.
    - Los mensajes de error deben ser claros y descriptivos.

2. **Precisión:**
    - La información almacenada sobre los recursos y los préstamos debe ser precisa y confiable.

3. **Disponibilidad:**
    - El sistema debe estar disponible durante el horario de funcionamiento de la biblioteca y hemeroteca.

4. **Seguridad:**
    - La información de los usuarios y los recursos debe estar protegida contra accesos no autorizados.

5. **Escalabilidad:**
    - El sistema debe manejar un alto volumen de transacciones y usuarios.

6. **Mantenibilidad:**
    - El código debe ser modular y fácil de mantener.

7. **Rendimiento:**
    - El sistema debe responder eficientemente incluso bajo carga.

Este sistema permitirá a la biblioteca y hemeroteca gestionar sus recursos y atender las necesidades de sus usuarios de manera efectiva, con almacenamiento persistente en archivos CSV.

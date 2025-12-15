# Sistema de Organización y Control de Tareas en un Restaurante

## Descripción
Este proyecto implementa un sistema para organizar y controlar las tareas dentro de un restaurante.  
El sistema gestiona **usuarios con diferentes roles** (Administrador, Cocinero, Mesero) y permite la **creación, asignación y seguimiento de tareas**.

## Objetivos
- Facilitar la gestión de tareas en un restaurante.
- Definir roles claros con responsabilidades específicas.
- Permitir la asignación y seguimiento de tareas por parte del administrador.
- Mantener un registro de usuarios y tareas con persistencia en archivos.

## Funcionalidades principales
- Alta de usuarios (Administrador, Cocinero, Mesero).
- Alta de tareas: crear nuevas tareas con título, descripción y asignarlas a un empleado.
- Listado de usuarios y tareas.
- Asignación de tareas por el administrador.
- Gestión de tareas por empleados (consultar, marcar como completadas).

## Instalación y ejecución
1. Clonar el repositorio:
   ```bash
   git clone https://github.com/KevinAlanTC/Proyecto_Final_ICC-Sistema_Restaurante.git
   cd sistema-tareas-restaurante
   ```

2. Compilar el proyecto:
   ```bash
   javac src/**/*.java
   ```

3. Ejecutar:
   ```bash
   java src/Main
   ```

## Contribución
1. Crear una rama de desarrollo:
   ```bash
   git checkout -b dev
   ```
2. Hacer commits claros y descriptivos.

3. Subir cambios:
   ```bash
   git push origin dev
   ```
4. Abrir un Pull Request hacia main cuando el código esté listo.

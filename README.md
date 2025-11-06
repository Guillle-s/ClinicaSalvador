Clínica Salvador – Sistema de Citas Médicas 
👨‍💻 Integrantes

Guillermo José Sierra Román

Laura María Ávila Contreras

Andrés Henríquez Soto

🎯 Objetivo del Proyecto

Desarrollar un sistema de gestión de citas médicas para la Clínica Salvador, aplicando metodologías ágiles Scrum y Kanban, y simulando un entorno colaborativo de desarrollo real.

El propósito principal es construir un sistema funcional que permita registrar, consultar y administrar citas médicas de pacientes, integrando los principios de programación orientada a objetos (POO), conexión a base de datos SQLite, y control de versiones mediante Git y GitHub.

🧱 Descripción del Sistema

El sistema permite realizar las siguientes operaciones:

Registrar una nueva cita médica (paciente, doctor, fecha, hora y motivo).

Consultar las citas agendadas.

Eliminar o modificar una cita.

Conectarse a una base de datos SQLite (clinica.db) para almacenar los registros de forma persistente.

Mostrar la información mediante ventanas interactivas (JOptionPane).

Este desarrollo busca simular un módulo de gestión hospitalaria con una interfaz simple y funcional.

🧩 Arquitectura del Proyecto
Archivo / Clase	Descripción
Conexion.java	Establece la conexión con la base de datos SQLite.
Cita.java	Modelo de datos que representa una cita médica.
CitaDAO.java	Clase encargada de las operaciones CRUD sobre la base de datos.
CitaApp.java	Clase principal del sistema. Contiene el menú e interacción con el usuario mediante JOptionPane.
⚙️ Ejecución del Sistema

Clona o descarga el repositorio.

Abre el proyecto en Visual Studio Code.

Asegúrate de tener el archivo sqlite-jdbc-3.51.0.0.jar en el directorio raíz.

Ejecuta los siguientes comandos:

javac -cp ".;sqlite-jdbc-3.51.0.0.jar" *.java
java -cp ".;sqlite-jdbc-3.51.0.0.jar" CitaApp


Se abrirá un menú con opciones para:

Registrar una cita

Listar todas las citas

Eliminar una cita

Salir del sistema

💼 Metodología Ágil Aplicada

El proyecto se desarrolló aplicando Scrum y Kanban como herramientas de planificación, organización y control del trabajo.

🧑‍💼 Roles Scrum
Rol	Integrante	Función
Scrum Master	Guillermo	Coordina las tareas, asegura la comunicación y elimina bloqueos.
Product Owner	Laura María Ávila	Define los requisitos funcionales y valida el cumplimiento del producto.
Development Team	Andrés Henríquez	Encargado de la implementación del sistema, base de datos y pruebas.
📋 Tablero Kanban (Etapas del Proyecto)
Etapa	Descripción	Estado
Backlog	Definición de requisitos, diseño del sistema.	✅ Completado
To Do	Implementación de las clases base (Conexion, Cita, CitaDAO).	✅ Completado
In Progress	Desarrollo de la interfaz interactiva (CitaApp).	✅ Completado
Testing	Pruebas de conexión y validación de operaciones CRUD.	✅ Completado
Done	Documentación, creación del repositorio y entrega final.	✅ Completado
🧮 Modelo de Base de Datos (SQLite)

Nombre: clinica.db
Tabla: citas

CREATE TABLE IF NOT EXISTS citas (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    paciente TEXT NOT NULL,
    doctor TEXT NOT NULL,
    fecha TEXT NOT NULL,
    hora TEXT NOT NULL,
    motivo TEXT
);

💾 Ejemplo de Ejecución

Entrada (registro de cita):

Paciente: Laura Ávila  
Doctor: Dr. Pérez  
Fecha: 2025-11-06  
Hora: 09:30  
Motivo: Control general


Salida en pantalla:

✅ Cita registrada correctamente.


Al consultar las citas:

Citas registradas:
1. Laura Ávila – Dr. Pérez – 2025-11-06 – 09:30 – Control general

Buenas Prácticas Aplicadas

Código modular siguiendo principios SOLID.

Separación de responsabilidades (DAO, modelo y vista).

Validación de datos antes de guardar.

Conexión a base de datos segura y cerrada tras cada operación.

Control de versiones con GitHub (repositorio: ClinicaSalvador).

Control de Versiones (GitHub)

El proyecto fue gestionado en GitHub para evidenciar:

Historial de commits (cada avance documentado).

Control de versiones del grupo CIPA.

Flujo de trabajo ágil con commits por cada sprint.

Respaldo y trazabilidad del código.

Repositorio oficial:
github.com/Guillle-s/ClinicaSalvador

Conclusión

El desarrollo del sistema Clínica Salvador permitió aplicar metodologías ágiles y principios de desarrollo profesional.
A través de Scrum y Kanban, el equipo logró organizar tareas, distribuir roles y completar entregas en tiempo, simulando un entorno de desarrollo real.

El sistema implementado en Java con conexión SQLite refleja un ejemplo funcional de gestión hospitalaria, combinando diseño limpio, modularidad, y control de versiones con GitHub.
Este proyecto representa una integración exitosa de programación, metodología ágil y trabajo en equipo, cumpliendo los objetivos de la Unidad 4.

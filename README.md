# Sistema de Gestión Alimenticia - TPI Programación 2 

Este proyecto es el Trabajo Práctico Integrador (TPI) para la cátedra de Programación 2. Consiste en un sistema de gestión por consola (CRUD) orientado a la administración de categorías, productos y pedidos, aplicando los principios de la Programación Orientada a Objetos (POO) y persistencia de datos.

## Equipo de Trabajo
* **Chiarello**
* **Ontivero**
* **Oliveros**

## Arquitectura y Tecnologías
El proyecto está desarrollado en **Java** y diseñado utilizando una arquitectura limpia en capas para garantizar la alta cohesión y el bajo acoplamiento:
* **Entities:** Clases de dominio puros (`Categoria`, `Producto`, `Pedido`, etc.).
* **DAO (Data Access Object):** Única capa con acceso a **MySQL** mediante JDBC, encargada de traducir los registros de la base de datos a Colecciones de Java.
* **Service:** Capa intermedia que maneja la lógica de negocio y las validaciones.
* **Main (Menú):** Interfaz de consola interactiva gestionada íntegramente mediante `Scanner`.
* **Exceptions:** Manejo de excepciones personalizadas (ej. `ValidacionEntradaException`).

### Cumplimiento de Rúbrica
*  **Colecciones en memoria:** Los DAOs retornan `List<T>` (ArrayList) para ser manipulados en tiempo de ejecución.
*  **Base de Datos:** Persistencia real utilizando MySQL y `mysql-connector-j-8.x.x`.
*  **Baja Lógica (Soft Delete):** Implementación del campo `eliminado = true/false` en las consultas SQL para no perder el historial.

## Requisitos Previos
Para ejecutar este proyecto en un entorno local, se necesita:
1. **Java Development Kit (JDK)** instalado (Versión 8 o superior).
2. **MySQL Server y Workbench** funcionando.
3. El driver **MySQL Connector/J** (`.jar`) configurado en las dependencias del proyecto.

## Instalación y Ejecución

1. **Clonar el repositorio:**
   ```bash
   git clone [https://github.com/ontivv/TPI-INTEGRADOR-PROGRAMACION-2-CHIARELLO-ONTIVERO-OLIVEROS.git](https://github.com/ontivv/TPI-INTEGRADOR-PROGRAMACION-2-CHIARELLO-ONTIVERO-OLIVEROS.git)
# 🚀 SpeedFast - Sistema Multihilo y Sincronizado de Entregas (MVC + GUI Swing)

![Java](https://img.shields.io/badge/Java-17%2B-orange)
![IDE](https://img.shields.io/badge/IDE-IntelliJ%20IDEA-blue)
![DuocUC](https://img.shields.io/badge/Evaluaci%C3%B3n-Sumativa%20Semana%206-003366)

Proyecto desarrollado para la asignatura **Desarrollo Orientado a Objetos II** de **Duoc UC Online** (Semana 6: *"Diseño de interfaces gráficas con Swing y patrón de arquitectura MVC"*).

La aplicación evoluciona la simulación multihilo previa de **SpeedFast** hacia un entorno visual interactivo, implementando el patrón **Modelo-Vista-Controlador (MVC)**, autenticación con control de acceso por roles y una interfaz gráfica responsiva basada en **Java Swing**.

---

## 📋 Descripción del Caso (Semana 6)

**SpeedFast** integra una capa de presentación visual que permite a los usuarios interactuar de forma intuitiva con el sistema de logística sin perder la potencia de la ejecución concurrente multihilo:

* 🔐 **Autenticación y Roles:** Pantalla de inicio de sesión (`VentanaLogin`) que valida credenciales y restringe funciones según el rol (`Administrador` u `Operador`).
* 📊 **Gestión Visual de Pedidos:** Tabla dinámica (`JTable` con `DefaultTableModel`) en la `VentanaGestionPedidos` que visualiza en tiempo real los elementos agregados a la `ZonaDeCarga`.
* ⚡ **Ejecución Concurrente en GUI:** Integración de `ExecutorService` que ejecuta el proceso multihilo de reparto en segundo plano, evitando el congelamiento de la interfaz de usuario (*Event Dispatch Thread*).

---

## 🛠️ Conceptos y Tecnologías Aplicadas

1. **Patrón de Arquitectura MVC (Modelo-Vista-Controlador):**
    * **Modelo:** Clases de dominio (`Pedido`, `Usuario`, `ZonaDeCarga`, `Repartidor`, `EstadoPedido`, interfaces).
    * **Controlador:** `ControladorUsuarios` (gestión de accesos) y `ControladorPedidos` (intermediario de datos y tabla).
    * **Vista:** Formularios y ventanas gráficas desarrolladas en Java Swing.
2. **Interfaz Gráfica de Usuario (Java Swing):** Uso de `JFrame`, `JTable`, `JComboBox`, `JTextField`, `JPasswordField` y gestores de diseño (`BorderLayout`, `GridLayout`, `FlowLayout`).
3. **Control de Acceso y Roles:** Restricción de acciones en la GUI (el rol `Operador` registra pedidos, mientras que sólo `Administrador` puede disparar el reparto multihilo).
4. **Programación Concurrente y Sincronización:** Recurso compartido seguro (`synchronized`) consumido por hilos `Runnable` administrados vía `ExecutorService` (`FixedThreadPool`).
5. **POO Avanzada:** Aplicación de Abstracción, Herencia, Encapsulamiento, Polimorfismo e Interfaces (`Despachable`, `Cancelable`, `Rastreable`).

---

## 📁 Estructura del Proyecto

```text
semana 6/
 ├── src/
 │    ├── modelo/
 │    │    ├── Cancelable.java        # Interfaz para cancelación
 │    │    ├── Despachable.java       # Interfaz para despacho
 │    │    ├── Rastreable.java        # Interfaz para historial y rastreo
 │    │    ├── EstadoPedido.java      # Enum de estados (PENDIENTE, EN_REPARTO, ENTREGADO)
 │    │    ├── Pedido.java            # Clase base abstracta
 │    │    ├── PedidoComida.java      # Subclase especializada
 │    │    ├── PedidoEncomienda.java  # Subclase especializada
 │    │    ├── PedidoExpress.java     # Subclase especializada
 │    │    ├── PedidoEstandar.java    # Subclase concreta estándar
 │    │    ├── ZonaDeCarga.java       # Recurso compartido sincronizado
 │    │    ├── Repartidor.java        # Tarea ejecutable (Runnable)
 │    │    └── Usuario.java           # Entidad de usuario y permisos
 │    │
 │    ├── controlador/
 │    │    ├── ControladorUsuarios.java # Lógica de autenticación
 │    │    └── ControladorPedidos.java  # Puente entre el modelo y la vista JTable
 │    │
 │    ├── vista/
 │    │    ├── VentanaLogin.java           # Interfaz de inicio de sesión
 │    │    └── VentanaGestionPedidos.java  # Vista principal con JTable y formulario
 │    │
 │    └── Main.java                   # Punto de entrada (SwingUtilities.invokeLater)
 └── README.md                        # Documentación del proyecto

## ⚙️ Requisitos y Entorno de Ejecución

* **JDK:** Java SE 17 o superior.
* **IDE:** IntelliJ IDEA.
* **Control de Versiones:** Git & GitHub.

---

## 📄 Licencia y Créditos

Desarrollado como actividad formativa para **Duoc UC Online** - Carrera de Analista programador computacional. Reservados todos los derechos institucionales.

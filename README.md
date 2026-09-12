# 🚀 SpeedFast - Sistema Multihilo y Sincronizado de Entregas

![Java](https://img.shields.io/badge/Java-17%2B-orange)
![IDE](https://img.shields.io/badge/IDE-IntelliJ%20IDEA-blue)
![DuocUC](https://img.shields.io/badge/Evaluaci%C3%B3n-Sumativa%20Semana%205-003366)

Proyecto desarrollado para la asignatura **Desarrollo Orientado a Objetos II** de **Duoc UC Online** (Semana 5: *"Coordinación de entregas en SpeedFast - Sincronización y Gestión de Hilos"*).

La aplicación simula un sistema de gestión, logística y reparto concurrente en tiempo real para la empresa **SpeedFast**. Integra los pilares de la Programación Orientada a Objetos (**Abstracción**, **Encapsulamiento**, **Herencia**, **Interfaces**, **Polimorfismo**) junto con conceptos avanzados de **Programación Concurrente y Sincronización** (`Thread`, `Runnable`, `synchronized`, `ExecutorService`).

---

## 📋 Descripción del Caso (Semana 5)

**SpeedFast** optimiza y coordina sus entregas mediante un entorno multihilo sincronizado. Para evitar la **condición de carrera** (evitar que dos o más repartidores intenten retirar el mismo paquete simultáneamente), el sistema incorpora una **Zona de Carga** como recurso compartido seguro (*thread-safe*).

Además, los pedidos transitan por un ciclo de vida bien definido representado por un tipo enumerado (`EstadoPedido`), garantizando trazabilidad y consistencia de datos durante toda la operación.

* 📦 **ZonaDeCarga (Recurso Compartido):** Cola sincronizada que administra los pedidos pendientes.
* 🚦 **EstadoPedido (Enum):** Control de transiciones de estado (`PENDIENTE`, `EN_REPARTO`, `ENTREGADO`).
* 🛵 **Repartidor (Tarea Concurrente):** Hilo (`Runnable`) que retira pedidos de forma segura de la zona de carga, simula el tiempo de traslado (`Thread.sleep()`) e informa el avance por consola.
* 🍕 **Subclases de Pedido (`PedidoComida`, `PedidoEncomienda`, `PedidoExpress`, `PedidoEstandar`):** Modelan las distintas especialidades de entregas dentro del sistema.

---

## 🛠️ Conceptos y Tecnologías Aplicadas

1. **Sincronización y Recurso Compartido (`synchronized`):** La clase `ZonaDeCarga` protege el acceso a la cola de pedidos mediante métodos sincronizados (`agregarPedido()` y `retirarPedido()`), evitando condiciones de carrera entre hilos concurrentes.
2. **Control de Estados (`EstadoPedido`):** Uso de un `enum` para garantizar el flujo correcto del ciclo de vida del envío (`PENDIENTE` ➔ `EN_REPARTO` ➔ `ENTREGADO`).
3. **Programación Concurrente (`Runnable`):** La clase `Repartidor` implementa `Runnable` y consume pedidos dinámicamente en un bucle mientras existan entregas pendientes.
4. **Pool de Hilos (`ExecutorService`):** Coordinación eficiente de repartidores simultáneos mediante `Executors.newFixedThreadPool(3)` en `Main.java`, con un cierre controlado vía `shutdown()` y `awaitTermination()`.
5. **Abstracción, Herencia y Polimorfismo:** Mantención de la jerarquía previa con la clase abstracta `Pedido`, sus subclases concretas e interfaces de dominio (`Despachable`, `Cancelable`, `Rastreable`).

---

## 📁 Estructura del Proyecto

```text
semana 5/
 ├── src/
 │    ├── Cancelable.java        # Interfaz para la gestión de cancelaciones
 │    ├── Despachable.java       # Interfaz para la gestión de despachos
 │    ├── Rastreable.java        # Interfaz para trazabilidad de envíos
 │    ├── EstadoPedido.java      # Enum con los estados (PENDIENTE, EN_REPARTO, ENTREGADO)
 │    ├── Pedido.java            # Clase base abstracta con atributo EstadoPedido
 │    ├── PedidoComida.java      # Subclase especializada en pedidos de restaurantes
 │    ├── PedidoEncomienda.java  # Subclase especializada en encomiendas
 │    ├── PedidoExpress.java     # Subclase especializada en compras rápidas
 │    ├── PedidoEstandar.java    # Subclase concreta estándar
 │    ├── ZonaDeCarga.java       # Recurso compartido sincronizado (Queue)
 │    ├── Repartidor.java        # Tarea ejecutable (Runnable) consumidora de ZonaDeCarga
 │    └── Main.java              # Clase principal con ExecutorService y ZonaDeCarga
 └── README.md                   # Documentación del proyecto

## ⚙️ Requisitos y Entorno de Ejecución

* **JDK:** Java SE 17 o superior.
* **IDE:** IntelliJ IDEA.
* **Control de Versiones:** Git & GitHub.

---

## 📄 Licencia y Créditos

Desarrollado como actividad formativa para **Duoc UC Online** - Carrera de Analista programador computacional. Reservados todos los derechos institucionales.

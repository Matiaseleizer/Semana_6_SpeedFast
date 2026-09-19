package modelo;

import java.util.LinkedList;
import java.util.Queue;

public class ZonaDeCarga {

    // Lista interna para almacenar los pedidos pendientes
    private final Queue<Pedido> pedidosPendientes = new LinkedList<>();

    // Método sincronizado para agregar un pedido a la zona de carga
    public synchronized void agregarPedido(Pedido p) {
        pedidosPendientes.add(p);
        System.out.println("modelo.Pedido #" + p.getIdPedido() + " agregado. Destino: " + p.getDireccionEntrega());
    }

    // Método sincronizado para retirar un pedido sin que dos hilos tomen el mismo
    public synchronized Pedido retirarPedido() {
        if (pedidosPendientes.isEmpty()) {
            return null; // Si no hay pedidos, devuelve null
        }
        return pedidosPendientes.poll(); // Retira y retorna el primer pedido
    }

    public synchronized boolean estaVacia() {
        return pedidosPendientes.isEmpty();
    }
}

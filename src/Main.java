

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        System.out.println("[Zona de carga inicializada]");

        ZonaDeCarga zonaDeCarga = new ZonaDeCarga();

        // Creamos instancias de la clase concreta PedidoEstandar
        zonaDeCarga.agregarPedido(new PedidoEstandar(1, "Santiago Centro", 5));
        zonaDeCarga.agregarPedido(new PedidoEstandar(2, "Providencia", 8));
        zonaDeCarga.agregarPedido(new PedidoEstandar(3, "Ñuñoa", 4));
        zonaDeCarga.agregarPedido(new PedidoEstandar(4, "Recoleta", 6));
        zonaDeCarga.agregarPedido(new PedidoEstandar(5, "Las Condes", 12));

        System.out.println();

        // Crear e iniciar el pool de hilos de repartidores
        ExecutorService executor = Executors.newFixedThreadPool(3);

        executor.execute(new Repartidor("Juan", zonaDeCarga));
        executor.execute(new Repartidor("Camila", zonaDeCarga));
        executor.execute(new Repartidor("Pedro", zonaDeCarga));

        executor.shutdown();

        try {
            if (executor.awaitTermination(1, TimeUnit.MINUTES)) {
                System.out.println("\n[Zona de carga vacía]");
                System.out.println("Todos los pedidos han sido entregados correctamente.");
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("La ejecución fue interrumpida.");
        }
    }
}
package modelo;

public class PedidoEstandar extends Pedido {

    public PedidoEstandar(int idPedido, String direccionEntrega, int distanciaKm) {
        super(idPedido, direccionEntrega, distanciaKm);
    }

    @Override
    protected int calcularTiempoEntrega() {
        // Ejemplo: 2 minutos por kilómetro de distancia
        return getDistanciaKm() * 2;
    }
}

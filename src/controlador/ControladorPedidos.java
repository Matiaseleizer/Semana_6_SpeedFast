package controlador;

import modelo.*;
import javax.swing.table.DefaultTableModel;

public class ControladorPedidos {
    private ZonaDeCarga zonaDeCarga;

    public ControladorPedidos(ZonaDeCarga zonaDeCarga) {
        this.zonaDeCarga = zonaDeCarga;
    }

    public void agregarPedidoATabla(Pedido pedido, DefaultTableModel model) {
        zonaDeCarga.agregarPedido(pedido);

        // Determina el tipo de pedido
        String tipo = pedido.getClass().getSimpleName().replace("Pedido", "");

        model.addRow(new Object[]{
                pedido.getIdPedido(),
                tipo,
                pedido.getDireccionEntrega(),
                pedido.getDistanciaKm() + " km",
                pedido.getEstado()
        });
    }

    public ZonaDeCarga getZonaDeCarga() {
        return zonaDeCarga;
    }
}

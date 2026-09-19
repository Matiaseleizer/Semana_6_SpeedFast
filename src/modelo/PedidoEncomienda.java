package modelo;

public class PedidoEncomienda extends Pedido implements Despachable, Cancelable, Rastreable{

    public PedidoEncomienda(int idPedido, String direccionEntrega, int  distanciaKm) {
        super(idPedido, direccionEntrega, distanciaKm);
    }

    @Override
    protected int calcularTiempoEntrega() {
        return (int) (20 + (1.5 * getDistanciaKm()));
    }

    //Sobrescritura del metodo asignarRepartidor
    @Override
    public void asignarRepartidor(){
        this.repartidor = "modelo.Repartidor de encomiendas";
        System.out.println("Se asignó un repartidor de encomiendas para el pedido: #" + getIdPedido());
    }

    //Sobrecarga del metodo asignarRepartidor en la clase modelo.PedidoEncomienda
    public void asignarRepartidor(String nombre){
        this.repartidor = nombre;
        System.out.println("Se asignó a " + nombre + " para la entrega de tu encomienda número #" + getIdPedido());
    }

    //Metodos de las interfaces
    @Override
    public void cancelar(){
        System.out.println("Su encomienda numero #" + getIdPedido() + " ha sido cancelada.");
    }

    @Override
    public void despachar(){
        System.out.println("Su encomienda numero #" + getIdPedido() + " ha salido de nuestro centro de distribución.");
    }

    @Override
    public void verHistorial(){
        System.out.println("Su pedido #" + getIdPedido() + " Ha sido entregado por " + getRepartidor());
    }
}

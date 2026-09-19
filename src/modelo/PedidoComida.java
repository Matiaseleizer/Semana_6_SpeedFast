package modelo;

public class PedidoComida extends Pedido implements Despachable, Cancelable, Rastreable{

    public PedidoComida(int idPedido, String direccionEntrega, int distanciaKm) {
        super(idPedido, direccionEntrega, distanciaKm);
    }

    @Override
    protected int calcularTiempoEntrega() {
        return 15 + (2 * getDistanciaKm());
    }

    //Sobrescritura del metodo asignarRepartidor
    @Override
    public void asignarRepartidor(){
        this.repartidor = "modelo.Repartidor de comida";
        System.out.println("Se asignó un repartidor de comida para el pedido: #" + getIdPedido());
    }

    //Sobrecarga del metodo asignarRepartidor en la clase modelo.PedidoComida
    public void asignarRepartidor(String nombre){
        this.repartidor = nombre;
        System.out.println("Se asignó a " + nombre + " para la entrega de tu pedido número #" + getIdPedido());
    }

    //Metodos de las interfaces
    @Override
    public void cancelar(){
        System.out.println("Su pedido numero #" + getIdPedido() + " ha sido cancelado.");
    }

    @Override
    public void despachar(){
        System.out.println("Su pedido de comida numero #" +  getIdPedido() + " va en camino a su destino.");
    }

    @Override
    public void verHistorial(){
        System.out.println("Su pedido #" + getIdPedido() + " Ha sido entregado por " + getRepartidor());
    }
}

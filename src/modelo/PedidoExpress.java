package modelo;

public class PedidoExpress extends Pedido implements Despachable, Cancelable, Rastreable{

    public PedidoExpress(int idPedido, String direccionEntrega, int distanciaKm) {
        super(idPedido, direccionEntrega, distanciaKm);
    }

    @Override
    protected int calcularTiempoEntrega() {
        if (getDistanciaKm() > 5) {
            return 10 + 5;
        }else{
            return 10 ;
        }
    }

    //Sobreescritura, se asignó el metodo asignarRepartidor a modelo.PedidoExpress
    @Override
    public void asignarRepartidor(){
        this.repartidor = "modelo.Repartidor Express";
        System.out.println("Se asignó un repartidor express para el pedido: #" + getIdPedido());
    }

    //Sobrecarga del metodo asignarRepartidor en la clase modelo.PedidoExpress
    public void asignarRepartidor(String nombre){
        this.repartidor = nombre;
        System.out.println("Se asignó a " + nombre + " para la entrega de tu pedido express #" + getIdPedido());
    }

    //Metodos de las interfaces
    @Override
    public void cancelar(){
        System.out.println("Su pedido #" + getIdPedido() + " ha sido cancelado.");
    }

    @Override
    public void despachar(){
        System.out.println("Su pedido #" + getIdPedido() + " ha sido enviado de manera prioritaria.");
    }

    @Override
    public void verHistorial(){
        System.out.println("Su pedido #" + getIdPedido() + " Ha sido entregado por " + getRepartidor());
    }

}

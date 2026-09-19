package modelo;

public class Usuario {

    //Atributos
    private String nombreUsuario;
    private String contrasena;
    private String rol;

    //Constructor
    public Usuario(String nombreUsuario, String contrasena, String rol){
        this.nombreUsuario = nombreUsuario;
        this.contrasena = contrasena;
        this.rol = rol;
    }

    //Getter and Setter

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public String getRol() {
        return rol;
    }

}

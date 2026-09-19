package controlador;

import modelo.Usuario;
import java.util.ArrayList;
import java.util.List;

public class ControladorUsuarios {

    private List<Usuario> usuarios;

    public ControladorUsuarios() {
        usuarios = new ArrayList<>();

        //Carga de ususarios de prueba en memoria
        usuarios.add(new Usuario("admin", "1234", "Administrador"));
        usuarios.add(new Usuario("operador", "1234", "Operador"));
    }

    public Usuario autenticar(String nombreUsuario, String contrasena){
        for (Usuario u : usuarios){
            if (u.getNombreUsuario().equals(nombreUsuario) && u.getContrasena().equals(contrasena)){
                return u;
            }
        }
        return null;
    }
}

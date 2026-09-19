import controlador.ControladorUsuarios;
import modelo.ZonaDeCarga;
import vista.VentanaLogin;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        // Ejecución segura de la GUI en el hilo de eventos de Swing
        SwingUtilities.invokeLater(() -> {
            ZonaDeCarga zonaDeCarga = new ZonaDeCarga();
            ControladorUsuarios controladorUsuarios = new ControladorUsuarios();

            // Iniciar la aplicación desde el Login
            VentanaLogin login = new VentanaLogin(controladorUsuarios, zonaDeCarga);
            login.setVisible(true);
        });
    }
}
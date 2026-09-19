package vista;

import controlador.ControladorUsuarios;
import controlador.ControladorPedidos;
import modelo.Usuario;
import modelo.ZonaDeCarga;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaLogin extends JFrame {

    // Componentes de la interfaz
    private JTextField txtUsuario;
    private JPasswordField txtContrasena;
    private JButton btnIngresar;
    private JButton btnSalir;

    // Controladores y Modelo
    private ControladorUsuarios controladorUsuarios;
    private ZonaDeCarga zonaDeCarga;

    public VentanaLogin(ControladorUsuarios controladorUsuarios, ZonaDeCarga zonaDeCarga) {
        this.controladorUsuarios = controladorUsuarios;
        this.zonaDeCarga = zonaDeCarga;

        // Configuración básica de la ventana
        setTitle("Sistema de Envíos - Iniciar Sesión");
        setSize(350, 220);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Centra la ventana en la pantalla
        setResizable(false);

        // Construir la interfaz gráfica
        inicializarComponentes();
    }

    private void inicializarComponentes() {
        // Panel principal con margen de bordes
        JPanel panel = new JPanel(new GridLayout(3, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Componentes de formulario
        JLabel lblUsuario = new JLabel("Usuario:");
        txtUsuario = new JTextField();

        JLabel lblContrasenia = new JLabel("Contraseña:");
        txtContrasena = new JPasswordField();

        btnIngresar = new JButton("Ingresar");
        btnSalir = new JButton("Salir");

        // Agregar componentes al panel
        panel.add(lblUsuario);
        panel.add(txtUsuario);
        panel.add(lblContrasenia);
        panel.add(txtContrasena);
        panel.add(btnIngresar);
        panel.add(btnSalir);

        add(panel);

        // Manejo de eventos de los botones
        btnIngresar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                procesarLogin();
            }
        });

        btnSalir.addActionListener(e -> System.exit(0));
    }

    private void procesarLogin() {
        String usuario = txtUsuario.getText().trim();
        String contrasenia = new String(txtContrasena.getPassword());

        // Validar que los campos no estén vacíos
        if (usuario.isEmpty() || contrasenia.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                    "Por favor, complete todos los campos.",
                    "Campos Incompletos",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }

        // Autenticar mediante el controlador
        Usuario usuarioAutenticado = controladorUsuarios.autenticar(usuario, contrasenia);

        if (usuarioAutenticado != null) {
            JOptionPane.showMessageDialog(this,
                    "¡Bienvenido, " + usuarioAutenticado.getNombreUsuario() + "!\nRol: " + usuarioAutenticado.getRol(),
                    "Acceso Concedido",
                    JOptionPane.INFORMATION_MESSAGE);

            // Crear el controlador de pedidos e instanciar la ventana principal
            ControladorPedidos controladorPedidos = new ControladorPedidos(zonaDeCarga);
            VentanaGestionPedidos ventanaPrincipal = new VentanaGestionPedidos(usuarioAutenticado, controladorPedidos);
            ventanaPrincipal.setVisible(true);

            // Cierra la ventana de Login
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(this,
                    "Usuario o contraseña incorrectos.",
                    "Error de Autenticación",
                    JOptionPane.ERROR_MESSAGE);
            txtContrasena.setText(""); // Limpiar la contraseña
        }
    }
}

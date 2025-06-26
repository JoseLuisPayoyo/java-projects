import com.formdev.flatlaf.FlatDarculaLaf;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginForm extends JFrame{
    private JPanel panelPrincipal;
    private JTextField usuarioTexto;
    private JPasswordField textoPassword;
    private JButton button;

    public LoginForm(){
        inicializarFormulario();
        button.addActionListener(e -> validar());
    }

    private void inicializarFormulario(){
        setContentPane(panelPrincipal);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 600);
        setLocationRelativeTo(null);
    }

    private void validar(){
        //Leer los valores
        var usuario = this.usuarioTexto.getText();
        var password = new String(this.textoPassword.getPassword());

        if (usuario.equals("root") && password.equals("admin")){
            mostrarMensaje("Datos correctos, bienvenido");
        } else if (!usuario.equals("root")) {
            mostrarMensaje("Usuario incorrecto");
        } else if (!password.equals("admin")) {
            mostrarMensaje("Contraseña incorrecta");
        } else{
            mostrarMensaje("Usuario y contraseña incorrectos");
        }
    }

    private void mostrarMensaje(String mensaje){
        JOptionPane.showMessageDialog(this, mensaje);
    }

    public static void main(String[] args) {
        FlatDarculaLaf.setup();
        LoginForm login = new LoginForm();
        login.setVisible(true);
    }
}

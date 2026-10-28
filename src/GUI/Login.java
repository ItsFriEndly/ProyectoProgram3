package GUI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Login extends JFrame{
	
	public Login() {
		
		setTitle("GeTicket - IniciarSesion");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(500,500);
		setLocationRelativeTo(null);
		
		JPanel panelPrincipal = new JPanel(new BorderLayout());
		setContentPane(panelPrincipal);
		
		// Titulo de inicio de sesion
		JLabel titulo = new JLabel("INICIAR SESION");
		titulo.setHorizontalAlignment(SwingConstants.CENTER);
		titulo.setFont(new Font("Arial", Font.BOLD, 22));
		panelPrincipal.add(titulo, BorderLayout.NORTH);
		
		
		JPanel panelDatos = new JPanel(new GridLayout(2,2,10,10));
		JPanel panelContenedor = new JPanel(new GridBagLayout());
		//Correo
		panelDatos.add(new JLabel("Correo:"));
		JTextField correo = new JTextField();
		panelDatos.add(correo);
		// Contraseña
		panelDatos.add(new JLabel("Contraseña:"));
		JPasswordField contrasena = new JPasswordField();
		panelDatos.add(contrasena);
		panelDatos.setPreferredSize(new Dimension(400, 65));
		panelContenedor.add(panelDatos);
		panelPrincipal.add(panelContenedor, BorderLayout.CENTER);
		
		
		JPanel panelBoton = new JPanel(new FlowLayout());
		JButton botonLogin = new JButton("INICIAR SESION");
		botonLogin.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				GUI.inicializar();
				dispose();
				
			}
		});
		panelBoton.add(botonLogin);
		JButton botonRegistro = new JButton("REGISTRARSE");
		panelBoton.add(botonRegistro);
		panelPrincipal.add(panelBoton, BorderLayout.SOUTH);
		
		
		setVisible(true);
	}
	
	public static void main(String[] args) {
	    new Login();
	}

}

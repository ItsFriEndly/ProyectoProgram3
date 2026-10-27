package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.ScrollPane;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import ClasesBase.TipoEntrada;

public class GUI {
	
	public static void main(String[] args) {
		
		inicializar();
	}
	
	public static void inicializar() {
		
		// Ventana
		JFrame frame = new JFrame();
		frame.setTitle("GeTicket");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(300, 150, 900, 600);
		JPanel mainContentPanel = new JPanel();
		mainContentPanel.setLayout(new BorderLayout());
		mainContentPanel.setOpaque(true);
		frame.add(mainContentPanel);
		
		// Barra Lateral Izquierda
		JPanel toolPanel = new JPanel();
		toolPanel.setLayout(new GridBagLayout());
		toolPanel.setBackground(new Color(24, 43, 73));
		toolPanel.setOpaque(true);
		toolPanel.setBorder(BorderFactory.createLineBorder(new Color(53, 79, 114), 3));
		toolPanel.setPreferredSize(new Dimension(125, 0));
		mainContentPanel.add(toolPanel, BorderLayout.WEST);
		
		JButton botonEventos = new JButton("Eventos");
		botonEventos.setBackground(Color.WHITE);
		botonEventos.setForeground(Color.BLACK);
		JButton botonCuenta = new JButton("Cuenta");
		botonCuenta.setBackground(Color.WHITE);
		botonCuenta.setForeground(Color.BLACK);
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.insets = new Insets(20, 20, 20, 20);
		toolPanel.add(botonEventos, gbc);
		toolPanel.add(botonCuenta, gbc);
		
		// Panel Centro
		JPanel centerPanel = new JPanel();
		centerPanel.setBackground(Color.LIGHT_GRAY);
		centerPanel.setOpaque(true);
		ScrollPane scrollPane = new ScrollPane();
		centerPanel.add(scrollPane, BorderLayout.CENTER);
		mainContentPanel.add(centerPanel, BorderLayout.CENTER);
		
		// Barra Lateral Derecha
		JPanel ticketPanel = new JPanel();
		ticketPanel.setLayout(new GridLayout(2, 1, 0, 0));
		ticketPanel.setOpaque(true);
		ticketPanel.setBackground(Color.GRAY);
		ticketPanel.setPreferredSize(new Dimension(250, 600));
		
		JPanel panelDatos = new JPanel(new GridLayout(3, 2, 25, 25));
		panelDatos.setOpaque(true);
		panelDatos.setBorder(new EmptyBorder(25, 25, 25, 25));
		panelDatos.add(new JLabel("Email:"));
		JTextField email = new JTextField();
		panelDatos.add(email);
		panelDatos.add(new JLabel("Telefono:"));
		JTextField tlf = new JTextField();
		panelDatos.add(tlf);
		panelDatos.add(new JLabel("Tipo Entrada:"));
		JComboBox<TipoEntrada> tipo = new JComboBox<TipoEntrada>(TipoEntrada.values());
		panelDatos.add(tipo);
		
		JPanel panelBoton = new JPanel();
		panelBoton.setOpaque(true);
		JButton botonComprar = new JButton("Comprar");
		panelBoton.add(botonComprar);
		
		ticketPanel.add(panelDatos);
		ticketPanel.add(panelBoton);
		mainContentPanel.add(ticketPanel, BorderLayout.EAST);
		
		frame.setVisible(true);
		
	}
}

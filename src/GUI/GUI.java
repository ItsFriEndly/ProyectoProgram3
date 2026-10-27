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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import ClasesBase.Evento;
import ClasesBase.TipoEntrada;
import ClasesBase.Venue;
import Datos.DatosPrueba;

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
		JPanel centerPanel = new JPanel(new BorderLayout());
		centerPanel.setBackground(Color.LIGHT_GRAY);
		mainContentPanel.add(centerPanel, BorderLayout.CENTER);
		
		// Table de Eventos
		JLabel tituloEventos = new JLabel("EVENTOS DISPONIBLES");
		tituloEventos.setHorizontalAlignment(SwingConstants.CENTER);
		centerPanel.add(tituloEventos, BorderLayout.NORTH);
		ArrayList<Evento> listaEventos = DatosPrueba.cargarEventos();
		ModeloTablaEventos modeloTabla = new ModeloTablaEventos(listaEventos);
		JTable tablaEventos = new JTable(modeloTabla);
		tablaEventos.getColumnModel().getColumn(0).setPreferredWidth(45);
		tablaEventos.getColumnModel().getColumn(1).setPreferredWidth(180);
		tablaEventos.getColumnModel().getColumn(2).setPreferredWidth(90);
		tablaEventos.getColumnModel().getColumn(3).setPreferredWidth(90);
		tablaEventos.getColumnModel().getColumn(4).setPreferredWidth(150);

		tablaEventos.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		JScrollPane scrollTabla = new JScrollPane(tablaEventos);
		centerPanel.add(scrollTabla, BorderLayout.CENTER);

		
		// Barra Lateral Derecha
		JPanel ticketPanel = new JPanel();
		ticketPanel.setLayout(new GridLayout(2, 1, 0, 0));
		ticketPanel.setOpaque(true);
		ticketPanel.setBackground(Color.GRAY);
		ticketPanel.setPreferredSize(new Dimension(350, 500));
		
		JPanel panelDatos = new JPanel(new GridLayout(4, 2, 25, 25));
		panelDatos.setOpaque(true);
		panelDatos.setBorder(new EmptyBorder(25, 25, 25, 25));
		// Evento seleccionado
		panelDatos.add(new JLabel("Evento:"));
		JTextField campoEvento = new JTextField();
		campoEvento.setEditable(false);
		panelDatos.add(campoEvento);
		panelDatos.add(new JLabel("Email:"));
		JTextField email = new JTextField();
		panelDatos.add(email);
		panelDatos.add(new JLabel("Telefono:"));
		JTextField tlf = new JTextField();
		panelDatos.add(tlf);
		// Comprobar telefono
		tlf.addKeyListener(new KeyAdapter() {

		    @Override
		    public void keyTyped(KeyEvent e) {
		        char caracter = e.getKeyChar();
		        if (!Character.isDigit(caracter) && !Character.isISOControl(caracter)) {
		            e.consume();
		        }
		    }
		});
		panelDatos.add(new JLabel("Tipo Entrada:"));
		JComboBox<TipoEntrada> tipo = new JComboBox<TipoEntrada>(TipoEntrada.values());
		panelDatos.add(tipo);
		
		JPanel panelBoton = new JPanel();
		panelBoton.setOpaque(true);
		JButton botonComprar = new JButton("Comprar");
		panelBoton.add(botonComprar);
		botonComprar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// Comprobar seleccion
				if (tablaEventos.getSelectedRow() == -1) {
				    JOptionPane.showMessageDialog(frame, "Selecciona un evento primero");
				    return;
				}
				// Comprobar correo
				if (email.getText().isEmpty() || tlf.getText().isEmpty()) {
				    JOptionPane.showMessageDialog(frame, "Introduce el email y el telefono");
				    return;
				}
				String correo = email.getText();

				if (!correo.contains("@") || !correo.contains(".")) {
				    JOptionPane.showMessageDialog(frame, "Introduce un email valido");
				    return;
				}
				// Comprobar telefono
				String telefono = tlf.getText();

				if (!telefono.matches("[0-9]{9}")) {
				    JOptionPane.showMessageDialog(frame, "El telefono debe tener 9 numeros");
				    return;
				}
				String nombreEvento = campoEvento.getText();
				TipoEntrada tipoSeleccionado = (TipoEntrada) tipo.getSelectedItem();

				JOptionPane.showMessageDialog(frame,
				        "Compra realizada correctamente\n"
				        + "Evento: " + nombreEvento + "\n"
				        + "Email: " + correo + "\n"
				        + "Telefono: " + telefono + "\n"
				        + "Tipo de entrada: " + tipoSeleccionado);
				
				
				
			}
		});
		
		ticketPanel.add(panelDatos);
		ticketPanel.add(panelBoton);
		mainContentPanel.add(ticketPanel, BorderLayout.EAST);
		
		
		
		tablaEventos.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				
				int fila = tablaEventos.getSelectedRow();
		        if (fila != -1) {
		            Evento eventoSeleccionado = listaEventos.get(fila);
		            campoEvento.setText(eventoSeleccionado.getNombre());
		        }
				
			}
		});
		
		
		frame.setVisible(true);
		
	}
}

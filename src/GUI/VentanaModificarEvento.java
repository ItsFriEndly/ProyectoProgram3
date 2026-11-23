package GUI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import ClasesBase.Evento;
import ClasesBase.TipoEvento;
import ClasesBase.Venue;

public class VentanaModificarEvento extends JFrame{
	
	 public VentanaModificarEvento(Evento evento, ModeloTablaEventos modelo, ArrayList<Evento> eventos) {

	        setTitle("GeTicket - Modificar evento");
	        setSize(500, 400);
	        setLocationRelativeTo(null);
	        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

	        setLayout(new BorderLayout());

	        JLabel titulo = new JLabel("MODIFICAR EVENTO");
	        titulo.setHorizontalAlignment(SwingConstants.CENTER);

	        add(titulo, BorderLayout.NORTH);
	        
	        // Panel con los datos del evento
	        JPanel panelDatos = new JPanel(new GridLayout(5, 2, 10, 10));
	        panelDatos.setPreferredSize(new Dimension(400, 190));

	        // ID
	        panelDatos.add(new JLabel("ID:"));
	        JTextField campoId = new JTextField(evento.getId());
	        campoId.setEditable(false);
	        panelDatos.add(campoId);

	        // Nombre
	        panelDatos.add(new JLabel("Nombre:"));
	        JTextField campoNombre = new JTextField(evento.getNombre());
	        panelDatos.add(campoNombre);

	        // Fecha
	        panelDatos.add(new JLabel("Fecha (AAAA-MM-DD):"));
	        JTextField campoFecha = new JTextField(evento.getFecha().toString());
	        panelDatos.add(campoFecha);

	        // Tipo
	        panelDatos.add(new JLabel("Tipo:"));
	        JComboBox<TipoEvento> comboTipo = new JComboBox<>(TipoEvento.values());
	        comboTipo.setSelectedItem(evento.getTipo());
	        panelDatos.add(comboTipo);

	        // Centrar el formulario
	        JPanel panelContenedor = new JPanel(new GridBagLayout());
	        panelContenedor.add(panelDatos);
	        
	        // Recinto
	        panelDatos.add(new JLabel("Recinto:"));
	        JComboBox<String> comboRecinto = new JComboBox<>();
	        comboRecinto.addItem("Bilbao Arena");
	        comboRecinto.addItem("San Mames");
	        comboRecinto.addItem("BEC");
	        comboRecinto.addItem("WiZink Center");
	        comboRecinto.addItem("Anoeta");
	        comboRecinto.addItem("Kursaal");
	        comboRecinto.addItem("Mendizorrotza");
	        comboRecinto.addItem("Palacio Euskalduna");
	        comboRecinto.addItem("Buesa Arena");
	        comboRecinto.addItem("Kobetamendi");

	        // Selecciona el recinto actual del evento
	        comboRecinto.setSelectedItem(evento.getVenue().getNombre());
	        panelDatos.add(comboRecinto);

	        add(panelContenedor, BorderLayout.CENTER);
	        
	        
	        // Panel de botones
	        JPanel panelBotones = new JPanel(new FlowLayout());
	        JButton botonGuardar = new JButton("GUARDAR CAMBIOS");
	        panelBotones.add(botonGuardar);
	        add(panelBotones, BorderLayout.SOUTH);
	        botonGuardar.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					 String nombre = campoNombre.getText().trim();
				        String fecha = campoFecha.getText().trim();
				        TipoEvento tipo = (TipoEvento) comboTipo.getSelectedItem();
				        String nombreRecinto = (String) comboRecinto.getSelectedItem();

				        // Comprobar campos vacíos
				        if (nombre.isEmpty() || fecha.isEmpty()) {
				            JOptionPane.showMessageDialog(null, "Rellena todos los campos");
				            return;
				        }

				        // Buscar el recinto seleccionado
				        Venue recinto = null;

				        for (Evento ev : eventos) {
				            if (ev.getVenue().getNombre().equals(nombreRecinto)) {
				                recinto = ev.getVenue();
				                break;
				            }
				        }

				        if (recinto == null) {
				            JOptionPane.showMessageDialog(null, "Recinto no encontrado");
				            return;
				        }

				        try {
				            LocalDate fechaNueva = LocalDate.parse(fecha);

				            // Modificar el evento
				            evento.setNombre(nombre);
				            evento.setFecha(fechaNueva);
				            evento.setTipo(tipo);
				            evento.setVenue(recinto);

				            // Actualizar la tabla
				            modelo.fireTableDataChanged();

				            JOptionPane.showMessageDialog(null, "Evento modificado correctamente");

				            dispose();

				        } catch (DateTimeParseException ex) {
				            JOptionPane.showMessageDialog(null, "La fecha debe tener el formato AAAA-MM-DD");
				        }
				    
					
				}
			});

	        setVisible(true);
	    }

}

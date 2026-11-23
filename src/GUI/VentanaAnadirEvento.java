package GUI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
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

public class VentanaAnadirEvento extends JFrame{
		public VentanaAnadirEvento(ArrayList<Evento> eventos, ModeloTablaEventos modelo) {

			setTitle("GeTicket - Añadir evento");
			setSize(500, 400);
			setLocationRelativeTo(null);
			setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

			setLayout(new BorderLayout());

			JLabel titulo = new JLabel("AÑADIR EVENTO");
			titulo.setHorizontalAlignment(SwingConstants.CENTER);

			add(titulo, BorderLayout.NORTH);
			
			// Panel con los datos del evento
			JPanel panelDatos = new JPanel(new GridLayout(5, 2, 10, 10));
			panelDatos.setPreferredSize(new Dimension(400, 190));

			// ID
			panelDatos.add(new JLabel("ID: "));
			JTextField campoId = new JTextField("E");
			panelDatos.add(campoId);

			// Nombre
			panelDatos.add(new JLabel("Nombre:"));
			JTextField campoNombre = new JTextField();
			panelDatos.add(campoNombre);

			// Fecha
			panelDatos.add(new JLabel("Fecha (AAAA-MM-DD):"));
			JTextField campoFecha = new JTextField();
			panelDatos.add(campoFecha);

			// Tipo de evento
			panelDatos.add(new JLabel("Tipo:"));
			JComboBox<TipoEvento> comboTipo = new JComboBox<>(TipoEvento.values());
			panelDatos.add(comboTipo);
			
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
			panelDatos.add(comboRecinto);
			
			JPanel panelContenedor = new JPanel(new GridBagLayout());
			panelContenedor.add(panelDatos);
			add(panelContenedor, BorderLayout.CENTER);
			
			// Panel de botones
			JPanel panelBotones = new JPanel(new FlowLayout());
			JButton botonGuardar = new JButton("GUARDAR EVENTO");
			panelBotones.add(botonGuardar);
			add(panelBotones, BorderLayout.SOUTH);
			
			botonGuardar.addActionListener(new ActionListener() {
			    @Override
			    public void actionPerformed(ActionEvent e) {
			        String id = campoId.getText();
			        String nombre = campoNombre.getText();
			        String fecha = campoFecha.getText();
			        TipoEvento tipo = (TipoEvento) comboTipo.getSelectedItem();
			        
			     // Comprobar que los campos no estén vacíos
			        if (id.isEmpty() || nombre.isEmpty() || fecha.isEmpty()) {
			            JOptionPane.showMessageDialog(null, "Rellena todos los campos");
			            return;
			        }

			        // Comprobar que el ID no esté repetido
			        for (Evento ev : eventos) {
			            if (ev.getId().equals(id)) {
			                JOptionPane.showMessageDialog(null, "Ya existe un evento con ese ID");
			                return;
			            }
			        }

			        // Buscar el recinto seleccionado
			        String nombreRecinto = (String) comboRecinto.getSelectedItem();
			        Venue recinto = null;

			        for (Evento ev : eventos) {
			            if (ev.getVenue().getNombre().equals(nombreRecinto)) {
			                recinto = ev.getVenue();
			                break;
			            }
			        }

			        if (recinto == null) {
			            JOptionPane.showMessageDialog(null, "No se ha encontrado el recinto");
			            return;
			        }

			        // Crear y guardar el evento
			        try {
			            LocalDate fechaEvento = LocalDate.parse(fecha);

			            Evento nuevoEvento = new Evento(id, nombre, fechaEvento, tipo, recinto);

			            eventos.add(nuevoEvento);
			            modelo.fireTableDataChanged();

			            JOptionPane.showMessageDialog(null, "Evento añadido correctamente");
			            dispose();

			        } catch (Exception ex) {
			            JOptionPane.showMessageDialog(null, "La fecha debe tener el formato AAAA-MM-DD");
			        }

			    }
			});

			setVisible(true);
    }


}

package GUI;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;

import ClasesBase.Evento;
import Datos.DatosPrueba;

public class GestionEventos extends JFrame{
	
	public GestionEventos() {
        setTitle("GeTicket - Gestión de eventos");
        setSize(900, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLayout(new BorderLayout());

        JLabel titulo = new JLabel("GESTIÓN DE EVENTOS");
        titulo.setHorizontalAlignment(SwingConstants.CENTER);

        add(titulo, BorderLayout.NORTH);
        
        // Panel de botones
        JPanel panelBotones = new JPanel(new FlowLayout());

        JButton botonAnadir = new JButton("AÑADIR");
        JButton botonModificar = new JButton("MODIFICAR");
        JButton botonEliminar = new JButton("ELIMINAR");

        panelBotones.add(botonAnadir);
        panelBotones.add(botonModificar);
        panelBotones.add(botonEliminar);

        add(panelBotones, BorderLayout.SOUTH);
        
        
        // Cargar los eventos
        ArrayList<Evento> eventos = DatosPrueba.cargarEventos();

        // Crear la tabla
        ModeloTablaEventos modelo = new ModeloTablaEventos(eventos);
        JTable tablaEventos = new JTable(modelo);
        
        // Boton anadir
        botonAnadir.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new VentanaAnadirEvento(eventos, modelo);
			}
		});
        
        // Boton eliminar
        botonEliminar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				 int fila = tablaEventos.getSelectedRow();
			     if (fila == -1) {
			    	 
			         JOptionPane.showMessageDialog(null, "Selecciona un evento");
			         return;
			     }
			     int respuesta = JOptionPane.showConfirmDialog(null, "¿Quieres eliminar este evento?", "Confirmar eliminación", JOptionPane.YES_NO_OPTION);

			     if (respuesta == JOptionPane.YES_OPTION) {
			         eventos.remove(fila);
			         modelo.fireTableDataChanged();
			         JOptionPane.showMessageDialog(null, "Evento eliminado correctamente");
			     }
				
			}
		});
        
        // Boton modificar
        botonModificar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
		        int fila = tablaEventos.getSelectedRow();
		        if (fila == -1) {
		            JOptionPane.showMessageDialog(null, "Selecciona un evento");
		            return;
		        }
		        Evento eventoSeleccionado = eventos.get(fila);
		        new VentanaModificarEvento(eventoSeleccionado, modelo, eventos);
		    
				
			}
		});

        // Añadir la barra de desplazamiento
        JScrollPane scroll = new JScrollPane(tablaEventos);
        add(scroll, BorderLayout.CENTER);

        setVisible(true);
	}

}

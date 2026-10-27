package GUI;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import ClasesBase.Evento;

public class ModeloTablaEventos extends AbstractTableModel {
	
	private static final long serialVersionUID = 1L;
	private ArrayList<Evento> eventos;
	private String[] columnas = {"ID", "Nombre", "Fecha", "Tipo", "Venue"};
	
	// Constructor
	public ModeloTablaEventos(ArrayList<Evento> eventos) {
	    this.eventos = eventos;
	}

	@Override
	public int getRowCount() {
		return eventos.size();
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return columnas.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
	    Evento evento = eventos.get(rowIndex);
	    switch (columnIndex) {
	    case 0:
	        return evento.getId();
	    case 1:
	        return evento.getNombre();
	    case 2:
	        return evento.getFecha();
	    case 3:
	        return evento.getTipo();
	    case 4:
	        return evento.getVenue().getNombre();
	    default:
	        return null;
	    }
	}

	@Override
	public String getColumnName(int column) {
		return columnas[column];
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return false;
	}
	
	

}

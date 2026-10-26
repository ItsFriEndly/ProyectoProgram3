package ClasesBase;

import java.time.LocalDate;
import java.util.Objects;

public class Evento {
	
	private String id;
	private String nombre;
	private LocalDate fecha;
	private TipoEvento tipo;
	private Venue venue;
	
	public Evento(String id, String nombre, LocalDate fecha, TipoEvento tipo, Venue venue) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.fecha = fecha;
		this.tipo = tipo;
		this.venue = venue;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public TipoEvento getTipo() {
		return tipo;
	}

	public void setTipo(TipoEvento tipo) {
		this.tipo = tipo;
	}

	public Venue getVenue() {
		return venue;
	}

	public void setVenue(Venue venue) {
		this.venue = venue;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Evento other = (Evento) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Evento [id=" + id + ", nombre=" + nombre + ", fecha=" + fecha + ", tipo=" + tipo + ", venue=" + venue
				+ "]";
	}
	
}

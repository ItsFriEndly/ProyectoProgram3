package ClasesBase;

import java.util.Objects;

public class Venue {

	private String id;
	private String nombre;
	private int aforo;
	
	public Venue(String id, String nombre, int aforo) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.aforo = aforo;
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
	public int getAforo() {
		return aforo;
	}
	public void setAforo(int aforo) {
		this.aforo = aforo;
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
		Venue other = (Venue) obj;
		return Objects.equals(id, other.id);
	}
	
	@Override
	public String toString() {
		return "Venue [id=" + id + ", nombre=" + nombre + ", aforo=" + aforo + "]";
	}
	
	
	
	
}

package ClasesBase;

import java.util.Objects;

public class Entrada {

		private String id;
		private Evento evento;
		private TipoEntrada tipo;
		private String email;
		private String tlf;
		
		public Entrada(String id, Evento evento, String email, String tlf) {
			super();
			this.id = id;
			this.evento = evento;
			this.email = email;
			this.tlf = tlf;
		}
		public String getId() {
			return id;
		}
		public void setId(String id) {
			this.id = id;
		}
		public Evento getEvento() {
			return evento;
		}
		public void setEvento(Evento evento) {
			this.evento = evento;
		}
		public TipoEntrada getTipo() {
			return tipo;
		}
		public void setTipo(TipoEntrada tipo) {
			this.tipo = tipo;
		}
		public String getEmail() {
			return email;
		}
		public void setDni(String email) {
			this.email = email;
		}
		public String getTlf() {
			return tlf;
		}
		public void setTlf(String tlf) {
			this.tlf = tlf;
		}
		
		@Override
		public int hashCode() {
			return Objects.hash(evento, id);
		}
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Entrada other = (Entrada) obj;
			return Objects.equals(evento, other.evento) && Objects.equals(id, other.id);
		}
		
		@Override
		public String toString() {
			return "Entrada [id=" + id + ", evento=" + evento + ", email=" + email + ", tlf=" + tlf + ", tipo=" + tipo + "]";
		}
		
}

package Datos;

import java.util.ArrayList;
import ClasesBase.Evento;
import ClasesBase.Venue;
import ClasesBase.TipoEvento;
import java.time.LocalDate;

public class DatosPrueba {
	
	// Cargar eventos de prueba
	public static ArrayList<Evento> cargarEventos() {
	    ArrayList<Evento> listaEventos = new ArrayList<Evento>();
	    
	    // GENERADO CON IA
        // Recintos
        Venue venue1 = new Venue("V001", "Bilbao Arena", 10000);
        Venue venue2 = new Venue("V002", "San Mames", 53000);
        Venue venue3 = new Venue("V003", "BEC", 18000);
        Venue venue4 = new Venue("V004", "WiZink Center", 17000);
        Venue venue5 = new Venue("V005", "Anoeta", 39000);
        Venue venue6 = new Venue("V006", "Kursaal", 1800);
        Venue venue7 = new Venue("V007", "Mendizorrotza", 19000);
        Venue venue8 = new Venue("V008", "Palacio Euskalduna", 2100);
        Venue venue9 = new Venue("V009", "Buesa Arena", 15000);
        Venue venue10 = new Venue("V010", "Kobetamendi", 40000);

        // Eventos
        listaEventos.add(new Evento("E001", "Concierto de Rock", LocalDate.of(2026, 11, 15), TipoEvento.CONCIERTO, venue1));
        listaEventos.add(new Evento("E002", "Athletic vs Barcelona", LocalDate.of(2026, 11, 21), TipoEvento.DEPORTIVO, venue2));
        listaEventos.add(new Evento("E003", "Festival de Musica", LocalDate.of(2026, 12, 5), TipoEvento.FESTIVAL, venue3));
        listaEventos.add(new Evento("E004", "Concierto de Pop", LocalDate.of(2026, 12, 12), TipoEvento.CONCIERTO, venue4));
        listaEventos.add(new Evento("E005", "Real Sociedad vs Madrid", LocalDate.of(2026, 12, 20), TipoEvento.DEPORTIVO, venue5));
        listaEventos.add(new Evento("E006", "Festival de Jazz", LocalDate.of(2027, 1, 10), TipoEvento.FESTIVAL, venue6));
        listaEventos.add(new Evento("E007", "Alaves vs Valencia", LocalDate.of(2027, 1, 17), TipoEvento.DEPORTIVO, venue7));
        listaEventos.add(new Evento("E008", "Concierto de Musica Clasica", LocalDate.of(2027, 1, 25), TipoEvento.CONCIERTO, venue8));
        listaEventos.add(new Evento("E009", "Baskonia vs Barcelona", LocalDate.of(2027, 2, 6), TipoEvento.DEPORTIVO, venue9));
        listaEventos.add(new Evento("E010", "Bilbao BBK Live", LocalDate.of(2027, 7, 8), TipoEvento.FESTIVAL, venue10));
        listaEventos.add(new Evento("E011", "Feria del Videojuego", LocalDate.of(2027, 2, 13), TipoEvento.FERIA, venue3));
        listaEventos.add(new Evento("E012", "Concierto de Rap", LocalDate.of(2027, 2, 20), TipoEvento.CONCIERTO, venue1));
        listaEventos.add(new Evento("E013", "Feria de Tecnologia", LocalDate.of(2027, 3, 5), TipoEvento.FERIA, venue3));
        listaEventos.add(new Evento("E014", "Festival de Cine", LocalDate.of(2027, 3, 12), TipoEvento.FESTIVAL, venue6));
        listaEventos.add(new Evento("E015", "Concierto de Reggaeton", LocalDate.of(2027, 3, 20), TipoEvento.CONCIERTO, venue4));
        listaEventos.add(new Evento("E016", "Torneo de Baloncesto", LocalDate.of(2027, 4, 3), TipoEvento.DEPORTIVO, venue9));
        listaEventos.add(new Evento("E017", "Feria del Libro", LocalDate.of(2027, 4, 10), TipoEvento.FERIA, venue8));
        listaEventos.add(new Evento("E018", "Festival Electronico", LocalDate.of(2027, 5, 15), TipoEvento.FESTIVAL, venue10));
        listaEventos.add(new Evento("E019", "Concierto Indie", LocalDate.of(2027, 5, 22), TipoEvento.CONCIERTO, venue1));
        listaEventos.add(new Evento("E020", "Feria Gastronomica", LocalDate.of(2027, 6, 5), TipoEvento.FERIA, venue3));
	    
	    return listaEventos;
	}

}

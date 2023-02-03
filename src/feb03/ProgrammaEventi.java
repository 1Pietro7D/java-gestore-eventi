package feb03;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ProgrammaEventi {

	private String titleList;
	private List<Evento> events;

	public ProgrammaEventi(String titleList) {
		this.titleList = titleList;
		this.events = new ArrayList<>();
	}

	public void addEvent(Evento event) {
		this.events.add(event);
	}

	public List<Evento> getEventsByDate(LocalDate date) {
		List<Evento> eventsByDate = new ArrayList<>();
		for (Evento event : events) {
			if (event.getDate().equals(date)) {
				eventsByDate.add(event);
			}
		}
		return eventsByDate;
	}

	public int countEvents() {
		return this.events.size();
	}

	public void clearEvents() {
		this.events.clear();
	}

	public String showProgram() {
		Collections.sort(this.events);
		StringBuilder sb = new StringBuilder();
		sb.append(this.titleList + "\n");
		for (Evento event : this.events) {
			sb.append(event.getDate().toString() + " - " + event.getTitle() + "\n");
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ProgrammaEventi events = new ProgrammaEventi("miao");
		events.addEvent(new Concerto("Concerto di musica classica", LocalDate.of(2024, 11, 14), 100,LocalTime.of(20, 30), new BigDecimal("15.99")));
		events.addEvent(new Concerto("concerto pop", LocalDate.of(2024, 11, 12), 200, LocalTime.of(17, 30), new BigDecimal("19.99")));
		events.addEvent(new Evento("Spettacolo di danza contemporanea", LocalDate.of(2024, 11, 16), 150));
		Collections.sort(events.events); // ordina gli eventi per data, pop viene stampato prima di classica
		System.out.println(events.showProgram());
		System.out.println("numero concerti nella lista "+ events.countEvents()+ "\n");
		events.clearEvents();
		System.out.println(events.showProgram());
	}
	

}

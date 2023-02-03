package feb03;

import java.time.LocalDate;

public class Evento {
	private String title;
	private LocalDate date;
	private int totalSeats;
	private int reserveSeats;

	public Evento(String title, LocalDate date, int totalSeats) {
		if (date.isBefore(LocalDate.now()) || totalSeats <= 0) {
			throw new IllegalArgumentException("Data non valida o numero di posti totali non positivo");
		}
		this.title = title;
		this.date = date;
		this.totalSeats = totalSeats;
		this.reserveSeats = 0;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public int getTotalSeats() {
		return totalSeats;
	}

	public int getReserveSeats() {
		return reserveSeats;
	}

	public void reserve() {
		if (date.isBefore(LocalDate.now()) || reserveSeats >= totalSeats) {
			throw new IllegalArgumentException("Impossibile prenotare: evento già passato o posti esauriti");
		}
		reserveSeats++;
	}

	// overloading reserve()
	public void reserve(int numSeats) throws Exception {
		if (date.isBefore(LocalDate.now()) || reserveSeats + numSeats > totalSeats) {
			throw new IllegalArgumentException("Impossibile prenotare: evento già passato o posti esauriti");
		} else if (numSeats <= 0) {
			throw new Exception("Impossibile prenotare: valore non valido");
		}
		reserveSeats += numSeats;
	}

	public void countermand() {
		if (date.isBefore(LocalDate.now()) || reserveSeats <= 0) {
			throw new IllegalArgumentException(
					"Impossibile disdire: evento già passato o nessuna prenotazione effettuata");
		}
		reserveSeats--;
	}
	public int getRemainingSeats() {
		return getTotalSeats() - getReserveSeats();
		
	}

	// overloading countermand()
	public void countermand(int numSeats) {
		if (date.isBefore(LocalDate.now()) || reserveSeats - numSeats < 0) {
			throw new IllegalArgumentException(
					"Impossibile disdire: evento già passato o nessuna prenotazione effettuata");
		} else if (numSeats < 0) {
			throw new IllegalArgumentException("Impossibile disdire: valore non valido");
		}
		reserveSeats -= numSeats;
	}

	@Override
	public String toString() {
		return date.toString() + " + " + title + "+ Posti totali: " + totalSeats + " + Posti prenotati: "
				+ reserveSeats +" - Posti rimanenti" + getRemainingSeats();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Evento ev = new Evento("mario", LocalDate.of(2024, 1, 1), 5);
		try {
			ev.reserve(5);
			ev.countermand(2);
			ev.countermand();
			System.out.println(ev);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

}

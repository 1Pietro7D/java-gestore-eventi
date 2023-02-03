package feb03;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

		Scanner sc = new Scanner(System.in);

		System.out.print("Inserisci il titolo dell'evento: ");
		String title = sc.nextLine();

		System.out.print("Inserisci la data dell'evento (YYYY-MM-DD): ");
		LocalDate date = LocalDate.parse(sc.nextLine());
		String formatDate = formatter.format(Date.from(date.atStartOfDay(ZoneId.systemDefault()).toInstant())); // valore formattato DD/MM/YYYY
		System.out.print("Inserisci il numero di posti totali: ");
		int totalSeats = sc.nextInt();

		Evento evento = new Evento(title, date, totalSeats);

		System.out.print("Inserisci il numero di prenotazioni: ");
		int prenotazioni = sc.nextInt();
		try {
			evento.reserve(prenotazioni);
		} catch (Exception e) {
			System.out.println("Errore durante la prenotazione: " + e.getMessage());
		}

		System.out.println("Posti prenotati: " + evento.getReserveSeats());
		System.out.println("Posti disponibili: " + evento.getRemainingSeats());

		System.out.print("Inserisci il numero di disdette: ");
		int disdette = sc.nextInt();
		try {
			evento.countermand(disdette);
		} catch (Exception e) {
			System.out.println("Errore durante la disdetta: " + e.getMessage());
		}

		System.out.println("Posti prenotati: " + evento.getReserveSeats());
		System.out.println("Posti disponibili: " + evento.getRemainingSeats());
	}
}

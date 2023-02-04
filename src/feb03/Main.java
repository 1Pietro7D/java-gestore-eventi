package feb03;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		// SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

		Scanner sc = new Scanner(System.in);

		System.out.print("Inserisci il titolo dell'evento: ");
		String title = sc.nextLine();

		
		try {
			/*
			 * System.out.print("Inserisci la data dell'evento (YYYY-MM-DD): "); LocalDate
			 * date = LocalDate.parse(sc.nextLine()); String formatDate =
			 * formatter.format(Date.from(date.atStartOfDay(ZoneId.systemDefault()).
			 * toInstant())); // valore formattato DD/MM/YYYY
			 */
			System.out.print("Inserisci la data (formato dd/MM/yyyy): ");
			String dateString = sc.nextLine();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			LocalDate localDate = LocalDate.parse(dateString, formatter);
			System.out.print("Inserisci il numero di posti totali: ");
			int totalSeats = sc.nextInt();

			Concerto evento = new Concerto(title, localDate, totalSeats, LocalTime.of(17, 30), new BigDecimal("19.99"));

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
			System.out.println(evento);
		} catch (Exception e) {
			System.out.println("Errore durante la creazione: " + e.getMessage());
		}finally{sc.close();};
	}
}

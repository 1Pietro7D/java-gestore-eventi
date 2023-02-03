package feb03;

import java.time.LocalDate;

public class Evento {
    private String titolo;
    private LocalDate data;
    private int postiTotali;
    private int postiPrenotati;

    public Evento(String titolo, LocalDate data, int postiTotali) {
        if (data.isBefore(LocalDate.now()) || postiTotali <= 0) {
            throw new IllegalArgumentException("Data non valida o numero di posti totali non positivo");
        }
        this.titolo = titolo;
        this.data = data;
        this.postiTotali = postiTotali;
        this.postiPrenotati = 0;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public int getPostiTotali() {
        return postiTotali;
    }

    public int getPostiPrenotati() {
        return postiPrenotati;
    }

    public void prenota() {
        if (data.isBefore(LocalDate.now()) || postiPrenotati >= postiTotali) {
            throw new IllegalArgumentException("Impossibile prenotare: evento già passato o posti esauriti");
        }
        postiPrenotati++;
    }

    public void disdici() {
        if (data.isBefore(LocalDate.now()) || postiPrenotati <= 0) {
            throw new IllegalArgumentException("Impossibile disdire: evento già passato o nessuna prenotazione effettuata");
        }
        postiPrenotati--;
    }

    @Override
    public String toString() {
        return data.toString() + " + " + titolo + "+ Posti totali: " + postiTotali + " + Posti prenotati: " + postiPrenotati;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Evento e = new Evento("mario", LocalDate.of(2024, 1, 1), 5);
		e.prenota();
		e.prenota();
		e.prenota();
		e.prenota();
		e.prenota();
		/*try {e.prenota();}catch(IllegalArgumentException e1){
			System.out.println(e1.getMessage());
		} */
		System.out.println(e);
		}

}

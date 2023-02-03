package feb03;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Concerto extends Evento{
	private LocalTime time;
	private BigDecimal price;

	public Concerto(String title, LocalDate date, int totalSeats, LocalTime time, BigDecimal price) {
	super(title, date, totalSeats);
	this.time = time;
	this.price = price;
	}

	public LocalTime getTime() {
	return time;
	}

	public void setTime(LocalTime time) {
	this.time = time;
	}

	public BigDecimal getPrice() {
	return price;
	}

	public void setPrice(BigDecimal price) {
	this.price = price;
	}

	public String getFormatDate() {
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	return getDate().format(formatter);
	}

	public String getFormatTime() {
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
	return time.format(formatter);
	}

	public String getFormatPrice() {
	return price.toString() + "€";
	}

	@Override
	public String toString() {
	return super.toString() +" " + getFormatDate() + " " + getFormatTime() + " - " + getFormatPrice();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

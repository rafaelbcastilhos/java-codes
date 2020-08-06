package entities;

public class CurrencyConverter {
	public double price;
	public double qntd;
	public static double IOF = 1.06;
	
	public double converter() {
		return price * qntd * IOF;
	}
}

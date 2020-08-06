// dollar to reals converter using financial transaction tax = 1.06
package application;

import java.util.Locale;
import java.util.Scanner;
import entities.CurrencyConverter;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		CurrencyConverter cc = new CurrencyConverter();
		
		System.out.println("what is the dollar price? ");
		cc.price = sc.nextDouble();
		System.out.println("how many dollar will be bought? ");
		cc.qntd = sc.nextDouble();
		System.out.printf("amount to be paid in reais: %.2f", cc.converter());
		
		sc.close();
	}
}

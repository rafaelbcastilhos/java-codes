// tax payment according to model (individual or company)
package application;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Company;
import entities.Individual;
import entities.Taxpayers;

public class Program {

	public static void main(String[] args) throws ParseException{
		Scanner sc = new Scanner (System.in);
		Locale.setDefault(Locale.US);
		
		double sum = 0.0;
		List<Taxpayers> list = new ArrayList<>();
		
		System.out.print("enter the number of tax payers: ");
		int n = sc.nextInt();
		
		for(int i = 1; i <= n; i++) {
			System.out.printf("\ntax payer #%d", i, "data:\n");
			System.out.print("\nindividual or company (i / c)? ");
			char ans = sc.next().charAt(0);
			System.out.printf("name: ");
			sc.nextLine();
			String name = sc.nextLine();
			System.out.printf("anual income: ");
			double anualIncome = sc.nextDouble();
			
			// individual
			if(ans == 'i') {
				System.out.print("health expenditures: ");
				double healthExpenditures = sc.nextDouble();
				list.add(new Individual(name, anualIncome, healthExpenditures));
			}
			
			// company
			else if(ans == 'c') {
				System.out.print("number of employees: ");
				int numberOfEmployees = sc.nextInt();
				list.add(new Company(name, anualIncome, numberOfEmployees));
			}
			
			// other
			else
				System.out.print("exit...");
		}
		
		// prints name and amount to be paid
		System.out.println("taxes paid: \n");
		for(Taxpayers tp : list) {
			double tax = tp.tax();
			System.out.println(tp.getName() + ": $ " + String.format("%.2f", tax));
			sum += tax;
		}
		
		System.out.println("\ntotal taxes: $" + String.format("%.2f", sum));
		
		sc.close();
	}
}

// deposit and withdraw in bank account prototype
package application;

import java.util.Locale;
import java.util.Scanner;
import entities.Account;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		Account account;

		System.out.print("enter account number: ");
		int number = sc.nextInt();
		System.out.print("enter account holder: ");
		sc.nextLine();
		String holder = sc.nextLine();
		System.out.print("is there an initial deposit (y/n)? ");
		char response = sc.next().charAt(0);
		
		// initial deposit
		if (response == 'y') {
			System.out.print("enter initial deposit value: ");
			double initialDeposit = sc.nextDouble();
			account = new Account(number, holder, initialDeposit);
		}
		else
			account = new Account(number, holder);

		
		System.out.println("\naccount data:");
		System.out.println(account);
		
		// deposit
		System.out.println();
		System.out.print("\nenter a deposit value: ");
		double depositValue = sc.nextDouble();
		account.deposit(depositValue);
		
		// updated
		System.out.println("updated account data:");
		System.out.println(account);
		
		// withdraw
		System.out.print("\nenter a withdraw value: ");
		double withdrawValue = sc.nextDouble();
		account.withdraw(withdrawValue);
		
		// updated
		System.out.println("updated account data:");
		System.out.println(account);
		
		sc.close();
	}
}
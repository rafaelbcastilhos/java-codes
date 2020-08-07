// room reservation using exception handling
package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;
import model.exception.DomainException;

public class Program {

	public static void main(String[] args) throws ParseException{
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		// new schedule registration
		try {
			System.out.print("room number: ");
			int number = sc.nextInt();
			System.out.print("check in date (dd/MM/yyyy): ");
			Date checkIn = sdf.parse(sc.next());
			System.out.print("check out date (dd/MM/yyyy): ");
			Date checkOut = sdf.parse(sc.next());
			
			// generates a new reservation
			Reservation reservation = new Reservation(number, checkIn, checkOut);
			System.out.println("reservation: " + reservation);
			
			// update reservation data
			System.out.println("\nenter data to update reservation:");
			System.out.print("check in date (dd/MM/yyyy): ");
			checkIn = sdf.parse(sc.next());
			System.out.print("check out date (dd/MM/yyyy): ");
			checkOut = sdf.parse(sc.next());
			
			reservation.updateDates(checkIn, checkOut);
			System.out.println("reservation: " + reservation);
		}
		
		// exception handling
		catch (ParseException e) {
			System.out.println("invalid data format");
		}
		catch (DomainException e) {
			System.out.println("error in reservation:" + e.getMessage());
		}
		catch (RuntimeException e) {
			System.out.println("unexpected error");
		}
		sc.close();
	}
}

// employee payment using lists
package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entities.Employee;
import entities.OutsourcedEmployee;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("enter the nunmber of employees: ");
		int n = sc.nextInt();
		
		// creating new arraylist
		List<Employee> list = new ArrayList<>();
		
		for(int i = 0; i < n; i++) {
			System.out.printf("employee #%d data: ", i + 1);
			System.out.print("outsourced? (y/n): ");
			char ans = sc.next().charAt(0);
			System.out.print("name: ");
			sc.nextLine();
			String name = sc.nextLine();
			System.out.print("hours: ");
			int hours = sc.nextInt();
			System.out.print("value per hour: ");
			double valuePerHour = sc.nextDouble();
			
			// outsourced
			if(ans == 'y') {
				System.out.print("additional charge: ");
				double additionalCharge = sc.nextDouble();
				list.add(new OutsourcedEmployee(name, hours, valuePerHour, additionalCharge));
			}
			// common
			else 
				list.add(new Employee(name, hours, valuePerHour));
		}
		System.out.println("\n\npayments:");
		for(Employee emp : list)
			System.out.println(emp.getName() + " - $ " + String.format("%.2f", emp.payment()));
		
		sc.close();
	}
}

// employee contract using enums in worker level
package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Department;
import entities.Employee;
import entities.HourContract;
import entities.enums.WorkerLevel;

public class Program {

	public static void main(String[] args) throws ParseException {
		Scanner sc = new Scanner(System.in);
		Locale.setDefault(Locale.US);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		// fill new employee
		System.out.print("enter department's name: ");
		String departmentName = sc.nextLine();	
		System.out.printf("enter employee data:\n");
		System.out.print("name: ");
		String employeeName = sc.nextLine(); 
		
		// JUNIOR, PLENO, SENIOR
		System.out.print("level: ");
		String workerLevel = sc.nextLine();
		System.out.print("base salary: ");
		Double baseSalary = sc.nextDouble();
		
		// create new employee and department
		Employee employee = new Employee(employeeName, WorkerLevel.valueOf(workerLevel), baseSalary, new Department(departmentName));
		
		System.out.println("how many contracts to this employee? ");
		int num = sc.nextInt();
		
		// loop to fill in the contracts
		for(int i = 1; i <= num; i++) {
			System.out.println("enter contract #" + i + " data:");
			System.out.print("date (dd/mm/yyyy): ");
			Date contractDate = sdf.parse(sc.next());
			System.out.print("value per hour: ");
			double valuePerHour = sc.nextDouble();
			System.out.print("duration (hours): ");
			int hours = sc.nextInt();
			HourContract contract= new HourContract(contractDate, valuePerHour, hours);
			employee.addContract(contract);
		}
		
		// print income in a given month
		System.out.printf("\nenter month and year to calculate income (mm/yyyy): ");
		String monthAndYear = sc.next();
		int month = Integer.parseInt(monthAndYear.substring(0, 2));
		int year = Integer.parseInt(monthAndYear.substring(3));
		
		System.out.println("name: " + employee.getName());
		System.out.println("department: " + employee.getDepartment().getName());
		System.out.println("income for " + monthAndYear + ": " + String.format("%.2f", employee.income(year, month)));
		
		sc.close();
	}
}

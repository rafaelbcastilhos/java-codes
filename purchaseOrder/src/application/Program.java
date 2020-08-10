// purchase order using current date/time and enums
package application;

import java.text.ParseException;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Client;
import model.entities.Order;
import model.entities.OrderItem;
import model.entities.Product;
import model.enums.OrderStatus;

public class Program {

	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		// client data entry
		System.out.println("enter client data: ");
		System.out.print("name: ");
		String name = sc.nextLine();
		System.out.print("email: ");
		String email = sc.next();
		
		// generated new client
		Client client = new Client(name, email);
		
		// PENDING_PAYMENT,PROCESSING,SHIPPED,DELIVERED
		System.out.println("enter order data: ");
		System.out.print("status: ");
		OrderStatus status = OrderStatus.valueOf(sc.next());
		
		// generated new order
		Order order = new Order(new Date(), status, client);
		
		System.out.println("how many items to this order? ");
		int num = sc.nextInt();
		
		// product data entry
		for(int i = 1; i <= num; i++) {
			System.out.println("enter #" + i + " item data:");
			System.out.println("product name: ");
			sc.nextLine();
			String productName = sc.nextLine();
			System.out.println("product price: ");
			double productPrice = sc.nextDouble();
			
			Product product = new Product(productName, productPrice);
			System.out.println("quantity: ");
			int quantity = sc.nextInt();
			
			OrderItem orderItem = new OrderItem(quantity, productPrice, product);
			order.addItem(orderItem);
		}
		// print order summary
		System.out.println("\norder summary: \n");
		System.out.println(order);
		
		sc.close();
	}
}

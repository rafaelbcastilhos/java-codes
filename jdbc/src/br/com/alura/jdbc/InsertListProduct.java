package br.com.alura.jdbc;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import br.com.alura.jdbc.dao.ProductDAO;
import br.com.alura.jdbc.factory.ConnectionFactory;
import br.com.alura.jdbc.model.Product;

public class InsertListProduct {

	public static void main(String[] args) throws SQLException {
		Product product = new Product("Keyboard", "Keyboard wireless");

		try(Connection connection = new ConnectionFactory().recuperarConexao()) {
			ProductDAO productDao = new ProductDAO(connection);
			productDao.save(product);
			List<Product> listProducts = productDao.list();
			listProducts.stream().forEach(lp -> System.out.println(lp));
		} 
	}
}

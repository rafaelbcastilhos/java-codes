package br.com.alura.jdbc;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import br.com.alura.jdbc.dao.CategoryDAO;
import br.com.alura.jdbc.factory.ConnectionFactory;
import br.com.alura.jdbc.model.Category;
import br.com.alura.jdbc.model.Product;

public class ListCategory {

	public static void main(String[] args) throws SQLException {
		try(Connection connection = new ConnectionFactory().recuperarConexao()) {
			CategoryDAO categoryDAO = new CategoryDAO(connection);
			List<Category> listCategory = categoryDAO.listProduct();

			listCategory.stream().forEach(ct -> {
				System.out.println(ct.getName());
				for(Product product : ct.getProducts()) {
					System.out.println(ct.getName() + " - " + product.getName());
				}
			});
		}
	}
}

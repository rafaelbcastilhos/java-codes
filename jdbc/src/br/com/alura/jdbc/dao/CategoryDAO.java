package br.com.alura.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import br.com.alura.jdbc.model.Category;
import br.com.alura.jdbc.model.Product;

public class CategoryDAO {
	private Connection connection;
	public CategoryDAO(Connection connection) {
		this.connection = connection;
	}

	public List<Category> list() throws SQLException {
		List<Category> listCategory = new ArrayList<>();
		String sql = "SELECT ID, NAME FROM CATEGORY";

		try(PreparedStatement pstm = connection.prepareStatement(sql)) {
			pstm.execute();
			try(ResultSet rst = pstm.getResultSet()) {
				while(rst.next()) {
					Category category =
							new Category(rst.getInt(1), rst.getString(2));

					listCategory.add(category);
				}
			}
		}
		return listCategory;
	}

	public List<Category> listProduct() throws SQLException {
		Category last = null;
		List<Category> listCategory = new ArrayList<>();
		String sql = "SELECT C.ID, C.NAME, P.ID, P.NAME, P.DESCRIPTION FROM CATEGORY C INNER JOIN PRODUCT P ON C.ID = P.CATEGORY_ID";

		try(PreparedStatement pstm = connection.prepareStatement(sql)) {
			pstm.execute();

			try(ResultSet rst = pstm.getResultSet()) {
				while(rst.next()) {
					if(last == null || !last.getName().equals(rst.getString(2))) {
						Category category =
								new Category(rst.getInt(1), rst.getString(2));

						listCategory.add(category);
						last = category;
					}
					Product product =
							new Product(rst.getInt(3), rst.getString(4), rst.getString(5));
					last.add(product);
				}
			}
			return listCategory;
		}
	}
}

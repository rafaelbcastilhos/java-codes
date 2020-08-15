package br.com.alura.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import br.com.alura.jdbc.model.Category;
import br.com.alura.jdbc.model.Product;

public class ProductDAO {
	private Connection connection;
	public ProductDAO(Connection connection) {
		this.connection = connection;
	}

	public void save(Product product) throws SQLException {
		String sql = "INSERT INTO PRODUTO (NOME, DESCRICAO) VALUES (?, ?)";
		try(PreparedStatement pstm = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

			pstm.setString(1, product.getNome());
			pstm.setString(2, product.getDescricao());
			pstm.execute();

			try(ResultSet rst = pstm.getGeneratedKeys()) {
				while(rst.next()) {
					product.setId(rst.getInt(1));
				}
			}
		}
	}

	public List<Product> list() throws SQLException {
		List<Product> listProduct = new ArrayList<Product>();

		String sql = "SELECT ID, NAME, DESCRIPTION FROM PRODUCT";

		try(PreparedStatement pstm = connection.prepareStatement(sql)) {
			pstm.execute();

			setToProduct(listProduct, pstm);
		}
		return listProduct;
	}

	public List<Product> search(Category ct) throws SQLException {
		List<Product> listProduct = new ArrayList<Product>();
		String sql = "SELECT ID, NAME, DESCRIPTION FROM PRODUCT WHERE CATEGORY_ID = ?";

		try(PreparedStatement pstm = connection.prepareStatement(sql)) {
			pstm.setInt(1, ct.getId());
			pstm.execute();

			setToProduct(listProduct, pstm);
		}
		return listProduct;
	}

	private void setToProduct(List<Product> listProduct, PreparedStatement pstm) throws SQLException {
		try(ResultSet rst = pstm.getResultSet()) {
			while(rst.next()) {
				Product product =
						new Product(rst.getInt(1), rst.getString(2), rst.getString(3));

				listProduct.add(product);
			}
		}
	}
}

package br.com.alura.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import br.com.alura.jdbc.factory.ConnectionFactory;

public class List {
	public static void main(String[] args) throws SQLException {
		ConnectionFactory connectionFactory = new ConnectionFactory();
		Connection connection = connectionFactory.recover();

		PreparedStatement stm = connection.prepareStatement("SELECT ID, NAME, DESCRIPTION FROM PRODUCT");
		stm.execute();
		ResultSet rst = stm.getResultSet();
		while(rst.next()) {
			Integer id = rst.getInt("ID");
			String name = rst.getString("NAME");
			String description = rst.getString("DESCRIPTION");
			System.out.println(id);
			System.out.println(name);
			System.out.println(description);
		}
		rst.close();
		stm.close();
		connection.close();
	}
}

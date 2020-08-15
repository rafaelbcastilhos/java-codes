package br.com.alura.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import br.com.alura.jdbc.factory.ConnectionFactory;

public class ParamInsert {
	public static void main(String[] args) throws SQLException {
		ConnectionFactory factory = new ConnectionFactory();
		try(Connection connection = factory.recuperarConexao()){
			connection.setAutoCommit(false);

			try (PreparedStatement stm = 
					connection.prepareStatement("INSERT INTO PRODUCT (name, description) VALUES (?, ?)", Statement.RETURN_GENERATED_KEYS);
					){
				add("SmartTV", "45", stm);
				add("Radio", "Batery", stm);

				connection.commit();
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("ROLLBACK");
				connection.rollback();
			}
		}
	}

	private static void add(String name, String description, PreparedStatement stm) throws SQLException {
		stm.setString(1, name);
		stm.setString(2, description);

		if(name.equals("Radio")) {
			throw new RuntimeException("Couldn't add product");
		}

		stm.execute();

		try(ResultSet rst = stm.getGeneratedKeys()){
			while(rst.next()) {
				Integer id = rst.getInt(1);
				System.out.println("id: " + id);
			}
		}
	}
}



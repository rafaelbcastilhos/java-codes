package br.com.alura.jdbc;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import br.com.alura.jdbc.factory.ConnectionFactory;

public class Insert {

	public static void main(String[] args) throws SQLException {

		ConnectionFactory factory = new ConnectionFactory();
		Connection connection = factory.recover();

		Statement stm = connection.createStatement();
		stm.execute("INSERT INTO PRODUCT (name, description) VALUES ('Mouse', 'Mouse wireless')"
				, Statement.RETURN_GENERATED_KEYS);

		ResultSet rst = stm.getGeneratedKeys();
		while(rst.next()) {
			Integer id = rst.getInt(1);
			System.out.println("id: " + id);
		}
		rst.close();
		stm.close();
		connection.close();
	}
}

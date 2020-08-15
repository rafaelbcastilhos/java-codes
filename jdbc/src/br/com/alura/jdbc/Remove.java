package br.com.alura.jdbc;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import br.com.alura.jdbc.factory.ConnectionFactory;

public class Remove {
	public static void main(String[] args) throws SQLException {
		ConnectionFactory factory = new ConnectionFactory();
		Connection connection = factory.recover();

		PreparedStatement stm = connection.prepareStatement("DELETE FROM PRODUCT WHERE ID > ?");
		stm.setInt(1, 2);
		stm.execute();

		Integer row = stm.getUpdateCount();

		System.out.println("Rows modified: " + row);
		stm.close();
		connection.close();
	}
}

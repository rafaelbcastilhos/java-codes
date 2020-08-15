package br.com.alura.jdbc;
import java.sql.Connection;
import java.sql.SQLException;

import br.com.alura.jdbc.factory.ConnectionFactory;

public class ConnectionInit {
	public static void main(String[] args) throws SQLException {

		ConnectionFactory connectionFactory = new ConnectionFactory();
		Connection connection = connectionFactory.recover();
		connection.close();
	}
}

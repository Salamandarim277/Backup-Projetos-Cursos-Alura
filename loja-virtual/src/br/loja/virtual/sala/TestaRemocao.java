package br.loja.virtual.sala;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TestaRemocao {

	public static void main(String[] args) throws SQLException {	
	
		ConnectionFactory connectionFactory = new ConnectionFactory();
		Connection connection = connectionFactory.connect();
		PreparedStatement statement = connection.prepareStatement(
				"DELETE FROM PRODUTO WHERE ID > ?");
		statement.setInt(1, 2);
		statement.execute();
		int linhasModificadas = statement.getUpdateCount();
		
		System.out.println("quantidade de linhas modificadas " + linhasModificadas);
	}
}

package br.loja.virtual.sala;

import java.sql.Connection;
import java.sql.SQLException;

public class TestaConexao {

	public static void main(String[] args) throws SQLException {
		
		ConnectionFactory connectionFactory = new ConnectionFactory();
		Connection connection = connectionFactory.connect();
		
		System.out.println("Fechando conexão");
		
		connection.close();
	}
	
}

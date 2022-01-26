package br.loja.virtual.sala;

import java.sql.SQLException;

public class TestaPoolConexoes {
	
	public static void main(String[] args) throws SQLException {
		
		ConnectionFactory connectionFactory = new ConnectionFactory();
		
		for(int i = 0; i < 10; i++) {
			connectionFactory.connect();
			System.out.println("Conexao " + i + " aberta");
		}
	}
}

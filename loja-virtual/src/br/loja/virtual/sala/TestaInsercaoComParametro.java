package br.loja.virtual.sala;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaInsercaoComParametro {

	public static void main(String[] args) throws SQLException {
		
		ConnectionFactory connectionFactory = new ConnectionFactory();
		try (Connection connection = connectionFactory.connect();) {
		connection.setAutoCommit(false);
		
			try (PreparedStatement statement = connection.prepareStatement(
					"INSERT INTO PRODUTO (nome, descricao)"
					+ " VALUES (?, ?)",
					Statement.RETURN_GENERATED_KEYS);){
					
				adicionarVariavel("Geladeira", "Geladeira Branca", statement);
				adicionarVariavel("Mesa", "Mesa de madeira", statement);
				
				connection.commit();
				statement.close();
				
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("RollbackExecutado");
				connection.rollback();
			}
		}
	}

	private static void adicionarVariavel(String nome, String descricao, PreparedStatement statement)
			throws SQLException {
		statement.setString(1, nome);
		statement.setString(2, descricao);
		statement.execute();
		
		try (ResultSet resultSet = statement.getGeneratedKeys()) {
			while(resultSet.next()) {
				int id = resultSet.getInt(1);
				System.out.println("o ID criado foi " + id);
			}
		}
	}
	
}

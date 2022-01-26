package br.loja.virtual.sala;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import br.loja.virtual.sala.dao.ProdutoDAO;
import br.loja.virtual.sala.modelo.Produto;

public class TestarInsercaoEListagemComProduto {

	public static void main(String[] args) throws SQLException {
		
		Produto comoda = new Produto("Comoda", "Comoda Vertical");
		
		try (Connection connection = new ConnectionFactory().connect()) {
			ProdutoDAO persistenciaProduto = new ProdutoDAO(connection);
			persistenciaProduto.salvar(comoda); 
			List<Produto> listaDeProdutos = persistenciaProduto.listar();
			listaDeProdutos.stream().forEach(lp -> System.out.println(lp));
			}
		System.out.println(comoda);
	}
}

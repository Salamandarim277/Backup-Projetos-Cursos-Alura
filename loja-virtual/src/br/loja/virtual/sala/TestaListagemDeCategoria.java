package br.loja.virtual.sala;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import br.loja.virtual.sala.dao.CategoriaDAO;
import br.loja.virtual.sala.modelo.Categoria;
import br.loja.virtual.sala.modelo.Produto;

public class TestaListagemDeCategoria {
 
	public static void main(String[] args) throws SQLException {
	
		try (Connection connection = new ConnectionFactory().connect()) {
			CategoriaDAO categoriaDAO = new CategoriaDAO(connection);
			List<Categoria> listaDeCategorias = categoriaDAO.listarComProdutos();
			listaDeCategorias.stream().forEach(ct -> {
				System.out.println(ct.getNome());	
				for(Produto produto : ct.getProdutos()) {			  
					System.out.println(ct.getNome() + " - " + produto.getNome());
				}							 
			});
		}
	}
}

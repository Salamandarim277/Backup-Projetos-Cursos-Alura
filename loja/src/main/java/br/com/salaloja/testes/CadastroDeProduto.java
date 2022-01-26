package br.com.salaloja.testes;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.salaloja.dao.CategoriaDAO;
import br.com.salaloja.dao.ProdutoDAO;
import br.com.salaloja.modelo.Categoria;
import br.com.salaloja.modelo.Produto;
import br.com.salaloja.util.JPAUtil;

public class CadastroDeProduto {	
	
	public static void main(String[] args) {
		
		cadastrarProduto();
		Long id = 1l;
		
		EntityManager em = JPAUtil.getEntityManager();
		ProdutoDAO produtoDAO = new ProdutoDAO(em);
		Produto p = produtoDAO.buscarPorId(id);
		System.out.println(p.getPreco());
		
		List<Produto> todos = produtoDAO.buscarTodos();
		todos.forEach(p2 -> System.out.println(p.getNome()));
	
		BigDecimal precoDoProduto = produtoDAO.buscarPrecoDoProdutoComNome("Xiaomi Redmi Note 8");
	}	

	private static void cadastrarProduto() {
		Categoria celulares = new Categoria("CELULARES");
		
		
		Produto celular = new Produto();
		celular.setNome("Xiaomi Redmi Note 8");
		celular.setDescricao("Celular do meu abiguinho Pablo!");
		celular.setPreco(new BigDecimal("1700"));
		celular.setCategoria(celulares);
		
//		Produto foxy = new Produto();
//		celular.setNome("Foxy baiano");
//		celular.setDescricao("uma raposa baiana tambem conhecida como hiena");
//		celular.setPreco(new BigDecimal("1,99"));
//		
//		Produto leiteDoSala = new Produto();
//		celular.setNome("Leite de tubarão");
//		celular.setDescricao("Leite de tubarão do Sala fresquinho nada sus..."
//				+ " um pouco gosmento e pegajoso");
//		celular.setPreco(new BigDecimal("0,00"));
//		
//		Esgotado
//		Produto assassino = new Produto();
//		celular.setNome("Assassino de aluguel");
//		celular.setDescricao("Ele mata quem voce quiser");
//		celular.setPreco(new BigDecimal("10000"));
		
		EntityManager em = JPAUtil.getEntityManager();
		
		ProdutoDAO produtoDAO = new ProdutoDAO(em);
		CategoriaDAO categoriaDAO = new CategoriaDAO(em);
		
		em.getTransaction().begin();
		categoriaDAO.cadastrar(celulares);
		produtoDAO.cadastrar(celular);
		em.getTransaction().commit();
		celular = em.merge(celular);
		celular.setNome("Pablo");
		em.close();
	}
}

package controller;

import java.util.List;

import model.Produto;
import util.FileManager;

// classe responsavel por gerenciar a lista de produtos e suas operações

public class ProdutoController {
	
	// lista pra armazenar todos os produtos cadastrados no sistema
	private List<Produto> produtos;
	
	public ProdutoController() {
		this.produtos = FileManager.carregarProdutos(); // vai carregar a lista ao iniciar
	}
	
	// adiciona novo produto na lista
	// verifica se ja existe um produto com mesmo id antes de adicionar
	public boolean adicionarProduto(Produto produto) {
		if (buscarProdutoPorId(produto.getId()) != null) {
			return false; // ou seja, ja existe produto com esse id
		}
		produtos.add(produto);
		FileManager.salvarProdutos(produtos);
		return true;
	}
	
	// retorna lista completa de produtos
	public List<Produto> listarProdutos() {
		FileManager.salvarProdutos(produtos);
		return produtos;
	}
	
	// busca um produto na lista
	public Produto buscarProdutoPorId(int id) {
		for (Produto p : produtos) {
			if (p.getId() == id) {
				return p;
			}
		}
		return null;
	}
	
	// atualiza as informações do produto com base no id
	public boolean atualizarProduto(int id, String novoNome, String novaCategoria, double novoPreco, int novaQuantidade) {
		Produto p = buscarProdutoPorId(id);
		if (p != null) {
			p.setNome(novoNome);
			p.setCategoria(novaCategoria);
			p.setPreco(novoPreco);
			p.setQuantidade(novaQuantidade);
			FileManager.salvarProdutos(produtos);
			return true;
		}
		return false; // nao encontrou o produto
	}
	
	// remove um produto da lista com base no id
	public boolean removerProduto(int id) {
		Produto p = buscarProdutoPorId(id);
		if (p != null) {
			produtos.remove(p);
			FileManager.salvarProdutos(produtos);
			return true;
		}
		return false; // nao encontrou o produto
	}
	
	// adiciona quantidade ao estoque de um produto
	public boolean adicionarEstoque(int id, int quantidade) {
		Produto p = buscarProdutoPorId(id);
		if (p != null && quantidade > 0) {
			p.setQuantidade(p.getQuantidade() + quantidade);
			FileManager.salvarProdutos(produtos);
			return true;
		}
		return false;
	}
	
	// remove quantidade do estoque
	// verifica se tem estoque suficiente
	public boolean removerEstoque(int id, int quantidade) {
		Produto p = buscarProdutoPorId(id);
		if (p != null && quantidade > 0 && p.getQuantidade() >= quantidade) {
			p.setQuantidade(p.getQuantidade() - quantidade);
			FileManager.salvarProdutos(produtos);
			return true;
		}
		return false;
	}
}

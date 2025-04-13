package model;

import java.io.Serializable;

// Essa classe vai modelar os dados de um produto, 
// contendo todos os atributos e metodos necessarios para representar um item no estoque da loja

public class Produto implements Serializable {
	private static final long serialVersionUID = 1L;

	// os atributos vao ser privados para seguir o principio de encapsulamento
	private int id;
	private String nome;
	private String categoria;
	private double preco;
	private int quantidade;

	// construtor padrao vazio
	public Produto() {

	}

	/**
	 * Construtor completo pra criar um produto com todos os dados
	 * 
	 * @param id         identificador único do produto
	 * @param nome       nome do produto
	 * @param categoria  categoria do produto
	 * @param preco      preço unitario do produto
	 * @param quantidade quantidade atual em estoque
	 */
	
	public Produto(int id, String nome, String categoria, double preco, int quantidade) {
		this.id = id;
		this.nome = nome;
		this.categoria = categoria;
		this.preco = preco;
		this.quantidade = quantidade;
	}

	// getters e setters
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	
	// metodo pra exibir as info de forma legivel
	
	@Override
	public String toString() {
		return "Produto {" +
                "ID =" + id +
                ", Nome ='" + nome + '\'' +
                ", Categoria ='" + categoria + '\'' +
                ", Preço =" + preco +
                ", Quantidade =" + quantidade +
                '}';
	}
	
}

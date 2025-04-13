package view;

import java.util.Scanner;

import controller.ProdutoController;
import model.Produto;
import util.Validator;

// classe responsavel por exibir o menu principal e interagir com o usuario

public class MenuPrincipal {

	private static Scanner scanner = new Scanner(System.in);
	private static ProdutoController controller = new ProdutoController();

	public static void main(String[] args) {
		
		int opcao;
		
		do {
			exibirMenu();
			System.out.println("Escolha uma opção: ");
			opcao = scanner.nextInt();
			scanner.nextLine();
			
			switch(opcao) {
				case 1 -> cadastrarProduto();
				case 2 -> listarProdutos();
				case 3 -> atualizarProduto();
				case 4 -> removerProduto();
				case 5 -> adicionarEstoque();
				case 6 -> removerEstoque();
				case 0 -> System.out.println("Saindo do sistema...");
				default -> System.out.println("Opção inválida! Tente novamente.");
			}
			
		} while (opcao != 0);
	}
	
	// exibe menu
	private static void exibirMenu() {
		System.out.println("\n===== Sistema de Estoque da Loja =====");
        System.out.println("1 - Cadastrar novo produto");
        System.out.println("2 - Listar produtos");
        System.out.println("3 - Atualizar produto");
        System.out.println("4 - Remover produto");
        System.out.println("5 - Adicionar estoque");
        System.out.println("6 - Remover estoque");
        System.out.println("0 - Sair");
	}
	
	// cadastra produto
	public static void cadastrarProduto() {
        System.out.println("\n--- Cadastro de Produto ---");
        System.out.print("ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        
        System.out.print("Nome: ");
        String nome = scanner.nextLine();

        System.out.print("Categoria: ");
        String categoria = scanner.nextLine();

        System.out.print("Preço: ");
        double preco = scanner.nextDouble();

        System.out.print("Quantidade: ");
        int quantidade = scanner.nextInt();
        
        // validações
        if (!Validator.isStringValida(nome) || !Validator.isStringValida(categoria)) {
        	System.out.println("Erro: nome e categoria não podem estar vazios.");
        	return;
        }
        
        if (!Validator.isPrecoValido(preco)) {
        	System.out.println("Erro: o preço deve ser maior que zero");
        	return;
        }
        
        if (!Validator.isQuantidadeValida(quantidade)) {
        	System.out.println("Erro: a quantidade não pode ser negativa");
        	return;
        }
        
        Produto novo = new Produto(id, nome, categoria, preco, quantidade);
        boolean sucesso = controller.adicionarProduto(novo);
        
        if (sucesso) {
        	System.out.println("Produto cadastrado com sucesso!");
        } else {
        	System.out.println("Erro: já existe produto com esse ID");
        }
	}
	
	// lista todos os produtos cadastrados
	public static void listarProdutos() {
		System.out.println("\n--- Lista de Produtos ---");
		if (controller.listarProdutos().isEmpty()) {
			System.out.println("Nenhum produto cadastrado");
		} else {
			for (Produto p : controller.listarProdutos()) {
				System.out.println(p);
			}
		}
	}

	// atualiza dados do produto
	private static void atualizarProduto() {
		System.out.println("\n--- Atualizar Produto ---");
        System.out.print("ID do produto: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Novo nome: ");
        String nome = scanner.nextLine();

        System.out.print("Nova categoria: ");
        String categoria = scanner.nextLine();

        System.out.print("Novo preço: ");
        double preco = scanner.nextDouble();

        System.out.print("Nova quantidade: ");
        int quantidade = scanner.nextInt();
        
        // validações
        if (!Validator.isStringValida(nome) || !Validator.isStringValida(categoria)) {
        	System.out.println("Erro: nome e categoria não podem estar vazios.");
        	return;
        }
        
        if (!Validator.isPrecoValido(preco)) {
        	System.out.println("Erro: o preço deve ser maior que zero");
        	return;
        }
        
        if (!Validator.isQuantidadeValida(quantidade)) {
        	System.out.println("Erro: a quantidade não pode ser negativa");
        	return;
        }

        boolean atualizado = controller.atualizarProduto(id, nome, categoria, preco, quantidade);

        if (atualizado) {
            System.out.println("Produto atualizado com sucesso!");
        } else {
            System.out.println("Produto não encontrado.");
        }
    }
	
	// remove um produto do estoque
	private static void removerProduto() {
		System.out.println("\n--- Remover Produto ---");
		System.out.print("ID do produto: ");
		int id = scanner.nextInt();
		
		boolean removido = controller.removerProduto(id);
		
		if (removido) {
			System.out.println("Produto removido com sucesso");
		} else {
			System.out.println("Produto não encontrado");
		}
	}
	
	// adiciona quantidade ao estoque de um produto
	public static void adicionarEstoque() {
		System.out.println("\n--- Adicionar Estoque ---");
		System.out.print("ID do produto: ");
		int id = scanner.nextInt();
		
		System.out.print("Quantidade a adicionar: ");
		int quantidade = scanner.nextInt();
		
		boolean sucesso = controller.adicionarEstoque(id, quantidade);
		
		if (sucesso) {
			System.out.println("Estoque atualizado com sucesso!");
		} else {
			System.out.println("Erro ao adicionar estoque. Verifique se o produto esta cadastrado e se a quantidade é válida.");
		}
	}
	
	// remove quantidade do estoque de um produto
	public static void removerEstoque() {
		System.out.println("\n--- Remover Estoque ---");
		System.out.print("ID do produto: ");
		int id = scanner.nextInt();
		
		System.out.print("Quantidade a remover: ");
		int quantidade = scanner.nextInt();
		
		boolean sucesso = controller.removerEstoque(id, quantidade);
		
		if (sucesso) {
			System.out.println("Estoque reduzido com sucesso!");
		} else { 
			System.out.println("Erro ao remover estoque. Verifique se há estoque suficiente");
		}
	}
}

package util;

// essa classe é responsavel por validar as entradas de dados

public class Validator {
	
	// verifica se uma string é nula ou vazia
	public static boolean isStringValida(String texto) {
		return texto != null && !texto.trim().isEmpty();
	}
	
	// verifica se um numero double é positivo
	public static boolean isPrecoValido(double preco) {
		return preco > 0;
	}
	
	// verifica se uma quantidade é valida
	public static boolean isQuantidadeValida(int quantidade) {
		return quantidade >= 0;
	}
}

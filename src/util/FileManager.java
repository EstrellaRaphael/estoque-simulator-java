package util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import model.Produto;

// classe responsavel por salvar e carregar a lista de produtos do sistema

public class FileManager {
	
	private static final String NOME_ARQUIVO = "produtos.dat";
	
	// vai salvar a lista de produtos no arquivo binario
	public static void salvarProdutos(List<Produto> produtos) {
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(NOME_ARQUIVO))) {
			oos.writeObject(produtos);
		} catch (IOException e) {
			System.out.println("Erro ao salvar os produtos " + e.getMessage());
		}
	}
	
	// carrega os produtos do arquivo binario
	@SuppressWarnings("unchecked")
	public static List<Produto> carregarProdutos() {
	    File arquivo = new File(NOME_ARQUIVO);

	    if (!arquivo.exists()) {
	        return new ArrayList<>();
	    }

	    try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(NOME_ARQUIVO))) {
	        return (List<Produto>) ois.readObject();
	    } catch (IOException | ClassNotFoundException e) {
	        System.out.println("Erro ao carregar os produtos: " + e.getMessage());
	        return new ArrayList<>();
	    }
	}

}

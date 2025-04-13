# Simulador de Estoque em Java

Projeto prático em Java nativo que simula um sistema de controle de estoque para uma loja. Desenvolvido como exercício de fixação dos conceitos de Programação Orientada a Objetos, coleções, persistência de dados e boas práticas em Java puro.

## 🛠 Tecnologias Utilizadas

- Java (sem frameworks externos)
- Eclipse IDE
- Arquivos `.dat` para persistência de dados
- Estrutura modular com separação por pacotes

## 📁 Estrutura de Pacotes

```
src/
├── model/        → Classe Produto.java
├── controller/   → ProdutoController.java (lógica de negócio)
├── view/         → MenuPrincipal.java (menu de interação)
└── util/         → FileManager.java (persistência) e Validator.java (validações)
```

## ✅ Funcionalidades

- Cadastro de produtos (ID, nome, categoria, preço e quantidade)
- Listagem de produtos
- Atualização de dados de produto
- Remoção de produtos
- Entrada (adicionar estoque) e saída (venda) de produtos
- Validação de dados de entrada
- Salvamento e carregamento automático via arquivos serializados

## 🧪 Testes

Todos os testes foram feitos manualmente com base em um checklist, incluindo:
- Inserção de dados válidos e inválidos
- Persistência entre execuções
- Manipulação de estoque
- Comportamento esperado em cenários de erro

## 📦 Como Executar

1. Importe o projeto no Eclipse como um projeto Java
2. Execute a classe `MenuPrincipal` no pacote `view`
3. Utilize o menu interativo no terminal para testar as funcionalidades

## 📄 Licença

Este projeto é livre para uso educacional.

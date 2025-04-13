# Simulador de Estoque em Java

Projeto prático em Java nativo que simula um sistema de controle de estoque para uma loja.

## Funcionalidades
- Cadastro, listagem, atualização e remoção de produtos
- Controle de entrada e saída de estoque
- Persistência com arquivos .dat (serialização)
- Validação de entradas
- Estrutura MVC em pacotes separados

## Organização do projeto
- `model/`: classe Produto
- `controller/`: lógica de negócio (ProdutoController)
- `view/`: menu principal e interação com o usuário
- `util/`: persistência em arquivo e validação

package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MaquinaDeVendas {
    private List<Produto> produtos;
    private CarrinhoCompras carrinho;

    public MaquinaDeVendas() {
        produtos = new ArrayList<>();
        carrinho = new CarrinhoCompras();
        inicializarProdutos();
    }

    private void exibirMenu() {
        System.out.println("""
                
                ***************************************
                MAQUINA DE VENDAS, SELECIONE UMA OPÇÃO:
                1 - Listar produtos
                2 - Comprar produto
                3 - Listar meu carrinho
                4 - Sair
                ***************************************
                """);
    }

    public void iniciarMaquinaDeVendas() {
        try (Scanner scanner = new Scanner(System.in)) {
            int opcao;
            do {
                exibirMenu();
                opcao = obterOpcaoUsuario(scanner);
                processarOpcao(opcao, scanner);
            } while (opcao != 4);
        }
    }

    private int obterOpcaoUsuario(Scanner scanner) {
        System.out.print("Escolha uma opção: ");
        while (!scanner.hasNextInt()) {
            System.out.print("Entrada inválida. Digite um número: ");
            scanner.next();
        }
        return scanner.nextInt();
    }

    private void processarOpcao(int opcao, Scanner scanner) {
        switch (opcao) {
            case 1 -> listarProdutos();
            case 2 -> comprarProduto(scanner);
            case 3 -> listarCarrinho();
            case 4 -> System.out.println("Encerrando a máquina de vendas...");
            default -> System.out.println("Opção inválida!");
        }
    }

    private void inicializarProdutos() {
        produtos.add(new Produto("001", "Coca-cola", 3.00, 10));
        produtos.add(new Produto("002", "Barra Cereal", 2.00, 15));
        produtos.add(new Produto("003", "Pirulito", 0.50, 30));
    }

    private void listarProdutos() {
        System.out.println("Produtos disponíveis:");
        for (Produto produto : produtos) {
            produto.exibirDetalhes();
        }
    }

    private void listarCarrinho() {
        System.out.println("Meu carrinho:");
        if (carrinho.getCarrinho().isEmpty()) {
            System.out.println("O carrinho está vazio.");
        } else {
            for (ItemCarrinho item : carrinho.getCarrinho()) {
                System.out.printf("Cód: %s - %s - R$ %.2f - Quantidade: %d%n",
                        item.getProduto().getCodigo(),
                        item.getProduto().getNome(),
                        item.getProduto().getPreco(),
                        item.getQuantidade());
            }
        }
    }

    private void comprarProduto(Scanner scanner) {
        System.out.println("Digite o código do produto que deseja comprar:");
        listarProdutos();
        System.out.print("Código do produto: ");
        String codigo = scanner.next();

        Produto produtoSelecionado = buscarProdutoPorCodigo(codigo);

        if (produtoSelecionado != null) {
            if (produtoSelecionado.compraItem()) carrinho.adicionaNoCarrinho(produtoSelecionado);
        } else {
            System.out.println("Código de produto inválido.");
        }
    }

    private Produto buscarProdutoPorCodigo(String codigo) {
        for (Produto item : produtos) {
            if (item.getCodigo().equals(codigo)) {
                return item;
            }
        }
        return null;
    }
}

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

    public void iniciarMaquinaDeVendas() {
        String msg = """
                
                ***************************************
                MAQUINA DE VENDAS, SELECIONE UMA OPÇÃO:
                1 - Listar produtos
                2 - Comprar produto
                3 - Listar meu carrinho
                4 - Sair""";

        int opcao = 0;
        Scanner sc = new Scanner(System.in);

        while (opcao != 4) {
            System.out.println(msg);
            opcao = sc.nextInt();

            switch (opcao) {
                case 1:
                    listarProdutos();
                    break;
                case 2:
                    comprarProduto();
                    break;
                case 3:
                    listarCarrinho();
                    break;
                case 4:
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        }
        sc.close();
    }

    private void inicializarProdutos() {
        produtos.add(new Produto("001", "Coca-cola", 3.00));
        produtos.add(new Produto("002", "Barra Cereal", 2.00));
        produtos.add(new Produto("003", "Pirulito", 0.50));
    }

    private void listarProdutos() {
        System.out.println("Produtos disponíveis: ");
        for (Produto item : produtos) {
            System.out.printf("Cód: %s - %s - R$ %.2f - Estoque: %sun%n", item.getCodigo(), item.getNome(), item.getPreco(), item.getQuantidade());
        }
    }

    private void listarCarrinho() {
        System.out.println("Meu carrinho: ");
        for (ItemCarrinho item : carrinho.getMeuCarrinho()) {
            System.out.printf("Cód: %s - %s - R$ %.2f - Quantidade: %d%n",
                    item.getProduto().getCodigo(),
                    item.getProduto().getNome(),
                    item.getProduto().getPreco(),
                    item.getQuantidade());
        }
    }

    private void comprarProduto() {
        System.out.println("Digite o código do produto que deseja comprar: ");
        listarProdutos();

        String codCompra;
        Scanner sc2 = new Scanner(System.in);
        codCompra = sc2.nextLine();

        boolean produtoEncontrado = false;

        for (Produto item : produtos) {
            if (codCompra.equals(item.getCodigo())) {
                item.compraItem();
                carrinho.adicionaProduto(item);
                produtoEncontrado = true;
                break;
            }
        }

        if (!produtoEncontrado) {
            System.out.println("Código de item inválido. Cancelando operação!");
        }
    }
}

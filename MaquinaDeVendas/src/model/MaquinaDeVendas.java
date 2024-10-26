package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MaquinaDeVendas {
    private List<Produto> produtos;

    public MaquinaDeVendas() {
        produtos = new ArrayList<>();
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
                    break;
                case 3:
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


}

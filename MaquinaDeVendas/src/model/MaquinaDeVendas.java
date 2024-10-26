package model;

import java.util.Scanner;

public class MaquinaDeVendas {

    public void iniciaMaquinaDeVendas() {
        String msg = """
                
                ***************************************
                MAQUINA DE VENDAS, SELECIONE UMA OPÇÃO:
                1 - Listar produtos
                2 - Comprar um produto
                3 - Listar compras
                4 - Sair""";

        int opcao = 0;
        Scanner sc = new Scanner(System.in);

        Produto coca_cola = new Produto("Coca-cola",3.00);
        Produto barraCereal = new Produto("Barra Cereal",2.00);
        Produto pirulito = new Produto("Pirulito",0.50);

        while (opcao != 4) {
            System.out.println(msg);
            opcao = sc.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println("Opcao 1");
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
}

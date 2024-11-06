package model;

public class Produto {
    private String codigo;
    private String nome;
    private double preco;
    private int quantidade;

    public String getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public boolean compraItem() {
        if (quantidade <= 0) {
            System.out.println("Não há estoque suficiente do item selecionado.");
            return false;
        } else {
            System.out.printf("Produto %s adicionado ao carrinho!", nome);
            quantidade--;
            return true;
        }
    }

    public void exibirDetalhes() {
        System.out.printf("Cód: %s - %s - R$ %.2f - Estoque: %d%n", codigo, nome, preco, quantidade);
    }

    public Produto(String codigo, String nome, double preco, int quantidade) {
        this.codigo = codigo;
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
    }
}

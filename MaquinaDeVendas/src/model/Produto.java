package model;

public class Produto {
    private String codigo;
    private String nome;
    private double preco;
    private int quantidade;

    public String getCodigo() { return codigo; }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public Produto(String codigo, String nome, double preco) {
        this.codigo = codigo;
        this.nome = nome;
        this.preco = preco;
        this.quantidade = 10;
    }
}

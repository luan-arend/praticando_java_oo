package model;

public class ItemCarrinho {
    private Produto produto;
    private int quantidade;

    public ItemCarrinho(Produto produto) {
        this.produto = produto;
        this.quantidade = 1;
    }

    public Produto getProduto() {
        return produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void incrementaQuantidade() {
        this.quantidade++;
    }
}
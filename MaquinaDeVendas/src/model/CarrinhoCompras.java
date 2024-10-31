package model;

import java.util.ArrayList;
import java.util.List;

public class CarrinhoCompras {
    private List<ItemCarrinho> meuCarrinho;

    public List<ItemCarrinho> getMeuCarrinho() {
        return meuCarrinho;
    }

    public void adicionaProduto(Produto produto) {
        for (ItemCarrinho item : meuCarrinho) {
            if (item.getProduto().getCodigo().equals(produto.getCodigo())) {
                item.incrementaQuantidade();
                return;
            }
        }
        meuCarrinho.add(new ItemCarrinho(produto));
    }

    public CarrinhoCompras() {
        meuCarrinho = new ArrayList<>();
    }
}

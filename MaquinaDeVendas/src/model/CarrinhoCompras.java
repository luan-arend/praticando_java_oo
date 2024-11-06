package model;

import java.util.ArrayList;
import java.util.List;

public class CarrinhoCompras {
    private List<ItemCarrinho> compras;

    public CarrinhoCompras() {
        compras = new ArrayList<>();
    }

    public List<ItemCarrinho> getCarrinho() {
        return compras;
    }

    public void adicionaNoCarrinho(Produto produto) {
        for (ItemCarrinho item : compras) {
            if (item.getProduto().getCodigo().equals(produto.getCodigo())) {
                item.incrementaQuantidade(); // Incrementa a quantidade do produto já existente
                return;
            }
        }
        compras.add(new ItemCarrinho(produto, 1));
    }
}

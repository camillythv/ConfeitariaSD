package org.example;

import java.io.Serializable;
import java.util.Objects;

public class Cardapio implements Serializable {
    private String nomeItem;
    private double precoItem;
    private String tipoItem;
    private int quantItem;

    public Cardapio(String nomeItem, double precoItem, String tipoItem, int quantItem) {
        this.nomeItem = nomeItem;
        this.precoItem = precoItem;
        this.tipoItem = tipoItem;
        this.quantItem = quantItem;
    }

    public String getNomeItem() {
        return nomeItem;
    }

    public void setNomeItem(String nomeItem) {
        this.nomeItem = nomeItem;
    }

    public double getPrecoItem() {
        return precoItem;
    }

    public void setPrecoItem(double precoItem) {
        this.precoItem = precoItem;
    }

    public String getTipoItem() {
        return tipoItem;
    }

    public void setTipoItem(String tipoItem) {
        this.tipoItem = tipoItem;
    }

    public int getQuantItem() {
        return quantItem;
    }

    public void setQuantItem(int quantItem) {
        this.quantItem = quantItem;
    }

    @Override
    public String toString() {
        return  "Item: " + nomeItem +
                " \n Preco: " + precoItem +
                " \n Tipo: " + tipoItem +
                " \n Quantidade: " + quantItem;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cardapio cardapio = (Cardapio) o;
        return Double.compare(precoItem, cardapio.precoItem) == 0  && Objects.equals(nomeItem, cardapio.nomeItem) && quantItem == cardapio.quantItem;
    }

    @Override
    public int hashCode() {
        return Objects.hash(nomeItem, precoItem, tipoItem, quantItem);
    }
}

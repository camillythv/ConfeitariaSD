package org.example;

import java.io.IOException;
import java.util.*;

public class SistemaCardapioMap implements SistemaCardapio {
    private Map<String, Cardapio> cardapio;

    private GravadorDeDados gravador = new GravadorDeDados();

    public SistemaCardapioMap(){
        this.cardapio = new HashMap<>();
        recuperaCardapio();
    }

    public void salvarCardapio(){
        try{
            this.gravador.salvarCardapio(this.cardapio);
        }catch (Exception e){
            System.err.println(e.getMessage());
        }
    }

    public void recuperaCardapio(){
        try {
            this.cardapio = this.gravador.recuperaCardapio();
        }catch (IOException e){
            System.err.println(e.getMessage());
        }
    }


    @Override
    public boolean cadastrarItem(String nomeItem, double precoItem, String tipoItem, int quantItem) throws ExceptionJaCadastrado {
        if(!cardapio.containsKey(nomeItem)){
            this.cardapio.put(nomeItem, new Cardapio(nomeItem, precoItem, tipoItem, quantItem));
            return true;
        }else{
            throw new ExceptionJaCadastrado("Esse item já foi cadastrado!");
        }
    }

    @Override
    public boolean removerItem(String nomeItem) {
        if(this.cardapio.containsKey(nomeItem)){
            this.cardapio.remove(nomeItem);
            return true;
        }else{
            return false;
        }
    }

    @Override
    public Collection<Cardapio> listarItens() {
        Collection<Cardapio> listaItens = new ArrayList<>();
        for (Cardapio c: this.cardapio.values())
            listaItens.add(c);
        return listaItens;
    }

    @Override
    public Collection<Cardapio> pesquisaPorNomeETipo(String nomeItem, String tipoItem) {
        Collection<Cardapio> itensPesquisados = new ArrayList<>();
        for (Cardapio c: this.cardapio.values()){
            if(c.getNomeItem().equals(nomeItem) || c.getTipoItem().equals(tipoItem)){
                itensPesquisados.add(c);
            }
        }
        return itensPesquisados;
    }

    @Override
    public int quantidadeEmEstoque() {
        int QuantTotal = 0;
        for(Cardapio c : cardapio.values()) {
            QuantTotal += c.getQuantItem();
        }
        return QuantTotal;
    }
    @Override
    public ArrayList<Cardapio> Encomendar(String nomeItem, int quantItem) throws ExceptionJaCadastrado {
        ArrayList<Cardapio> encomendas = new ArrayList<>();
        if(!cardapio.containsKey(nomeItem)){
            encomendas.add(this.cardapio.get(nomeItem));
            encomendas.add(this.cardapio.get(quantItem));
            return encomendas;
        }else{
            throw new ExceptionJaCadastrado("Esse item já foi cadastrado!");
        }
    }
    /**@Override
    public ArrayList<Cardapio> VerEncomendas() {
        ArrayList<Cardapio> listaEncomendas = new ArrayList<>();
        this.cardapio(Encomendar());
        for (Cardapio c: ){
            listaEncomendas.add(c);
        }
        return listaEncomendas;
    }*/
}

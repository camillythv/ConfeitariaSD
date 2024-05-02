package org.example;
import java.util.ArrayList;
import java.util.Collection;

public interface SistemaCardapio {

    boolean cadastrarItem(String nomeItem, double precoItem, String tipoItem, int quantItem) throws ExceptionJaCadastrado;

    boolean removerItem(String nomeItem);

    Collection<Cardapio> listarItens();

    Collection<Cardapio> pesquisaPorNomeETipo(String nomeItem, String tipoItem);

    void recuperaCardapio();

    void salvarCardapio();

    int quantidadeEmEstoque();

    ArrayList<Cardapio> Encomendar(String nomeItem, int quantItem) throws ExceptionJaCadastrado //Resolver um novo cadastro para encomendar  e dps listalas
    ;

    //<Cardapio> VerEncomendas();
}
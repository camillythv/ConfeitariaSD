package org.example;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collection;

public class ControlePesquisar implements ActionListener {
    private SistemaCardapio cardapio;
    private JFrame janelaPrincipal;

    SistemaCardapioMap sistemaCardapioMap = new SistemaCardapioMap();

    public ControlePesquisar(SistemaCardapio cardapio, JFrame janela){
        this.cardapio = cardapio;
        this.janelaPrincipal = janela;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        sistemaCardapioMap.recuperaCardapio();
        String nomeItem = JOptionPane.showInputDialog(janelaPrincipal,"informe o nome do item", "Procura em cardapio",JOptionPane.DEFAULT_OPTION);
        String tipoItem = JOptionPane.showInputDialog(janelaPrincipal,"informe o tipo do item", "Procura em cardapio",JOptionPane.DEFAULT_OPTION);
        Collection<Cardapio> cardapios = cardapio.pesquisaPorNomeETipo(nomeItem, tipoItem);
        if(cardapios.size()>0){
            for(Cardapio c: cardapios){
                JOptionPane.showMessageDialog(janelaPrincipal,c.toString(),"Procura em Cardapio", JOptionPane.DEFAULT_OPTION);
            }
        }else{
            JOptionPane.showMessageDialog(janelaPrincipal,"Não foi encontrado nenhuma item no cardapio.", "Procura em Cardapio", JOptionPane.DEFAULT_OPTION);

        }
    }
}

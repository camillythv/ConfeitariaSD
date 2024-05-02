package org.example;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControleRemover implements ActionListener {
    private SistemaCardapio cardapio;
    private JFrame janelaPrincipal;

    public ControleRemover(SistemaCardapio cardapio,JFrame janela) {
        this.cardapio = cardapio;
        this.janelaPrincipal = janela;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String nomeItem =  JOptionPane.showInputDialog(janelaPrincipal,"Qual o nome do item?", "Remoção do cardapio", JOptionPane.DEFAULT_OPTION);
        boolean removeu = cardapio.removerItem(nomeItem);
        if(removeu){
            JOptionPane.showMessageDialog(janelaPrincipal,"Item removido","Remoção do cardapio",JOptionPane.DEFAULT_OPTION);
        }else{
            JOptionPane.showMessageDialog(janelaPrincipal,"Item não foi encontrado."+"\nOperação não realizada!","Remoção do Estoque",JOptionPane.DEFAULT_OPTION);
        }
    }
}

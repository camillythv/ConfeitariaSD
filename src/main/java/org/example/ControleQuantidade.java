package org.example;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collection;
import java.util.*;

public class ControleQuantidade implements ActionListener {

    private SistemaCardapio cardapio;
    private JFrame janelaPrincipal;
    SistemaCardapioMap sistemaCardapioMap = new SistemaCardapioMap();

    public ControleQuantidade(SistemaCardapio cardapio,JFrame janela){
        this.cardapio = cardapio;
        this.janelaPrincipal = janela;
    }

    @Override
    public void actionPerformed(ActionEvent e){
        sistemaCardapioMap.recuperaCardapio();
        JOptionPane.showMessageDialog(janelaPrincipal, "Quantidade em catálogo: " + this.cardapio.quantidadeEmEstoque() , "Quantidade", JOptionPane.INFORMATION_MESSAGE);
    }
}

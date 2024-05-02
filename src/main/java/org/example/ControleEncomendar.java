package org.example;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collection;

public class ControleEncomendar implements ActionListener {
    private SistemaCardapio cardapio;
    private JFrame janelaPrincipal;

    public ControleEncomendar(SistemaCardapio cardapio,JFrame janela){
        this.cardapio = cardapio;
        this.janelaPrincipal = janela;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String nomeItem = JOptionPane.showInputDialog(janelaPrincipal, "Item a solicitar: ", "Encomendar", JOptionPane.DEFAULT_OPTION);
        int quantItem = Integer.parseInt(JOptionPane.showInputDialog(janelaPrincipal,"Quantidade requisitada: ", "Encomendar", JOptionPane.DEFAULT_OPTION));
        try{
            ArrayList cadastrou = cardapio.Encomendar(nomeItem,quantItem);
            JOptionPane.showMessageDialog(janelaPrincipal, "Encomenda concluida", "Encomendando Item", JOptionPane.INFORMATION_MESSAGE);
            JOptionPane.showMessageDialog(janelaPrincipal,  "Item: " + nomeItem + "\nQuantidade: " + quantItem, "Encomendar", JOptionPane.PLAIN_MESSAGE);
        } catch (ExceptionJaCadastrado ex) {
            JOptionPane.showMessageDialog(janelaPrincipal, "Item Já foi Encomendado!  " , "Encomendando Item", JOptionPane.INFORMATION_MESSAGE);
            throw new RuntimeException(ex);
        }


    }
}


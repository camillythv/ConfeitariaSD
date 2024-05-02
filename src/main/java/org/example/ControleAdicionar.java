package org.example;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControleAdicionar implements ActionListener {

    private SistemaCardapioMap cardapio;
    private JFrame janelaPrincipal;
    public ControleAdicionar(SistemaCardapioMap cardapio, JFrame janela){
        this.cardapio= cardapio;
        this.janelaPrincipal = janela;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String nomeItem = JOptionPane.showInputDialog(janelaPrincipal, "Nome do Item: ", "Cadastrando Item", JOptionPane.INFORMATION_MESSAGE);
        double precoItem = Double.parseDouble(JOptionPane.showInputDialog(janelaPrincipal, "Preço do Item:", "Cadastrando Item", JOptionPane.INFORMATION_MESSAGE));
        String tipoItem = JOptionPane.showInputDialog(janelaPrincipal, "Tipo do Item: ", "Cadastrando Item", JOptionPane.INFORMATION_MESSAGE);
        int quantItem = Integer.parseInt(JOptionPane.showInputDialog("Quantidade de itens: ", JOptionPane.INFORMATION_MESSAGE));
        try{
            boolean cadastrou = cardapio.cadastrarItem(nomeItem, precoItem, tipoItem,quantItem);
            JOptionPane.showMessageDialog(janelaPrincipal, "Item Cadastrada", "Cadastrando Item", JOptionPane.INFORMATION_MESSAGE);
        } catch (ExceptionJaCadastrado ex) {
            JOptionPane.showMessageDialog(janelaPrincipal, "Item não foi cadastrada!  " + "\nVerifique se já não existia", "Cadastrando Item", JOptionPane.INFORMATION_MESSAGE);
            throw new RuntimeException(ex);
        }
    }
}

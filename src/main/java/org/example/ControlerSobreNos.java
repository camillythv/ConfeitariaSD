package org.example;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControlerSobreNos implements ActionListener {
    private SistemaCardapio cardapio;
    private JFrame janelaPrincipal;

    public ControlerSobreNos(SistemaCardapio cardapio,JFrame janela) {
        this.cardapio = cardapio;
        this.janelaPrincipal = janela;
    }

    public void actionPerformed(ActionEvent e) {
        JOptionPane.showMessageDialog(janelaPrincipal, "Confeitaria - Sweet Dreams   \n"  + "\nFundadores: \n• Camilly Cabral •" +
                "\n• Emanuely Ribeiro •     \n" + "\nA Sweet Dreams é uma confeitaria familiar que começou como \num hobby e se transformou em um negócio.         \nCada doce, bolo e sobremesa carregam histórias e memórias," +
                "\nfeitos com ingredientes selecionados e receitas preparadas \ncom cuidado e dedicação.  ", "Quem Somos?", JOptionPane.PLAIN_MESSAGE);
    }

}

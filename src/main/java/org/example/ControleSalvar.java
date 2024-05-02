package org.example;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControleSalvar implements ActionListener {
    private SistemaCardapio cardapio;
    private JFrame janelaPrincipal;

    public ControleSalvar(SistemaCardapio cardapio, JFrame janelaPrincipal){
        this.cardapio = cardapio;
        this.janelaPrincipal = janelaPrincipal;
    }
    public void actionPerformed(ActionEvent e) {
        cardapio.salvarCardapio();
        JOptionPane.showMessageDialog(janelaPrincipal, "Dados Sincronizados com Sucesso!", "Salvamento", JOptionPane.INFORMATION_MESSAGE);
    }
}

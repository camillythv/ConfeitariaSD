package org.example;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collection;

public class ControleListar implements ActionListener {

    private SistemaCardapio cardapio;
    private JFrame janelaPrincipal;

    SistemaCardapioMap sistemaCardapioMap = new SistemaCardapioMap();

    public ControleListar (SistemaCardapio cardapio, JFrame janela){
        this.cardapio = cardapio;
        this.janelaPrincipal = janela;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        sistemaCardapioMap.listarItens();
        Collection<Cardapio> cardapios = cardapio.listarItens();
        if(cardapios.size() == 0) {
            JOptionPane.showMessageDialog(null,"Nenhum item cadastrado no cardapio","Cardapio", JOptionPane.INFORMATION_MESSAGE);
        }else{
            JOptionPane.showMessageDialog(janelaPrincipal,"Cardapio: \n" + cardapios,"Cardapio", JOptionPane.INFORMATION_MESSAGE);
        }
    }
}

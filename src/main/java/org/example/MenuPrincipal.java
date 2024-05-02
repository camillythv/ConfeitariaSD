package org.example;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class MenuPrincipal extends JFrame {
    JLabel linha1,linha2;
    private SistemaCardapio cardapio;
    SistemaCardapioMap sistemaCardapioMap = new SistemaCardapioMap();

    ControleSalvar gravaCardapio;
    ImageIcon LogoSD = new ImageIcon("./src/main/resources/LOGOSD1.2.jpg");
    public MenuPrincipal() {
        setTitle("Confeitaria - Sweet Dreams");
        setSize(1200, 1200);
        setLocation(400,400);
        setResizable(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.cardapio = new SistemaCardapioMap();
        gravaCardapio = new ControleSalvar(sistemaCardapioMap, this);

        linha1 = new JLabel("", JLabel.CENTER);
        linha2 = new JLabel(LogoSD, JLabel.CENTER);

        getContentPane().setLayout(new GridLayout());
        getContentPane().add(linha1);
        getContentPane().add(linha2);
        getContentPane().add(new JLabel());

        JMenuBar menuBar = new JMenuBar();
        JMenu menuCardapio = new JMenu("Cardápio");
        JMenu menuPesquisar = new JMenu("Pesquisar");
        JMenu menuConfiguracoes = new JMenu("Configurações");
        JMenu menuEncomendas = new JMenu("Encomendas");
        JMenu menuSobreNos = new JMenu("Sobre Nós");


        JMenuItem itemCadastrar = new JMenuItem("Cadastrar Item");
        JMenuItem itemListar = new JMenuItem("Listar Itens");
        JMenuItem itemPesquisar = new JMenuItem("Pesquisar Item");
        JMenuItem itemRemover = new JMenuItem("Remover item");
        JMenuItem itemSalvar = new JMenuItem("Salvar");
        JMenuItem itemQuantidade = new JMenuItem("Quantidade");
        JMenuItem itemEncomendar = new JMenuItem("Encomendar");
        JMenuItem itemSobreNos = new JMenuItem("Sobre Nós");

        menuCardapio.add(itemCadastrar);
        menuCardapio.add(itemListar);

        menuPesquisar.add(itemPesquisar);
        menuPesquisar.add(itemQuantidade);

        menuConfiguracoes.add(itemSalvar);
        menuConfiguracoes.add(itemRemover);

        menuEncomendas.add(itemEncomendar);

        menuSobreNos.add(itemSobreNos);

        menuBar.add(menuCardapio);
        menuBar.add(menuPesquisar);
        menuBar.add(menuConfiguracoes);
        menuBar.add(menuEncomendas);
        menuBar.add(menuSobreNos);

        setJMenuBar(menuBar);

        itemCadastrar.addActionListener(new ControleAdicionar(sistemaCardapioMap, this));

        //Exemplo alternativo de expressão lambda
        /**itemCadastrar.addActionListener(
                (ae) -> {
                    String nomeItem = JOptionPane.showInputDialog(this,
                            "");
                    double precoItem = Integer.parseInt(JOptionPane.showInputDialog(this,
                            ""));
                    String tipoItem = JOptionPane.showInputDialog(this,
                            "");
                    int quantItem = Integer.parseInt(JOptionPane.showInputDialog(this,
                            ""));
                    boolean cadastrou = false;
                    try{
                        cadastrou = SistemaCardapioMap.cadastrarItem(nomeItem, precoItem, tipoItem, quantItem);
                        JOptionPane.showMessageDialog(this,
                                        "Aniversariante cadastrado");
                    } catch (ExceptionJaCadastrado e) {
                        JOptionPane.showMessageDialog(this,
                                "Aniversariante não foi cadastrado. " +
                                        "Verifique se já não existia");
                    }
                });*/

        itemListar.addActionListener(new ControleListar(sistemaCardapioMap,this));

        itemPesquisar.addActionListener(new ControlePesquisar(sistemaCardapioMap, this));

        itemRemover.addActionListener(new ControleRemover(sistemaCardapioMap, this));

        itemSalvar.addActionListener(new ControleSalvar(sistemaCardapioMap, this));

        itemQuantidade.addActionListener(new ControleQuantidade(sistemaCardapioMap,this));

        itemEncomendar.addActionListener(new ControleEncomendar(sistemaCardapioMap, this));

        itemSobreNos.addActionListener(new ControlerSobreNos(sistemaCardapioMap, this));
    }


    public static void main(String[] args) {
        JFrame janela = new MenuPrincipal();
        janela.setVisible(true);
        janela.setExtendedState(JFrame.MAXIMIZED_BOTH);
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

package org.example;

import static org.junit.jupiter.api.Assertions.*;
import org.testng.annotations.Test;

import java.io.File;

public class TesteConfeitaria {
    @Test
    public void TesteAdicionar() {
        SistemaCardapioMap ConfeitariaSD = new SistemaCardapioMap();
        try {
            ConfeitariaSD.cadastrarItem("Coxinha",3.0,"Salgado",50);
        } catch (ExceptionJaCadastrado e) {
            fail("Não deveria lançar exceção");
        }
        try {
            ConfeitariaSD.cadastrarItem("Coxinha",3.0,"Salgado",30);
            fail("Era pra ter lançado a execeção ou cadastrado novamente");
        } catch (ExceptionJaCadastrado e) {
        }
    }
    @Test
    public void TestaPesquisaBebidas() {
        SistemaCardapioMap ConfeitariaSD = new SistemaCardapioMap();
        try {
            ConfeitariaSD.cadastrarItem("Empada", 3.50, "Salgado",10);
            ConfeitariaSD.cadastrarItem("Torta", 15.00, "Sobremesa",30);
            assertEquals(1, ConfeitariaSD.pesquisaPorNomeETipo("Empada","Salgado").size());
        } catch (ExceptionJaCadastrado e) {
            fail("Não deveria lançar execeção");
        }try{
            ConfeitariaSD.cadastrarItem("Empada",3.50, "Salgado",40);
        }catch (ExceptionJaCadastrado e){
        }
    }
    @Test
    public void TestaListarBebidas(){
        SistemaCardapioMap ConfeitariaSD = new SistemaCardapioMap();
        assertEquals(0,ConfeitariaSD.listarItens().size());
        try{
            ConfeitariaSD.cadastrarItem("Torta", 15.00, "Sobremesa",10);
            ConfeitariaSD.cadastrarItem("Coxinha", 3.00, "Salgado",50);
            ConfeitariaSD.cadastrarItem("CocaCola", 7.00, "Bebida",30);
            assertEquals(3,ConfeitariaSD.listarItens().size());
        }catch (ExceptionJaCadastrado e){
            fail("Não deveria lançar execeção");
        }
    }
    @Test
    public void TestaGravador() {
        File f = new File(GravadorDeDados.ARQUIVO_CARDAPIO);
        if (f.exists()) {
            f.delete();
        }
        SistemaCardapioMap ConfeitariaSD = new SistemaCardapioMap();
        try {
            ConfeitariaSD.cadastrarItem("Torta de limão", 17.00, "Sobremesa",5);
            ConfeitariaSD.salvarCardapio();
            assertEquals(1, ConfeitariaSD.pesquisaPorNomeETipo("Torta de limão","Sobremesa").size());
            assertTrue(f.exists());
            f.delete();
        } catch (ExceptionJaCadastrado e) {
        }
    }
    @Test
    public void TestRemoverBebidas() {
        SistemaCardapioMap ConfeitariaSD = new SistemaCardapioMap();
        try {
            ConfeitariaSD.cadastrarItem("Brigadeiro", 2.00, "Sobremesa",10);
            ConfeitariaSD.cadastrarItem("CocaCola", 7.00, "Bebida",20);
            assertEquals(2, ConfeitariaSD.listarItens().size());
            ConfeitariaSD.removerItem("Brigadeiro");
            assertEquals(1, ConfeitariaSD.listarItens().size());
        } catch (ExceptionJaCadastrado e) {
        }
    }
}

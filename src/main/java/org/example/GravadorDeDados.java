package org.example;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class GravadorDeDados {

    public static final String ARQUIVO_CARDAPIO = "cardapio.txt";

    public HashMap<String, Cardapio> recuperaCardapio() throws IOException {
        ObjectInputStream in = null;
        try{
            in = new ObjectInputStream(new FileInputStream(ARQUIVO_CARDAPIO));
            return (HashMap<String, Cardapio>) in.readObject();
        } catch (Exception e){
            System.out.println("Não foi possível recuperar os dados do cardapio salvos");
            throw new IOException("Não foi possível recuperar os dados do arquivo "+ARQUIVO_CARDAPIO);

        } finally {
            if (in!=null){
                in.close();
            }
        }

    }
    public void salvarCardapio(Map<String, Cardapio> cardapio) throws IOException{

        ObjectOutputStream out = null;
        try {
            out = new ObjectOutputStream(new FileOutputStream(ARQUIVO_CARDAPIO));
            out.writeObject(cardapio);
            System.out.println("salvou");
        } catch (Exception e){
            e.printStackTrace();
            throw new IOException("Erro ao salvar os dados do cardapio no arquivo "+ARQUIVO_CARDAPIO);
        }finally{
            if(out != null){
                out.close();
            }
        }

    }
}

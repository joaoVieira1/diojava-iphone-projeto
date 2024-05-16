package Apps;

import Erros.ContatoInexistente;
import Erros.ListaContatosVazia;
import Interfaces.TelefoneAcoes;
import Modelos.Contato;

import java.util.ArrayList;
import java.util.Random;

public class AgendaContatos implements TelefoneAcoes {
    ArrayList<Contato> listaContatos = new ArrayList<>();
    private boolean ligacao = false;

    @Override
    public void ligarContato(String numero) {
        int flag = 0;
        for(Contato contato : listaContatos){
            if(contato.getNumero().equals(numero)){
                System.out.println("Ligando para: " + contato);
                if(atendeu()){
                    System.out.println("Você está em ligação com: " + contato);
                }else{
                    System.out.println(contato + " não atendeu sua ligação!");
                }
                flag = 1;
            }
        }

        if(flag == 0){
            throw new ContatoInexistente();
        }
    }

    @Override
    public void desligarContato() {
        if(atendeu()){
            System.out.println("Desligando chamada.");
            ligacao = false;
        }else{
            System.out.println("Você não está em ligação!");
        }

    }

    @Override
    public void iniciarCorreioVoz(String nome) {
        int flag = 0;
        for(Contato contato : listaContatos){
            if(contato.getNome().equals(nome)){
                System.out.println("Iniciando correio de voz para: " + contato);
                flag = 1;
            }
        }

        if(flag == 0){
            throw new ContatoInexistente();
        }
    }

    @Override
    public void adicionarContato(String nome, String numero) {
        listaContatos.add(new Contato(nome, numero));
    }

    @Override
    public void excluirContato(String nome, String numero) {
        int flag = 0;
        for(Contato contato : listaContatos){
            if(contato.getNome().equals(nome) && contato.getNumero().equals(numero)){
                listaContatos.remove(contato);
                System.out.println("Contato: " + contato + " excluido!");
                flag = 1;
            }
        }

        if(flag == 0){
            throw new ContatoInexistente();
        }
    }

    public void mostrarContatos(){
        if(!listaContatos.isEmpty()){
            System.out.println("LISTA DE CONTATOS");
            for(Contato contato : listaContatos){
                System.out.println(contato);
            }
        }else{
            throw new ListaContatosVazia();
        }
    }

    private boolean atendeu(){
        int flag = 0;
        Random gerador = new Random();
        for(int i = 0; i < 3; i++){
            flag = gerador.nextInt(4);

            if(flag == 3){
                ligacao = true;
            }
        }

        return ligacao;
    }

}

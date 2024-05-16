package Apps;

import Erros.ListaMusicasVazia;
import Erros.MusicaInexistente;
import Interfaces.MusicaAcoes;
import Modelos.Musica;

import java.util.ArrayList;

public class ReprodutorMusical implements MusicaAcoes {
    ArrayList<Musica> listaMusicas = new ArrayList<Musica>();
    private int musicaAtual = 0;
    private boolean tocando = false;

    @Override
    public void tocarMusica() {
        if(!listaMusicas.isEmpty()){
            if(!tocando){
                System.out.println("Tocando " + listaMusicas.get(musicaAtual));
                tocando = true;
            }else{
                System.out.println("A música " + listaMusicas.get(musicaAtual) + " já está em reprodução!");
            }
        }else{
            throw new MusicaInexistente();
        }

    }

    @Override
    public void pausarMusica() {
        if(!listaMusicas.isEmpty()){
            if(tocando){
                System.out.println("Pausando " + listaMusicas.get(musicaAtual));
                tocando = false;
            }else{
                System.out.println("A música " + listaMusicas.get(musicaAtual) + " já está pausada!");
            }
        }else{
            throw new MusicaInexistente();
        }
    }

    @Override
    public void selecionarMusica(String nome) {
        int flag = 0;
        for(int i = 0; i < listaMusicas.size(); i++){
            if(listaMusicas.get(i).getNome().equals(nome)){
                musicaAtual = i;
                System.out.print("Música selecionada: ");
                mostrarMusicalAtual();
                flag = 1;
            }
        }

        if(flag == 0){
            throw new MusicaInexistente();
        }
    }

    @Override
    public void adicionarMusica(String nome, String artista, String genero, String tempoDuracao) {
        listaMusicas.add(new Musica(nome, artista, genero, tempoDuracao));
    }

    @Override
    public void excluirMusica(String nome) {
        int flag = 0;
        for(Musica musica : listaMusicas){
            if(musica.getNome().equals(nome)){
                listaMusicas.remove(musica);
                System.out.println("Música: " + musica + " excluida!");
                flag = 1;
            }
        }

        if(flag == 0){
            throw new MusicaInexistente();
        }
    }

    @Override
    public void passarMusica() {
        if(!listaMusicas.isEmpty()){
            if(musicaAtual == listaMusicas.size() - 1){
                musicaAtual = 0;
                System.out.print("Música atual: ");
                mostrarMusicalAtual();
            }else{
                musicaAtual++;
                System.out.print("Música atual: ");
                mostrarMusicalAtual();
            }
        }else{
            throw new MusicaInexistente();
        }
    }

    @Override
    public void voltarMusica() {
        if(!listaMusicas.isEmpty()){
            if(musicaAtual == 0){
                musicaAtual = listaMusicas.size() - 1;
                System.out.print("Música atual: ");
                mostrarMusicalAtual();
            }else{
                musicaAtual--;
                System.out.print("Música atual: ");
                mostrarMusicalAtual();
            }
        }else{
            throw new MusicaInexistente();
        }
    }

    public void mostrarMusicas(){
        if(!listaMusicas.isEmpty()){
            System.out.println("LISTA DE MÚSICAS");
            for(Musica musica :listaMusicas){
                System.out.println(musica);
            }
        }else{
            throw new ListaMusicasVazia();
        }
    }

    private void mostrarMusicalAtual(){
        if(!listaMusicas.isEmpty()){
            System.out.println(listaMusicas.get(musicaAtual));
        }else{
            throw new MusicaInexistente();
        }
    }
    
}

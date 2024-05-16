package Modelos;

import Erros.TempoDuracaoInvalido;

public class Musica {
    //atributos
    private String nome;
    private String artista;
    private String tempoDuracao;
    private String genero;

    //construtor
    public Musica(String nome, String artista, String genero, String tempoDuracao){
        setNome(nome);
        setArtista(artista);
        setGenero(genero);
        setTempoDuracao(tempoDuracao);
    }

    //getters and setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }

    public String getTempoDuracao() {
        return tempoDuracao;
    }

    public void setTempoDuracao(String tempoDuracao) {
        if(tempoDuracao.matches("\\d{2}:\\d{2}")){
            this.tempoDuracao = tempoDuracao;
        }else{
            throw new TempoDuracaoInvalido();
        }

    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    //métodos
    @Override
    public String toString(){
        return getNome() + " - " + getArtista() + " - " + getGenero() + " - " + getTempoDuracao();
    }

}

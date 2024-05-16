package Modelos;

import Erros.TelefoneInvalido;

public class Contato {
    //atributos
    private String nome;
    private String numero;

    //construtor
    public Contato(String nome, String numero){
        setNome(nome);
        setNumero(numero);
    }

    //getters and setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        if(numero.matches("\\(\\d{2}\\)\\d{4,5}-\\d{4}")){
            this.numero = numero;
        }else{
            throw new TelefoneInvalido();
        }
    }

    //métodos
    @Override
    public String toString(){
        return getNome() + " - " + getNumero();
    }

}

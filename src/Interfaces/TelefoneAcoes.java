package Interfaces;

public interface TelefoneAcoes {

    public void ligarContato(String numero);
    public void desligarContato();
    public void iniciarCorreioVoz(String nome);
    public void adicionarContato(String nome, String numero);
    public void excluirContato(String nome, String numero);

}

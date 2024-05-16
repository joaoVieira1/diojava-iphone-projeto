package Interfaces;

public interface MusicaAcoes {

    public void tocarMusica();
    public void pausarMusica();
    public void selecionarMusica(String nome);
    public void adicionarMusica(String nome, String artista, String genero, String tempoDuracao);
    public void excluirMusica(String nome);
    public void passarMusica();
    public void voltarMusica();

}

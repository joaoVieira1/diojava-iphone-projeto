import Sistema.Iphone;

public class Main {
    public static void main(String[] args) {
        Iphone celular = new Iphone("X");

        celular.internet.adicionarNovaPagina("Youtube");
        celular.internet.adicionarNovaPagina("Twitter");
        celular.internet.adicionarNovaPagina("Facebook");
        celular.internet.mostrarHistorico();

        celular.ipod.adicionarMusica("TENDENCISA", "Veigh", "trap", "02:25");
        celular.ipod.tocarMusica();

        celular.telefone.adicionarContato("João", "(16)99215-5796");
        celular.telefone.ligarContato("(16)99215-5796");
        celular.telefone.desligarContato();

    }
}

package Apps;

import Erros.HistoricoVazio;
import Erros.PaginaInexistente;
import Interfaces.InternetAcoes;

import java.util.Stack;

public class Browser implements InternetAcoes {
    Stack<String> historico = new Stack<String>();
    private int paginaAtual = 0;

    @Override
    public void exibirPagina() {
        if(!historico.empty()){
            System.out.println("Exibindo página: " + historico.get(historico.size() - 1));
        }else{
            throw new PaginaInexistente();
        }
    }

    @Override
    public void adicionarNovaPagina(String pagina) {
        historico.add(pagina);
    }

    @Override
    public void atualizarPagina() {
        if(!historico.empty()){
            System.out.println("Pagina " + historico.get(paginaAtual) + " atualizada!");
        }else{
            throw new PaginaInexistente();
        }
    }

    public void mostrarHistorico(){
        if(historico.empty()){
            throw new HistoricoVazio();
        }

        System.out.println("HISTÓRICO DE PÁGINAS");
        for(int i = historico.size() - 1; i >= 0; i--){
            System.out.println("  -" + historico.get(i));
        }

    }

    public void exibirPagina(String pagina){
        int flag = 0;
        for(int i = 0; i < historico.size(); i++){
            if(historico.get(i).equals(pagina)){
                paginaAtual = i;
                System.out.println("Exibindo página: " + historico.get(i));
                flag = 1;
            }
        }

        if(flag == 0){
            throw new PaginaInexistente();
        }
    }

    public void voltarPagina(){
        if(!historico.empty()){
            if(paginaAtual == 0){
                paginaAtual = historico.size() - 1;
                System.out.print("Página atual: ");
                mostrarPaginaAtual();
            }else{
                paginaAtual--;
                System.out.print("Página atual: ");
                mostrarPaginaAtual();
            }
        }else{
            throw new PaginaInexistente();
        }
    }

    public void avancarPagina(){
        if(!historico.empty()){
            if(paginaAtual == historico.size() - 1){
                paginaAtual = 0;
                System.out.print("Página atual: ");
                mostrarPaginaAtual();
            }else{
                paginaAtual++;
                System.out.print("Página atual: ");
                mostrarPaginaAtual();
            }
        }else{
            throw new PaginaInexistente();
        }
    }

    private void mostrarPaginaAtual(){
        if(!historico.isEmpty()){
            System.out.println("Pagina: " + historico.get(paginaAtual));
        }else{
            throw new PaginaInexistente();
        }
    }

    public void excluirPagina(String nome) {
        int flag = 0;
        for(String pagina : historico){
            if(pagina.equals(nome)){
                historico.remove(pagina);
                System.out.println("Página: " + pagina + " excluida!");
                flag = 1;
            }
        }

        if(flag == 0){
            throw new PaginaInexistente();
        }
    }

}

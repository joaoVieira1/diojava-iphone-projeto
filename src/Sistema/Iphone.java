package Sistema;

import Apps.AgendaContatos;
import Apps.Browser;
import Apps.ReprodutorMusical;
import Erros.BrilhoInvalido;
import Erros.VolumeInvalido;

public class Iphone {
    private String modelo;
    private int volume;
    private int brilho;
    private boolean ligado;
    public ReprodutorMusical ipod = new ReprodutorMusical();
    public AgendaContatos telefone = new AgendaContatos();
    public Browser internet = new Browser();

    public Iphone(String modelo){
        this.modelo = modelo;
        setVolume(50);
        setBrilho(50);
        setLigado(false);
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        if(volume >= 0 && volume <= 100){
            this.volume = volume;
        }else{
            throw new VolumeInvalido();
        }

    }

    public int getBrilho() {
        return brilho;
    }

    public void setBrilho(int brilho) {
        if(brilho >= 0 && brilho <= 100){
            this.brilho = brilho;
        }else{
            throw new BrilhoInvalido();
        }

    }

    public boolean isLigado() {
        return ligado;
    }

    public void setLigado(boolean ligado) {
        this.ligado = ligado;
    }

    public String getModelo(){
        return modelo;
    }

    public void aumentarVolume(){
        if(ligado){
            setVolume(getVolume() + 1);
        }else{
            System.out.println("Ligar dispositivo!");
        }
    }

    public void diminuirVolume(){
        if(ligado){
            setVolume(getVolume() - 1);
        }else{
            System.out.println("Ligar dispositivo!");
        }
    }

    public void aumentarBrilho(){
        if(ligado){
            setBrilho(getBrilho() + 1);
        }else{
            System.out.println("Ligar dispositivo!");
        }
    }

    public void diminuirBrilho(){
        if(ligado){
            setBrilho(getBrilho() - 1);
        }else{
            System.out.println("Ligar dispositivo!");
        }
    }

    public boolean ligar(){
        if(!ligado){
            setLigado(true);
        }else{
            System.out.println("O aparelho já está ligado!");
        }

        return ligado;
    }

    public boolean desligar(){
        if(ligado){
            setLigado(false);
        }else{
            System.out.println("O aparelho já está desligado!");
        }

        return ligado;
    }

}

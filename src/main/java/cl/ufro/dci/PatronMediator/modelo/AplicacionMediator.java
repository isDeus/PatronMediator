package cl.ufro.dci.PatronMediator.modelo;

import com.google.zxing.WriterException;

import java.io.IOException;

public class AplicacionMediator {

    private static AplicacionMediator aplicacionMediator;

    public GeneradorQR generadorQR;
    public String codigoQR;
    public ControladorMovil controladorMovil;

    public static AplicacionMediator getInstance() throws IOException, WriterException {
        if (aplicacionMediator == null) {
            aplicacionMediator = new AplicacionMediator();
        }
        return aplicacionMediator;
    }

    public AplicacionMediator() throws IOException, WriterException {
        generadorQR = new GeneradorQR(this);
        controladorMovil = new ControladorMovil(this);
        generarCodigoInicial();
    }

    public String generarCodigoInicial() throws IOException, WriterException {
       return codigoQR = generadorQR.generarBase64Image();
    }

    public void confirmarApp() throws IOException, WriterException {
        this.controladorMovil.confirmar();
    }

    public void denegarApp(){
        this.controladorMovil.denegar();
    }

    public void confirmarAsistencia() throws IOException, WriterException {
        //Introducir codigo aleatorio para asi que sea diferente siempre
        this.codigoQR = this.generadorQR.generarImage("sadsadasdsadsa");
    }

    public String getCodigoQR(){
        return this.codigoQR;
    }


}

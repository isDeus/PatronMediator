package cl.ufro.dci.PatronMediator.modelo;

import com.google.zxing.WriterException;

import java.io.IOException;

public class ControladorMovil {

    public boolean confirmacionAsistencia = false;
    private AplicacionMediator aplicacionMediator;

    public ControladorMovil(AplicacionMediator aplicacionMediator) throws IOException, WriterException {
        this.aplicacionMediator = aplicacionMediator;
    }

    public void confirmar() throws IOException, WriterException {
        aplicacionMediator.confirmarAsistencia();
        confirmacionAsistencia = true;
    }

    public void denegar(){
        confirmacionAsistencia = false;
    }

    public boolean isConfirmado(){
        return this.confirmacionAsistencia;
    }
}

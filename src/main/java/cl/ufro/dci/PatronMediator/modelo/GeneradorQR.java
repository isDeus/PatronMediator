package cl.ufro.dci.PatronMediator.modelo;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Base64;

public class GeneradorQR {

    private AplicacionMediator aplicacionMediator;

    public GeneradorQR(AplicacionMediator aplicacionMediator){
        this.aplicacionMediator = aplicacionMediator;
    }

    private byte[] generarCodigoQR(String text) throws WriterException, IOException {
        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        BitMatrix bitMatrix= qrCodeWriter.encode(text, BarcodeFormat.QR_CODE, 500, 500);

        ByteArrayOutputStream pngOutputStream = new ByteArrayOutputStream();
        MatrixToImageWriter.writeToStream(bitMatrix, "PNG", pngOutputStream);
        byte[] pngData = pngOutputStream.toByteArray();
        return pngData;
    }

    public String generarBase64Image() throws WriterException, IOException {
        byte[] image = generarCodigoQR("ejemploBase");
        return Base64.getEncoder().encodeToString(image);
    }

    public String generarImage(String text) throws WriterException, IOException {
        byte[] image = generarCodigoQR(text);
        return Base64.getEncoder().encodeToString(image);
    }
}

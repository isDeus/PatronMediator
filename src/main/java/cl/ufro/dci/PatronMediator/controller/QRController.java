package cl.ufro.dci.PatronMediator.controller;

import cl.ufro.dci.PatronMediator.modelo.GeneradorQR;
import com.google.zxing.WriterException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.IOException;

@Controller
public class QRController {

    private GeneradorQR generadorQR = new GeneradorQR();

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getIndex(Model model) throws WriterException, IOException {
        model.addAttribute("generadorQR", generadorQR);
        return "VistaQR";
    }

}

package cl.ufro.dci.PatronMediator.controller;

import cl.ufro.dci.PatronMediator.modelo.AplicacionMediator;
import com.google.zxing.WriterException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.IOException;

@Controller
public class MediatorController {

    private AplicacionMediator aplicacionMediator = AplicacionMediator.getInstance();

    public MediatorController() throws IOException, WriterException {
    }

    @RequestMapping(value = "/VistaQR2")
    public String goIndex(Model model) throws WriterException, IOException {
        model.addAttribute("aplicacionMediator", aplicacionMediator);
        aplicacionMediator.controladorMovil.denegar();
        return "VistaQR2";
    }

    @RequestMapping(value = "/VistaQR2", method = RequestMethod.GET)
    public String getIndex(Model model) throws WriterException, IOException {
        model.addAttribute("aplicacionMediator", aplicacionMediator);
        aplicacionMediator.controladorMovil.denegar();
        return "VistaQR2";
    }


    @RequestMapping(value = "/VistaControladorMovil", method = RequestMethod.GET)
    public String getIndexMovil(Model model) {
        return "VistaControladorMovil";
    }

    @RequestMapping(value = "/VistaControladorMovil", method = RequestMethod.POST)
    public String postIndexMovil(Model model) throws IOException, WriterException {
        aplicacionMediator.confirmarApp();
        return "redirect:/VistaQR2";
    }


}

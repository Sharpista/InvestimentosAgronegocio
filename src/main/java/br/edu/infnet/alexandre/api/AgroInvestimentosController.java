package br.edu.infnet.alexandre.api;

import br.edu.infnet.alexandre.service.InvestidorService;
import br.edu.infnet.alexandre.service.PropriedadeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AgroInvestimentosController {


    private  final InvestidorService investidorService;
    private  final PropriedadeService propriedadeService;


    public AgroInvestimentosController(InvestidorService investidorService, PropriedadeService propriedadeService) {
        this.investidorService = investidorService;
        this.propriedadeService = propriedadeService;
    }


    @GetMapping("/")
    public String index(Model model) {


        return "index";
    }
}

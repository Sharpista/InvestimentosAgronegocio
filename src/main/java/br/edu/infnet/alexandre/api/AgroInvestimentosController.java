package br.edu.infnet.alexandre.api;

import br.edu.infnet.alexandre.service.InvestidorService;
import br.edu.infnet.alexandre.service.PropriedadeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

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

        var propriedades = propriedadeService.findAll();
        model.addAttribute("propriedades", propriedades );
        return "index";
    }

    @GetMapping("/propriedades/search")
    public  String search(@RequestParam("query") String query, Model model) {
        var propriedades = propriedadeService.findById(Integer.valueOf(query)).get();
        model.addAttribute("propriedades", propriedades );
        return "index";
    }
}

package br.edu.infnet.alexandre.api;

import br.edu.infnet.alexandre.service.InvestidorService;
import br.edu.infnet.alexandre.service.PropriedadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@Controller
public class AgroInvestimentosController {


    private  final InvestidorService investidorService;
    private  final PropriedadeService propriedadeService;


    @Autowired
    public AgroInvestimentosController(InvestidorService investidorService, PropriedadeService propriedadeService) {
        this.investidorService = investidorService;
        this.propriedadeService = propriedadeService;
    }

    @GetMapping("/")
    public String index(Model model) {

        var investidores = investidorService.findAll();
        model.addAttribute("investidores", investidores);
        return "index";
    }


    @GetMapping("investidores/detalhes/{id}")
    public String minhaCarteira(@PathVariable String id, Model model) {

        var investidor = investidorService.findById(Integer.valueOf(id)).get();
        var saldos = investidorService.getSaldoCarteira(Integer.parseInt(id));

        var propriedades = investidor.getPropriedadesInvestidas();
        model.addAttribute("propriedades", propriedades);
        model.addAttribute("nome", investidor.getNome());
        model.addAttribute("saldoDolar", saldos.getFirst());
        model.addAttribute("saldoReal", investidor.getCarteira().getSaldoCarteira());
        model.addAttribute("saldoEuro", saldos.getLast());

        return "detalhes";
    }

    @GetMapping("/propriedades")
    public  String getPropriedades(Model model) {
        var propriedades = propriedadeService.findAll();
        model.addAttribute("propriedades", propriedades );
        return "propriedades";
    }

    @GetMapping("propriedades/detalhes/{id}")
    public  String getPropriedadesDetalhes(@PathVariable String id, Model model) {
        var propriedade = propriedadeService.findById(Integer.valueOf(id)).get();

        model.addAttribute("investidores", propriedade.getInvestidor());
        model.addAttribute("nome", propriedade.getNome());
        model.addAttribute("valorInvestimento", propriedade.getCapitalNecessario());
        model.addAttribute("proprietarios", propriedade.getProprietario());

        return "detalhes-propriedades";
    }

}

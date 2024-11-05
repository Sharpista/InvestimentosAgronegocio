package br.edu.infnet.alexandre.api;

import br.edu.infnet.alexandre.service.InvestidorService;
import br.edu.infnet.alexandre.service.PropriedadeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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

    @GetMapping("investidores/minha-carteira")
    public String minhaCarteira(@RequestParam("id") String id, Model model) {

        var investidor = investidorService.findById(Integer.valueOf(id)).get();
        var saldos = investidorService.getSaldoCarteira(Integer.parseInt(id));

        var propriedades = investidor.getPropriedadesInvestidas();
        model.addAttribute("propriedades", propriedades);
        model.addAttribute("nome", investidor.getNome());
        model.addAttribute("saldoDolar", saldos.getFirst());
        model.addAttribute("saldoReal", investidor.getCarteira().getSaldoCarteira());
        model.addAttribute("saldoEuro", saldos.getLast());

        return "minha-carteira";
    }

    @GetMapping("/propriedades/search")
    public  String search(@RequestParam("query") String query, Model model) {
        var propriedades = propriedadeService.findById(Integer.valueOf(query)).get();
        model.addAttribute("propriedades", propriedades );
        return "index";
    }
}

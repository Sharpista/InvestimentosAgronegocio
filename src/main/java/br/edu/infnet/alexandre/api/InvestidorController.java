package br.edu.infnet.alexandre.api;

import br.edu.infnet.alexandre.domain.entities.Investidor;
import br.edu.infnet.alexandre.service.InvestidorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("v1/api/investidores")
public class InvestidorController {

    private  final InvestidorService investidorService;

    @Autowired
    public InvestidorController(InvestidorService investidorService) {
        this.investidorService = investidorService;
    }

    @GetMapping
    public List<Investidor> GetAllInvestidores() {
        return investidorService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Investidor> GetInvestidor(@PathVariable int id) {
        return investidorService.findById(id);
    }
    @PostMapping
    public void AddInvestidor(@RequestBody Investidor investidor) {
        this.investidorService.save(investidor);
    }

    @PutMapping
    public void UpdateInvestidor(@RequestBody Investidor investidor) {
        this.investidorService.save(investidor);
    }

    @DeleteMapping
    public void DeleteInvestidor(@RequestBody Investidor investidor) {
        this.investidorService.deleteById(investidor.getId());
    }


}

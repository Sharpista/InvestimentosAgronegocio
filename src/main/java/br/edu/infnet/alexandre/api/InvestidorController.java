package br.edu.infnet.alexandre.api;

import br.edu.infnet.alexandre.domain.entities.Investidor;
import br.edu.infnet.alexandre.service.InvestidorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/v1/api/investidores")
public class InvestidorController {


    private  final InvestidorService investidorService;

    @Autowired
    public InvestidorController(InvestidorService investidorService) {
        this.investidorService = investidorService;
    }

    @Operation(summary = "Recupera todos os investidores existentes.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Sucesso"),
            @ApiResponse(responseCode = "500", description = "Erro interno do sistema")
    })

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

    @DeleteMapping("/{id}")
    public void DeleteInvestidor(@PathVariable int id) {
        this.investidorService.deleteById(id);
    }


}

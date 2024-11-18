package br.edu.infnet.alexandre.api;

import br.edu.infnet.alexandre.domain.entities.Proprietario;
import br.edu.infnet.alexandre.service.ProprietarioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v1/api/proprietarios")
public class ProprietarioController {

    private final ProprietarioService proprietarioService;

    @Autowired
    public ProprietarioController(ProprietarioService proprietarioService) {
        this.proprietarioService = proprietarioService;
    }

    @Operation(summary = "Recupera todos os proprietarios existentes.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Sucesso"),
            @ApiResponse(responseCode = "500", description = "Erro interno do sistema")
    })

    @GetMapping
    public List<Proprietario> GetAllProprietarios() {
        return proprietarioService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Proprietario> GetProprietario(@PathVariable int id) {
        return proprietarioService.findById(id);
    }

    @PostMapping
    public void AddProprietario(@RequestBody Proprietario proprietario) {
        this.proprietarioService.save(proprietario);
    }

    @PutMapping
    public void UpdateProprietario(@RequestBody Proprietario proprietario) {
        this.proprietarioService.update(proprietario);
    }

    @DeleteMapping("/{id}")
    public void DeleteProprietario(@PathVariable int id) {
        this.proprietarioService.deleteById(id);
    }


}

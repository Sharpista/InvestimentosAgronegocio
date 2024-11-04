package br.edu.infnet.alexandre.api;

import br.edu.infnet.alexandre.domain.entities.Proprietario;
import br.edu.infnet.alexandre.service.ProprietarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("v1/api/proprietarios")
public class ProprietarioController {

    private final ProprietarioService proprietarioService;

    @Autowired
    public ProprietarioController(ProprietarioService proprietarioService) {
        this.proprietarioService = proprietarioService;
    }

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
}

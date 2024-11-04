package br.edu.infnet.alexandre.api;
import br.edu.infnet.alexandre.domain.entities.Propriedade;
import br.edu.infnet.alexandre.service.PropriedadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("v1/api/propriedades")
public class PropriedadeController {

    private  final PropriedadeService propriedadeService;

    @Autowired
    public PropriedadeController(PropriedadeService propriedadeService) {
        this.propriedadeService = propriedadeService;
    }

    @GetMapping
    public List<Propriedade> GetAllPropriedades() {
        return propriedadeService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Propriedade> GetPropriedade(@PathVariable int id) {
        return propriedadeService.findById(id);
    }
    @PostMapping
    public void AddPropriedade(@RequestBody Propriedade propriedade) {
        this.propriedadeService.save(propriedade);
    }

    @PutMapping
    public void UpdatePropriedade(@RequestBody Propriedade propriedade) {
        this.propriedadeService.save(propriedade);
    }

    @DeleteMapping
    public void DeletePropriedade(@RequestBody Propriedade propriedade) {
        this.propriedadeService.deleteById(propriedade.getId());
    }
}

package br.edu.infnet.alexandre.service;

import br.edu.infnet.alexandre.domain.entities.Propriedade;
import br.edu.infnet.alexandre.domain.interfaces.IGenericRepository;
import org.springframework.stereotype.Service;

@Service
public class PropriedadeService extends  GenericService<Propriedade, Integer>{

    protected PropriedadeService(IGenericRepository<Propriedade, Integer> repository) {
        super(repository);
    }
}

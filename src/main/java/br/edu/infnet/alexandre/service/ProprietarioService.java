package br.edu.infnet.alexandre.service;

import br.edu.infnet.alexandre.domain.entities.Proprietario;
import br.edu.infnet.alexandre.domain.interfaces.IGenericRepository;
import org.springframework.stereotype.Service;

@Service
public class ProprietarioService extends GenericService<Proprietario, Integer> {
    protected ProprietarioService(IGenericRepository<Proprietario, Integer> repository) {
        super(repository);
    }
}

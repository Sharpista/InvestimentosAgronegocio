package br.edu.infnet.alexandre.service;

import br.edu.infnet.alexandre.domain.entities.Investidor;
import br.edu.infnet.alexandre.domain.interfaces.IGenericRepository;
import org.springframework.stereotype.Service;

@Service
public class InvestidorService extends GenericService<Investidor, Integer> {
    protected InvestidorService(IGenericRepository<Investidor, Integer> repository) {
        super(repository);
    }
}

package br.edu.infnet.alexandre.infra.repositories;

import br.edu.infnet.alexandre.domain.entities.Investidor;
import br.edu.infnet.alexandre.domain.interfaces.IGenericRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IInvestidorRepository extends IGenericRepository<Investidor, Integer> {
}

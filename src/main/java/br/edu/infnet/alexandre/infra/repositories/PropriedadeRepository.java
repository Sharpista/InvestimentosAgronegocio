package br.edu.infnet.alexandre.infra.repositories;

import br.edu.infnet.alexandre.domain.entities.Propriedade;
import br.edu.infnet.alexandre.domain.interfaces.IGenericRepository;
import org.springframework.stereotype.Repository;

@Repository
public  interface PropriedadeRepository extends IGenericRepository<Propriedade, Integer > {
}

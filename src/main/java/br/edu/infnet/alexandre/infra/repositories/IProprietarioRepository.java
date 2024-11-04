package br.edu.infnet.alexandre.infra.repositories;

import br.edu.infnet.alexandre.domain.entities.Proprietario;
import br.edu.infnet.alexandre.domain.interfaces.IGenericRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProprietarioRepository extends IGenericRepository<Proprietario, Integer> {
}

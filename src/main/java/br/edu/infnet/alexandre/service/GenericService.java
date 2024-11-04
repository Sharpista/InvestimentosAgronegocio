package br.edu.infnet.alexandre.service;

import br.edu.infnet.alexandre.domain.interfaces.IGenericRepository;
import br.edu.infnet.alexandre.domain.interfaces.IGerericService;
import java.io.Serializable;
import java.util.List;
import java.util.Optional;


public class GenericService<T, ID extends Serializable> implements IGerericService<T, ID> {

    private final IGenericRepository<T, ID> repository;

    protected GenericService(IGenericRepository<T, ID> repository) {
        this.repository = repository;
    }

    @Override
    public List<T> findAll() {
        return (List<T>) repository.findAll();
    }

    @Override
    public Optional<T> findById(ID id) {
        return repository.findById(id);
    }

    @Override
    public void save(T entity) {
        repository.save(entity);
    }

    @Override
    public void update(T entity) {
        repository.save(entity);
    }

    @Override
    public void deleteById(ID id) {
        repository.deleteById(id);
    }


}

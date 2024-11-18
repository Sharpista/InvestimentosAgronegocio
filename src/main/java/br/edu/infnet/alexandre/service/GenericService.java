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
        try{
            return repository.findAll();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Optional<T> findById(ID id) {
        try {
            return repository.findById(id);

        }catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void save(T entity) {
        try {
            repository.save(entity);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(T entity) {
        try {
            repository.save(entity);
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteById(ID id) {
        try {
            repository.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


}

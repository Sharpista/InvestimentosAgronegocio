package br.edu.infnet.alexandre.domain.interfaces;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public interface IGerericService<T, ID extends Serializable> {

    List<T> findAll();
    Optional<T> findById(ID id);
    void save(T entity);
    void update(T entity);
    void deleteById(ID id);
}

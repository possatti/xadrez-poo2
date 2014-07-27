package br.edu.ifes.poo2.xadrez.cln.cgt;

import java.io.Serializable;
import java.util.List;

/**
 * Define as operações básica de um CRUD.
 *
 * @param <T>  Classe que o CRUD envolve.
 * @param <ID> Tipo usado como ID da classe persistida.
 */
public interface CRUDService<T extends Serializable, ID> {

    public void save(T t);

    public List<T> getAll();

    public void delete(ID id);

    public T get(ID id);

    public long count();

}

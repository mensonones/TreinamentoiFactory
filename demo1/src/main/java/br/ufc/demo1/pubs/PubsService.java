package br.ufc.demo1.pubs;

import org.springframework.data.jpa.repository.Query;


/**
 * Created by emerson on 18/07/17.
 */
public interface PubsService {

    public Pubs save(Pubs pub);
    public Pubs getById(Integer id);
    public Iterable<Pubs> findAll();
    public Boolean delete(Integer id);
}
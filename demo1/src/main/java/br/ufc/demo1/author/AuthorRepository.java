package br.ufc.demo1.author;

import org.springframework.data.repository.CrudRepository;

import java.util.Collection;

/**
 * Created by emerson on 17/07/17.
 */
public interface AuthorRepository extends CrudRepository<Author, Integer>{

}

package br.ufc.demo1.author;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.Collection;
import java.util.List;

/**
 * Created by emerson on 17/07/2017.
 */
@CrossOrigin
@Repository
public interface AuthorRepository extends CrudRepository<Author, Integer>{
}

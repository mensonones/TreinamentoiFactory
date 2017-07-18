package br.ufc.demo1.author;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by emerson on 18/07/17.
 */
@Service
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    @Override
    public Author save(Author author) {
        return authorRepository.save(author);
    }

    @Override
    public Author getById(Integer id) {

        return authorRepository.findOne(id);
    }

    @Override
    public Iterable<Author> findAll() {
        return authorRepository.findAll();
    }

    @Override
    public Boolean delete(Integer id) {
        authorRepository.delete(id);
        return true;
    }
}

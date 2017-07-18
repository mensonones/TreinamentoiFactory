package br.ufc.demo1.author;

/**
 * Created by emerson on 18/07/17.
 */
public interface AuthorService {

    public Author save(Author author);
    public Author getById(Integer id);
    public Iterable<Author> findAll();
    public Boolean delete(Integer id);

}

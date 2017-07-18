package br.ufc.demo1.author;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



/**
 * Created by emerson on 18/07/17.
 */
@RestController
@RequestMapping("/authors")
public class AuthorController {

    @Autowired
    private AuthorServiceImpl authorService;

    //retorna todos os autores
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Iterable<Author>> getAllAuthors() {
        Iterable<Author> authors = authorService.findAll();
        return new ResponseEntity<Iterable<Author>>(authors, HttpStatus.OK);
    }
    //cria um autor
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Author> createAuthor(@RequestBody Author author){
        authorService.save(author);
        return new ResponseEntity<Author>(author, HttpStatus.CREATED);
    }
    //atualiza autor por id
    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity<Void> updateAuthor(@RequestBody Author author){
        Author existingAuthor = authorService.getById(author.getId());
        if(existingAuthor == null){
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        }else{
            authorService.save(author);
            return new ResponseEntity<Void>(HttpStatus.OK);
        }
    }

    //retorna autor por id
    public ResponseEntity<Author> getAuthor(@PathVariable("id") Integer id){
        Author author = authorService.getById(id);
        if(author == null){
            return new ResponseEntity<Author>(HttpStatus.NOT_FOUND);
        }else{
            return new ResponseEntity<Author>(author, HttpStatus.OK);
        }
    }

    //deleta autor por id
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteAuthor(@PathVariable("id") Integer id){
        Author author = authorService.getById(id);
        if(author == null){
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        }else{
            authorService.delete(id);
            return new ResponseEntity<Void>(HttpStatus.GONE);
        }
    }

}
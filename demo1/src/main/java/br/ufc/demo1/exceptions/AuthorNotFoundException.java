package br.ufc.demo1.exceptions;

import br.ufc.demo1.author.Author;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by emerson on 19/07/17.
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Author não encontrado!")
public class AuthorNotFoundException extends RuntimeException {

}

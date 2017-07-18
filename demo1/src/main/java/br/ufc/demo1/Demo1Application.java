package br.ufc.demo1;

import br.ufc.demo1.author.Author;
import br.ufc.demo1.author.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.core.event.ValidatingRepositoryEventListener;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class Demo1Application {

	public static void main(String[] args) {
		SpringApplication.run(Demo1Application.class, args);
	}

	@Autowired
	private AuthorRepository authorRepository;

	@PostConstruct
	@Transactional
	public void onLoad(){

		Author emerson = new Author();
		emerson.setFirstName("Emerson");
		emerson.setLastName("Vieira");
		authorRepository.save(emerson);
	}

}

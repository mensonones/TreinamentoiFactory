package br.ufc.demo1;

import br.ufc.demo1.author.Author;
import br.ufc.demo1.author.AuthorRepository;
import br.ufc.demo1.pubs.Pubs;
import br.ufc.demo1.pubs.PubsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.core.event.ValidatingRepositoryEventListener;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.util.Date;

@SpringBootApplication
public class Demo1Application {

	public static void main(String[] args) {
		SpringApplication.run(Demo1Application.class, args);
	}

	@Autowired
	private AuthorRepository authorRepository;

	@Autowired
	private PubsRepository pubsRepository;

	@PostConstruct
	@Transactional
	public void onLoad(){

		Author emerson = new Author();
		emerson.setFirstName("Emerson");
		emerson.setLastName("Vieira");
		authorRepository.save(emerson);

		Pubs primeiro = new Pubs();
		primeiro.setNamePub("Teste pub");
		primeiro.setContentPub("TESTANDO PUB");
		primeiro.setAuthorPub(emerson);
		pubsRepository.save(primeiro);
	}

}

package br.ufc.demo1;

import br.ufc.demo1.author.Author;
import br.ufc.demo1.author.AuthorRepository;
import br.ufc.demo1.pub.Pub;
import br.ufc.demo1.pub.PubRepository;
import br.ufc.demo1.pub.Tipo;
import br.ufc.demo1.publisher.Publisher;
import br.ufc.demo1.publisher.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;


@SpringBootApplication
public class Demo1Application {

	public static void main(String[] args) {
		SpringApplication.run(Demo1Application.class, args);
	}

	@Autowired
	private AuthorRepository authorRepository;

	@Autowired
	private PubRepository pubsRepository;

	@Autowired
	private PublisherRepository publisherRepository;

	@PostConstruct
	@Transactional
	public void onLoad(){

		Author emerson = new Author();
		emerson.setFirstName("Emerson");
		emerson.setLastName("Vieira");
		emerson.setEmail("mensones.1@gmail.com");
		authorRepository.save(emerson);

		Publisher publisher = new Publisher();
		publisher.setName("Novatec");
		publisher.setDescription("Editora Brasileira");
		publisher.setWebsite("novatec.com.br");
		publisherRepository.save(publisher);

		Pub pub = new Pub();
		pub.setTipo(Tipo.LIVRO);
		pub.setAuthor(emerson);
		pub.setPublisher(publisher);
		pubsRepository.save(pub);
		/*Pub primeiro = new Pub();
		primeiro.setName("Teste pub");
		primeiro.setTipo();
		primeiro.setAuthorPub(emerson);
		pubsRepository.save(primeiro);*/
	}

}

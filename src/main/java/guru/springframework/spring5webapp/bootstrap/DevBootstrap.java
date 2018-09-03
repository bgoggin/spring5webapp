package guru.springframework.spring5webapp.bootstrap;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import guru.springframework.spring5webapp.model.Author;
import guru.springframework.spring5webapp.model.Book;
import guru.springframework.spring5webapp.model.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent>{
	private static Logger log = LogManager.getLogger(DevBootstrap.class);
	private AuthorRepository authorRepository;
	private BookRepository bookRepository;
	private PublisherRepository publisherRepository;
	
	public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
		this.authorRepository = authorRepository;
		this.bookRepository = bookRepository;
		this.publisherRepository = publisherRepository;
	}
	
	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		log.info("Calling init()");
		initData();
		
	}

	private void initData() {
		log.info("Entered initData()");
		// Eric
		Author eric = new Author("Eric", "Evans");
		Publisher hp = new Publisher("Harper Collins", "35 Hillcrest Ave, Naugatuck, CT 06770");
		Book ddd = new Book("Domain Driven Design", "1234");
		eric.getBooks().add(ddd);
		ddd.getAuthors().add(eric);
		hp.setBook(ddd);
		ddd.setPublisher(hp);
		authorRepository.save(eric);
		publisherRepository.save(hp);
		bookRepository.save(ddd);


		// Rod
		Author rod = new Author("Rod", "Johnson");
		Publisher wrox = new Publisher("Wrox", "7 Heatherwood Grn, Cromwell, CT 06416");
		Book noEJB = new Book("J2ee Development without EJB", "23444");
		rod.getBooks().add(noEJB);
		noEJB.getAuthors().add(rod);
		wrox.setBook(noEJB);
		noEJB.setPublisher(wrox);
		authorRepository.save(rod);
		publisherRepository.save(wrox);
		bookRepository.save(noEJB);
	}

}

package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.domain.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

  private final AuthorRepository authorRepository;
  private final BookRepository bookRepository;
  private final PublisherRepository publisherRepository;

  @SuppressWarnings("checkstyle:MissingJavadocMethod")
  public BootStrapData(AuthorRepository authorRepository,
                       BookRepository bookRepository,
                       PublisherRepository publisherRepository) {
    this.authorRepository = authorRepository;
    this.bookRepository = bookRepository;
    this.publisherRepository = publisherRepository;
  }

  @SuppressWarnings("checkstyle:AbbreviationAsWordInName")
  @Override
  public void run(String... args) throws Exception {

    Author eric = new Author("Eric", "Evans");
    Book ddd = new Book("Domain Driven Design", "12234");
    eric.getBooks().add(ddd);
    ddd.getAuthors().add(eric);

    authorRepository.save(eric);
    bookRepository.save(ddd);

    Author rod = new Author("Rod", "Johnson");
    Book noEJB = new Book("J2EE Development without EJB", "53245664435643");
    rod.getBooks().add(noEJB);
    noEJB.getAuthors().add(rod);

    authorRepository.save(rod);
    bookRepository.save(noEJB);

    System.out.println("Started in Bootstrap");
    System.out.println("Number of Books: " + bookRepository.count());

    Publisher testpublisher =
        new Publisher("Hans",
            "Wurst",
            "Metzgeralle",
            "11a",
            "12345",
            "Berlin",
            "Germany");

    publisherRepository.save(testpublisher);

    System.out.println("Number of Publishers: " + publisherRepository.count());
    System.out.println(publisherRepository.findById(5L));
  }
}

package axsos.mvc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import axsos.mvc.models.Book;
import axsos.mvc.repositories.BookRepository;

@Service
public class BookService {
	private final BookRepository bookRepository;

	// this method is injuction
	public BookService(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}

	public List<Book> allBooks() {
		return bookRepository.findAll();
	}

	// creates a book
	// also need save to update a book
	public Book createBook(Book b) {
		return bookRepository.save(b);
	}

	// retrieves a book
	public Book findBook(Long id) {
		Optional<Book> optionalBook = bookRepository.findById(id);
		if (optionalBook.isPresent()) {
			return optionalBook.get();
		} else {
			return null;
		}
	}

	public Book updateBook(Long id, String title, String desc, String lang, int numOfPages) {
		Book b = findBook(id);
		b.setTitle(title);
		b.setDescription(desc);
		b.setLanguage(lang);
		b.setNumberOfPages(numOfPages);
		return bookRepository.save(b);
	}
	public void deleteBook(Long id ) {
		Book b = findBook(id) ; 
		bookRepository.delete(b);
	}
}

package it.edo.tests.miscuglione2.service;

import it.edo.tests.miscuglione2.model.Book;
import it.edo.tests.miscuglione2.reposotory.BookRepository;
import lombok.extern.java.Log;
import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Log
@Service
public class BookService {

    @Autowired
    BookRepository bookRepository;

    public Long saveBook(Book book) {
        log.info("saving " + book.getTitle());
        Optional<Book> bookOptional = bookRepository.findByTitle(book.getTitle());
        if (bookOptional.isPresent()) {
            throw new HibernateException("Book already exists...");
        }
        return bookRepository.save(book).getId();
    }
}

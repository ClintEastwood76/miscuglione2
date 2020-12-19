package it.edo.tests.miscuglione2.service;

import it.edo.tests.miscuglione2.event.BookEventPublisher;
import it.edo.tests.miscuglione2.model.Book;
import it.edo.tests.miscuglione2.reposotory.BookRepository;
import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j2;
import org.hibernate.HibernateException;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.concurrent.Future;

@Log4j2
@Service
public class BookService {

    @Autowired
    BookRepository bookRepository;

    @Autowired
    BookEventPublisher bookEventPublisher;

    public Long saveBook(Book book) {
        log.info("saving {}", book.getTitle());
        Optional<Book> bookOptional = bookRepository.findByTitle(book.getTitle());
        if (bookOptional.isPresent()) {
            throw new HibernateException("Book already exists...");
        }
        book = bookRepository.save(book);
        //
        bookEventPublisher.publishBookEvent(book);
        return book.getId();
    }

    @Async
    public Future<Long> asyncSaveBook(Book book) {
        try {
            Thread.sleep(10000L);
            return new AsyncResult<>(saveBook(book));
        } catch (InterruptedException e) {
            log.error(e.getMessage());
        }
        return null;
    }
}

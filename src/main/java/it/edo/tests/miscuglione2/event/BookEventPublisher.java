package it.edo.tests.miscuglione2.event;

import it.edo.tests.miscuglione2.model.Book;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
@Log4j2
public class BookEventPublisher {

    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;

    public void publishBookEvent(final Book book) {
        log.info("BookEventPublisher: Publishing a book {}", book);
        BookEvent bookEvent = new BookEvent(this, book);
        applicationEventPublisher.publishEvent(bookEvent);
    }
}

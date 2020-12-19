package it.edo.tests.miscuglione2.event;

import it.edo.tests.miscuglione2.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
public class BookEventPublisher {

    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;

    public void publishBookEvent(final Book book) {
        System.out.println("Publishing custom event. ");
        BookEvent bookEvent = new BookEvent(this, book);
        applicationEventPublisher.publishEvent(bookEvent);
    }
}

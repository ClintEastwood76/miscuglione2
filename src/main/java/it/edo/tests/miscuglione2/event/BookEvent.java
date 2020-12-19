package it.edo.tests.miscuglione2.event;

import it.edo.tests.miscuglione2.model.Book;
import org.springframework.context.ApplicationEvent;

public class BookEvent extends ApplicationEvent {

    Book book;

    public BookEvent(Object source, Book book) {
        super(source);
        this.book = book;
    }
}

package it.edo.tests.miscuglione2.event;

import it.edo.tests.miscuglione2.model.Book;
import lombok.Getter;
import org.springframework.context.ApplicationEvent;

public class BookEvent {

    @Getter
    Book book;

    public BookEvent(Book book) {
        this.book = book;
    }
}

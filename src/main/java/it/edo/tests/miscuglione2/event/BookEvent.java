package it.edo.tests.miscuglione2.event;

import it.edo.tests.miscuglione2.model.Book;
import lombok.Getter;

@Deprecated
public class BookEvent {

    @Getter
    Book book;

    public BookEvent(Book book) {
        this.book = book;
    }
}

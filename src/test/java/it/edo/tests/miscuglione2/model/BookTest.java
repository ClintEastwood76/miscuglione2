package it.edo.tests.miscuglione2.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BookTest {

    @Test
    public void test() {
        Book book = new Book();
        book.setId(0l);
        book.setTitle("Ciao");
        assertSame(0l, book.getId());
        assertSame("Ciao", book.getTitle());
    }
}
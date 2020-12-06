package it.edo.tests.miscuglione2.controller;

import it.edo.tests.miscuglione2.model.Book;
import it.edo.tests.miscuglione2.service.BookService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.Future;

@Log
@RestController(value = "book")
public class BookController {

    @Autowired
    BookService bookService;

    @ResponseBody
    @PostMapping("/saveAndPublish")
    public String saveAndPublish(@RequestBody Book book) {
        Future<Long> future = bookService.asyncSaveBook(book);
        return future.toString();
    }
}

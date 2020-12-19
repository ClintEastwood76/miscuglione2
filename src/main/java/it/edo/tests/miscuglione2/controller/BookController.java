package it.edo.tests.miscuglione2.controller;

import it.edo.tests.miscuglione2.model.Book;
import it.edo.tests.miscuglione2.service.BookService;
import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.Future;

@Log4j2
@RestController(value = "book")
public class BookController {

    @Autowired
    BookService bookService;

    @ResponseBody
    @PostMapping("/saveAndPublishAsync")
    public String saveAndPublishAsync(@RequestBody Book book) {
        Future<Long> future = bookService.asyncSaveBook(book);
        return future.toString();
    }

    @ResponseBody
    @PostMapping("/saveAndPublishAsync")
    public String saveAndPublish(@RequestBody Book book) {
        Future<Long> future = bookService.asyncSaveBook(book);
        return future.toString();
    }

}

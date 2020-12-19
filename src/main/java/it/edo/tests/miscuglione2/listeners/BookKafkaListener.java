package it.edo.tests.miscuglione2.listeners;

import it.edo.tests.miscuglione2.model.Book;
import it.edo.tests.miscuglione2.service.BookService;
import lombok.extern.log4j.Log4j2;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Log4j2
public class BookKafkaListener {

    @KafkaListener(topics = "test-topic", groupId = "foo")
    public void listenGroupFoo(Book book) {
        log.info("Received Book in group foo: {}", book);
    }
}
package it.edo.tests.miscuglione2.listeners;

import it.edo.tests.miscuglione2.model.Book;
import it.edo.tests.miscuglione2.service.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class BookListener {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @KafkaListener(topics = "test-topic", groupId = "foo")
    public void listenGroupFoo(Book book) {
        logger.info("Received Book in group foo: {}", book);
    }
}

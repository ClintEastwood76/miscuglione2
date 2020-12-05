package it.edo.tests.miscuglione2.service;

import it.edo.tests.miscuglione2.model.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class KafkaProducerServiceTest {

    @Autowired
    KafkaProducerService kafkaProducerService;

    @Test
    public void testSend() {
        Book book = new Book();
        book.setTitle("EDOARDONE3");
        book.setId(-1L);
        kafkaProducerService.sendMessage(book);
    }

}
package it.edo.tests.miscuglione2.service;

import it.edo.tests.miscuglione2.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducerService {

    private String topicName = "test-topic";

    @Autowired
    private KafkaTemplate<String, Book> bookKafkaTemplate;

    public void sendMessage(Book book) {
        bookKafkaTemplate.send(topicName, book);
    }
}

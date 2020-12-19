package it.edo.tests.miscuglione2.event;

import it.edo.tests.miscuglione2.service.KafkaProducerService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Log4j2
@Component
public class BookEventListener implements ApplicationListener<BookEvent> {

    @Autowired
    KafkaProducerService kafkaProducerService;

    @Override
    public void onApplicationEvent(BookEvent bookEvent) {
        log.info("BookEventListener: published a a book with info {}", bookEvent.toString());
        // kafkaProducerService.sendMessage(bookEvent.getBook());
    }
}

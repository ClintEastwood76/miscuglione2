package it.edo.tests.miscuglione2.event;

import it.edo.tests.miscuglione2.service.KafkaProducerService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Log4j2
@Component
public class BookEventListener {

    @Autowired
    KafkaProducerService kafkaProducerService;

    @EventListener
    public void onApplicationEvent(BookEvent bookEvent) {
        log.info("BookEventListener: received a book - {}", bookEvent.getBook().toString());
        kafkaProducerService.sendMessage(bookEvent.getBook());
    }
}

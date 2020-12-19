package it.edo.tests.miscuglione2.event;

import lombok.extern.log4j.Log4j2;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Log4j2
@Component
public class BookEventListener implements ApplicationListener<BookEvent> {

    @Override
    public void onApplicationEvent(BookEvent bookEvent) {
        log.info("published a a book with info {}", bookEvent.toString());
    }
}

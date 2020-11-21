package it.edo.tests.miscuglione2.reposotory;

import it.edo.tests.miscuglione2.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

}

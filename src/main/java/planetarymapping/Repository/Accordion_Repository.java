package planetarymapping.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import planetarymapping.model.Accordion;

import java.util.List;

@Repository
public interface Accordion_Repository extends JpaRepository<Accordion, Integer> {
   List<Accordion> findAll();

   Accordion findAllById(Integer id);
}

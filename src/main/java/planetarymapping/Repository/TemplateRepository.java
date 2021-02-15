package planetarymapping.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import planetarymapping.model.Template;

@Repository
public interface TemplateRepository extends JpaRepository<Template, Integer> {

    Template findByTemplateName(String templateName);
}

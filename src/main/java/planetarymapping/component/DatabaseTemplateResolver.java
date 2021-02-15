package planetarymapping.component;

import org.springframework.stereotype.Component;
import org.thymeleaf.IEngineConfiguration;
import org.thymeleaf.templateresolver.StringTemplateResolver;
import org.thymeleaf.templateresource.ITemplateResource;
import planetarymapping.Repository.TemplateRepository;
import planetarymapping.model.Template;

import java.util.Collections;
import java.util.Map;
import java.util.logging.Logger;

@Component
public class DatabaseTemplateResolver extends StringTemplateResolver {
//    private static final Logger logger = logger.getLogger(DatabaseTemplateResolver.class);
    final
    private TemplateRepository templateRepository;

    public DatabaseTemplateResolver(TemplateRepository templateRepository) {
        this.templateRepository = templateRepository;
        this.setResolvablePatterns(Collections.singleton("db-*"));
        this.setCacheTTLMs(5*60*1000L);
        this.setCacheable(true);
    }

    @Override
    protected ITemplateResource computeTemplateResource(IEngineConfiguration configuration,
                                                        String ownerTemplate,
                                                        String templateName,
                                                        Map<String, Object> templateResolutionAttributes) {
//        logger.info("Loading template named {} from DB", templateName);
        Template template = templateRepository.findByTemplateName(templateName);
        if (template == null) {
            return null;
        }
        return super
                .computeTemplateResource(configuration, ownerTemplate, template.getContent(), templateResolutionAttributes);
    }
}

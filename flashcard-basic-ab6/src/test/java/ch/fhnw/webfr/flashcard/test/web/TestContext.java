package ch.fhnw.webfr.flashcard.test.web;

import org.mockito.Mockito;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import ch.fhnw.webfr.flashcard.persistence.QuestionnaireRepository;

@Configuration
@EnableAutoConfiguration
@ComponentScan(basePackages = {"ch.fhnw.webfr.flashcard.web"})
public class TestContext {
	@Bean
    public QuestionnaireRepository questionnaireRepository() {
        return Mockito.mock(QuestionnaireRepository.class);
    }
}

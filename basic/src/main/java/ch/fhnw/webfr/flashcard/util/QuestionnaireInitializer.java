package ch.fhnw.webfr.flashcard.util;

import org.apache.log4j.Logger;

import ch.fhnw.webfr.flashcard.domain.Questionnaire;
import ch.fhnw.webfr.flashcard.persistence.QuestionnaireRepository;

public class QuestionnaireInitializer {
	private static Logger logger = Logger.getLogger(QuestionnaireInitializer.class);
	
	public static void createQuestionnaires() {
		QuestionnaireRepository repo = QuestionnaireRepository.getInstance();
		repo.create(new Questionnaire("Test Questionnaire 1", "Lorem ipsum dolor sit amet..."));
		repo.create(new Questionnaire("Test Questionnaire 2", "Lorem ipsum dolor sit amet..."));
		repo.create(new Questionnaire("i18n Test fünf", "Lorem ipsum dolor sit amet..."));
		
		logger.debug("Questionnaires initialized successfully");
	}

}

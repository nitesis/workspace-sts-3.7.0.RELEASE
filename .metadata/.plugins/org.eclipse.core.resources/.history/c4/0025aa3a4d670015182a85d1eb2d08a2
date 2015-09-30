package ch.fhnw.webfr.flashcard.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ch.fhnw.webfr.flashcard.domain.Questionnaire;

public interface QuestionnaireRepository extends JpaRepository<Questionnaire, Long> {
	List<Questionnaire> findByTitle(String title);
}

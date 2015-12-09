package ch.fhnw.webfr.flashcard.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ch.fhnw.webfr.flashcard.domain.Questionnaire;
import ch.fhnw.webfr.flashcard.persistence.QuestionnaireRepository;

@RestController
@RequestMapping("/questionnaires")
public class QuestionnaireController {
	
	private Logger log = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private QuestionnaireRepository questionnaireRepository;
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Questionnaire> findById(@PathVariable Long id){
		Questionnaire questionnaire = questionnaireRepository.findOne(id);
		if(questionnaire == null) {
			log.debug("No Questionnaire found with Id" + id);
			return new ResponseEntity<Questionnaire>(HttpStatus.NOT_FOUND); 
		}
		log.debug("Found" + questionnaire.getId());
		return new ResponseEntity<Questionnaire>(questionnaire, HttpStatus.OK);
	}

}

package ch.fhnw.webfr.flashcard.web;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ch.fhnw.webfr.flashcard.domain.Questionnaire;
import ch.fhnw.webfr.flashcard.persistence.QuestionnaireRepository;

@ManagedBean //Damit wird festgelegt, dass das ein Jsf-Bean ist
@RequestScoped
@Component // Das ist für Spring
public class QuestionnaireBean {
	
	private Questionnaire actualQuestionnaire; 
	
	@Autowired
	private QuestionnaireRepository questionnaireRepository;
	//Das ist hier das managed bean (nicht Questionnaire.java)
	public List<Questionnaire> getQuestionnaires() {
		return questionnaireRepository.findAll();
	}	
	
	// Methode um Eingabeformular zu erstellen
	public String createForm() {
	actualQuestionnaire = new Questionnaire();
	return "/pages/create";
	}
	
	public String cancel() {
		actualQuestionnaire = null;
				 return "/pages/questionnaires?faces-redirect-true";
	}
	
	public String create(){
		questionnaireRepository.save(actualQuestionnaire);
		return "/pages/questionnaires?faces-redirect-true";
	}
}

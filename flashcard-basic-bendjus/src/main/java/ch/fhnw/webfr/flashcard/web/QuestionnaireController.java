package ch.fhnw.webfr.flashcard.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;

import ch.fhnw.webfr.flashcard.domain.Questionnaire;
import ch.fhnw.webfr.flashcard.persistence.QuestionnaireRepository;

@Controller //sagt Spring, dass es sich hier um einen PageController handelt
@RequestMapping("/questionnaires")//Mapping auf die URL
public class QuestionnaireController {
	
//	@RequestMapping(method = RequestMethod.GET)
//    public List<Questionnaire> get_NewQuestionnaire(Model model) {
//		
//		List<Questionnaire> listQuestionnaire = new ArrayList<>();
//		model.addAttribute("questionnaire", new Questionnaire());
////		attr.addFlashAttribute("questionnaire", questionnaire);
////		model.addAttribute("description", description);
////		model.addAttribute("title", title);
//		
//		return "questionnaires";
//    }
//	
//	@RequestMapping(method = RequestMethod.POST)
//    public String create_NewQuestionnaire(Model model) {
//		model.addAttribute("questionnaire", new Questionnaire());
////		attr.addFlashAttribute("questionnaire", questionnaire);
////		model.addAttribute("description", description);
////		model.addAttribute("title", title);
//		
//		return "redirect:questionnaires";
//    }
	@Autowired
	private QuestionnaireRepository questionnaireRepository;
	
	@RequestMapping(method = RequestMethod.GET)
	//findAll() Methode siehe MockTest
	public String findAll(Model model) {
		//gibt Attribut questionnaire zurück
		//Legt neue Instanz eines Questionnaire unter dem Key "questionnaire" im Model ab
		model.addAttribute("questionnaire", new Questionnaire());
		//gibt Attribut questionnaires zurück. findAll() ist springinterne Methode
		//Liest Liste aller vorhandenen Questionnaire aus dem QuestionnaireRepository... 
		//...und legt es unter dem Key "questionnaires" im Model ab
		model.addAttribute("questionnaires", questionnaireRepository.findAll());
		//Logischer View Name "/questionnaires" zurückgeben
		return "questionnaires";
	}
	
	// Without any validation support from the framework!
	@RequestMapping(method = RequestMethod.POST)
	// Model Parameter kann man hier auch weglassen, da es nicht gebraucht wird
	public String create(Questionnaire questionnaire, Model model) {
		if ((questionnaire.getTitle() != null) && (questionnaire.getTitle().length() > 0) &&
			(questionnaire.getDescription() != null) && (questionnaire.getDescription().length() > 0)) {
			questionnaireRepository.save(questionnaire);//wird nicht im MockTest abgefragt
		}
		//redirect erkennt Spring und führt eine Redirection aus
		return "redirect:questionnaires";
	}

}

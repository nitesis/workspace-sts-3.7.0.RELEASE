package ch.fhnw.webfr.flashcard.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import ch.fhnw.webfr.flashcard.domain.Questionnaire;
import ch.fhnw.webfr.flashcard.persistence.QuestionnaireRepository;

@Controller
@RequestMapping("/questionnaires")
public class QuestionnaireController {
	
	//private final QuestionnaireRepository questionnaireRepository;
	
	//@Redirect
	@RequestMapping(method=RequestMethod.POST)
    public String create_NewQuestionnaire(Model model) {
		model.addAttribute("questionnaire", new Questionnaire());
//		attr.addFlashAttribute("questionnaire", questionnaire);
//		model.addAttribute("description", description);
//		model.addAttribute("title", title);
		
		return "redirect:/questionnaires";
    }

}

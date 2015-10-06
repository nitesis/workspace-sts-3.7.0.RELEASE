package ch.fhnw.webfr.flashcard.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import ch.fhnw.webfr.flashcard.domain.Questionnaire;

@Controller
@RequestMapping("/questionnaires")
public class QuestionnaireController {
	
//	@Controller
//	public class HelloWorldController {
//	@RequestMapping(method = RequestMethod.GET) 
//	@ResponseBody public String sayHello(@RequestParam("name") String name) { 
//		return "Hello World to " + name;
//		} 
//	}
	
	@RequestMapping(method = RequestMethod.POST)
    public String create_NewQuestionnaire(Model model) {
		model.addAttribute("questionnaire", new Questionnaire());
//		attr.addFlashAttribute("questionnaire", questionnaire);
//		model.addAttribute("description", description);
//		model.addAttribute("title", title);
		
		return "redirect:questionnaires";
    }

}

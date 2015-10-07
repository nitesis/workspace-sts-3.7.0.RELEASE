package ch.fhnw.webfr.flashcard.web;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import ch.fhnw.webfr.flashcard.persistence.QuestionnaireRepository;

@Controller
@RequestMapping("/hello")
public class HelloWorldController {

	@Autowired //heisst: nimm einfach das Rep, dass du findest. Diese Annotation muss sein!
	private QuestionnaireRepository questionnaireRepository;

	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public String sayHello(@RequestParam("name") String name) throws IOException {

		return "Hello to " + name + ". Das Repo hat " + questionnaireRepository.findAll().size() + " Records.";
	}

}

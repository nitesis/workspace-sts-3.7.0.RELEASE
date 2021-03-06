package ch.fhnw.webfr.hello;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/counter")
public class CounterController {
	
	private Integer counter = 0;
	
//	//Lösung AB7 Aufgabe 1
//	@RequestMapping(method = RequestMethod.GET)
//	public String count(Model model) {
//		counter = (counter == null) ? 1 : ++counter;
//		model.addAttribute("counter", counter);
//		return "count";
//	}	
	
	//Lösung AB7 Aufgabe 2 -> unabhängiges Hochzählen in verschiedenen Browsern möglich
	@RequestMapping(method = RequestMethod.GET)
	//HttpSession session wird von Spring initiert
	//
	public String count(Model model, HttpSession session) {
	//session.getAttribute("counter") prüft, ob überhaupt etwas gesetzt ist
		Integer counter = (Integer) session.getAttribute("counter");
	//wenn null auf 1 setzen, sonst imkrementieren
		counter = (counter == null) ? 1 : ++counter;
		model.addAttribute("counter", counter);
	
		session.setAttribute("counter", counter);
		return "count";
	}	
}

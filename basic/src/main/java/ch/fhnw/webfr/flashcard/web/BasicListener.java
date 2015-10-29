package ch.fhnw.webfr.flashcard.web;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.log4j.Logger;

import ch.fhnw.webfr.flashcard.persistence.QuestionnaireRepository;
import ch.fhnw.webfr.flashcard.util.QuestionnaireInitializer;

//Wird aufgerufen, wenn die Session erstellt wird
public class BasicListener implements ServletContextListener{

	private Logger logger = Logger.getLogger(this.getClass().getName());
	
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		//schaut, was unter context-param im web.xml steht und vergleicht, ob es "test" ist
		if(sce.getServletContext().getInitParameter("mode").equals("test")){
			//wenn context-param den Wert "test" hat, dann werden die Fragebögen erstellt
			QuestionnaireInitializer.createQuestionnaires();
		}
//		Variante Maurice:
//		 ServletContext servletContext = sce.getServletContext();
		//holt Wert aus web.xml unter param=mode
//        String mode = servletContext.getInitParameter("mode");
//
//        switch (mode) {
//            case "test":
//                QuestionnaireInitializer.createQuestionnaires();
//                logger.debug("Questionnaire initialized in mode: " + mode);
//                break;
//            default:
//                logger.error("Unknown questionnaire repo: " + mode);
//                break;
//        }
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		
	}
}

package ch.fhnw.webfr.flashcard.web;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import ch.fhnw.webfr.flashcard.util.QuestionnaireInitializer;

public class BasicListener implements ServletContextListener{

	
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		//schaut, was unter context-param im web.xml steht und vergleicht, ob es "test" ist
		if(sce.getServletContext().getInitParameter("mode").equals("test")){
			//wenn context-param den Wert "test" hat, dann werden die Fragebögen erstellt
			QuestionnaireInitializer.createQuestionnaires();
		}
		
		
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		
	}
}

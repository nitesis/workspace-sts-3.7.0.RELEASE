package ch.fhnw.webfr.flashcard;

import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.Configuration;

@Configuration
//Initialisiert das WebServlet, hier auskommentiert, weil das im web.xml gemacht wird
//Klasse darf aber nicht gelöscht werden
public class WebServletInitializer extends SpringBootServletInitializer {
//    @Override
//    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
//        return application.sources(Application.class);
//    }
}
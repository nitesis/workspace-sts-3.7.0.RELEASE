package ch.fhnw.webfr.flashcard;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
//Ersatz für web.xml
public class WebServletInitializer extends SpringBootServletInitializer {
    @Override
    //Application.class als Konfigurationsklasse
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(Application.class);
    }
}
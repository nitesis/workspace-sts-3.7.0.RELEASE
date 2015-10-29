package ch.fhnw.webfr.flashcard;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

// Don't scan the test package!
@ComponentScan(basePackages={"ch.fhnw.webfr.flashcard.web","ch.fhnw.webfr.flashcard.persistence"})
@EnableAutoConfiguration
public class Application {
	public static void main(String[] args) {
		//führt Klasse aus und nimmt Konfiguration vor
		SpringApplication.run(Application.class);
	}

}
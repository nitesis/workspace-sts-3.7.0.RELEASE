package ch.fhnw.webfr.flashcard.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "questionnaires")
public class Questionnaire {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;
    private String  title;
    private String description;
    
    public Questionnaire() {
    	this.description = "Lorem ipsum dolor sit amet...";
    }
    
    public void setTitle(String title) {
		this.title = title;
	}
    
    public long getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}

}

package ch.fhnw.webfr.flashcard.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "questionnaires") //name muss übereinstimmen mit import.sql (ist der Tabellenname)
public class Questionnaire {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;
    
    // To test form validation
    @Size(min=2, max=50)
    @NotNull
    private String  title;
    
    // To test form validation
    @Size(min=10)
    @NotNull
    private String description;
    
    public Questionnaire() {
    	this.description = "Lorem ipsum dolor sit amet...";
    }
    
    public void setId(long id) {
		this.id = id;
	}
    
    public long getId() {
		return id;
	}

	public void setTitle(String title) {
		this.title = title;
	}
    
    public String getTitle() {
		return title;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}

}

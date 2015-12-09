package ch.fhnw.webfr.flashcard.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.google.common.base.Objects;

@Entity
@Table(name = "questionnaires")
public class Questionnaire {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;
    
    @NotNull
    private String  title;
    
    @NotNull
    private String description;
    
    public Questionnaire() {
    	this.description = "Lorem ipsum dolor sit amet...";
    }
    
    public void setId(long id) {
		this.id = id;
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
	
	public void setDescription(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}
	
	@Override
	public int hashCode(){
	    return Objects.hashCode(title, description, id);
	}

	@Override
	public boolean equals(final Object obj){
	    if(obj instanceof Questionnaire){
	        final Questionnaire other = (Questionnaire) obj;
	        return Objects.equal(id, other.id)
	            && Objects.equal(title, other.title)
	            && Objects.equal(description, other.description);
	    } else{
	        return false;
	    }
	}	

}

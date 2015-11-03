package ch.fhnw.webfr.hello;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name="counterueb")
@SessionScoped
public class CounterUEB6 {
	private Integer counter = 1;
	private Integer summand = 0;

    public Integer getValue() {
        return counter;
    }
    
    public Integer getSummand() {
		return summand;
	}
    
    public void setSummand(Integer summand) {
		this.summand = summand;
	}
    
    public void add() {
    	counter = counter + summand;
    }
}
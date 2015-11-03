package ch.fhnw.webfr.hello;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name="counter")
@SessionScoped
public class Counter {
	private Integer counter = 1;

    public Integer getValue() {
        return counter++;
    }
}
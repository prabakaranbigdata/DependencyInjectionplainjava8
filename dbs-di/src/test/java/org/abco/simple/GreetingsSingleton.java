package org.abco.simple;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;


@ApplicationScoped
public class GreetingsSingleton {

	@Inject
	private Wishes wishes;
	
	public String wish() {
		
		return new StringBuilder(this.wishes.wish()).append(" Singleton and Protype Dependency Injection in Plain Java").toString();
	}
	
}

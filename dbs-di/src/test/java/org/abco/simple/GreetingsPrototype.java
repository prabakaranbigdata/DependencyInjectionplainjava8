package org.abco.simple;

import javax.inject.Inject;

public class GreetingsPrototype {


	@Inject
	private Wishes wishes;
	
	public String wishPrototype() {
		
		return new StringBuilder(this.wishes.wish()).append(" development").toString();
	}
	
}
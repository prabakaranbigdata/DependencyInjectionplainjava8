package org.abco.simple;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import javax.enterprise.inject.Instance;
import javax.enterprise.inject.se.SeContainer;
import javax.enterprise.inject.se.SeContainerInitializer;

import org.junit.Test;

public class InjectionInPlainJavaTest {
	@Test
	public void testSingleton() {
		final SeContainerInitializer initializer = SeContainerInitializer.newInstance();
		try (SeContainer initialize = initializer.initialize()) {
			final Instance<GreetingsSingleton> greetingInstance = initialize.select(GreetingsSingleton.class);

			final GreetingsSingleton greetingsObjOne = greetingInstance.get();
			final GreetingsSingleton greetingsObjTwo = greetingInstance.get();
			
			assertNotNull(greetingsObjOne);
			assertNotNull(greetingsObjTwo);
			
			assertEquals(greetingsObjTwo, greetingsObjOne); // Singleton - Objects Check it is Singleton or Not
			
			assertEquals(greetingsObjOne.wish(), "Happy Success Singleton and Protype Dependency Injection in Plain Java");
			assertEquals(greetingsObjTwo.wish(), "Happy Success Singleton and Protype Dependency Injection in Plain Java");
		}

	}
	// Prototype

	@Test
	public void testPrototype() {
		final SeContainerInitializer initializer = SeContainerInitializer.newInstance();
		try (SeContainer initialize = initializer.initialize()) {
			final Instance<GreetingsPrototype> greetingPrototypeInstance = initialize.select(GreetingsPrototype.class);

			final GreetingsPrototype greetingsPrototypeObjOne = greetingPrototypeInstance.get();
			
			final GreetingsPrototype greetingsPrototypeObjTwo = greetingPrototypeInstance.get();
			
			assertNotNull(greetingsPrototypeObjOne);
			assertNotNull(greetingsPrototypeObjTwo);
			
			assertNotEquals(greetingsPrototypeObjOne, greetingsPrototypeObjTwo);// Prototype - ObjectsCheck it is prototype or Not
		
			
			assertEquals(greetingsPrototypeObjOne.wishPrototype(), "Happy Success development");
			assertEquals(greetingsPrototypeObjTwo.wishPrototype(), "Happy Success development");
		}

	}
}

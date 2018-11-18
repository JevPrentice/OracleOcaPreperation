package code.examples.encapsulation;

import java.util.Objects;
import org.junit.Assert;
import org.junit.Test;

/**
 * Read https://docs.oracle.com/javase/tutorial/java/javaOO/constructors.html.
 *
 * You don't have to provide any constructors for your class, but you must be careful when doing this. The compiler
 * automatically provides a no-argument, default constructor for any class without constructors. This default
 * constructor will call the no-argument constructor of the superclass. In this situation, the compiler will complain if
 * the superclass doesn't have a no-argument constructor so you must verify that it does. If your class has no explicit
 * superclass, then it has an implicit superclass of Object, which does have a no-argument constructor.
 *
 * @author jev
 * @since Nov 17, 2018
 */
public class BeagleConstructorExample {

    private static abstract class Animal {

	private final String name;

	// Because Animal class has a constructor, there is no default constructor added by the java compiler.
	Animal(final String name) {
	    // On the first line of the Animal constructor, because there is no call to super made, the following line 
	    // is actually added during compilation: "super();". This is OK because Object has a no arg constructor.
	    this.name = Objects.requireNonNull(name);
	}

	public String getName() {
	    return name;
	}
    }

    private static class Dog extends Animal {

	private final String breed;

	Dog(final String breed) {
	    // In the original question the next line was omitted: "super(breed);"
	    // The purpose of this question to check that the developer knows that Java will insert a call to the 
	    // default constructor of the classes the super class if a call to super is not found on the first line
	    // of a constructor. Omitting this line causes a complication error because Animal does not have a no arg 
	    // constructor. The answer to this question was that the code does not compile.
	    super(breed);
	    this.breed = Objects.requireNonNull(breed);
	}

	Dog(final String name, final String breed) {
	    super(name);
	    this.breed = Objects.requireNonNull(breed);
	}

	public String getBreed() {
	    return breed;
	}
    }

    @Test
    public void method() {
	final Dog dog1 = new Dog("Beagle");
	final Dog dog2 = new Dog("Bubbly", "Poodle");
	final String result = dog1.getName() + ":" + dog1.getBreed() + ":"
		+ dog2.getName() + ":" + dog2.getBreed();
	Assert.assertEquals("Beagle:Beagle:Bubbly:Poodle", result);
    }
}

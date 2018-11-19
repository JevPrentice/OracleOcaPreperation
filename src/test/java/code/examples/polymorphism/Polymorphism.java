package code.examples.polymorphism;

import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author jev
 * @since Sep 18, 2018
 */
public class Polymorphism {

    public Polymorphism() {
    }

    class Bird {
    }

    class Fish {
	// compiles with -> extends Bird

    }

    class Rodent {
    }

    class Capybara extends Rodent {
    }

    /**
     * The compiler will not allow casts to unrelated types.
     */
    @Test
    public void test() {
	final Fish fish = new Fish();
	//final Bird bird = (Bird) fish; // DOES NOT COMPILE

	final Rodent rodent = new Rodent();
	String error = null;
	try {
	    final Capybara capybara = (Capybara) rodent; // Throws ClassCastException at runtime 	
	} catch (final ClassCastException e) {
	    error = e.toString();
	} finally {
	    final String expected = "java.lang.ClassCastException: "
		    + "code.examples.polymorphism.Polymorphism$Rodent cannot be cast to "
		    + "code.examples.polymorphism.Polymorphism$Capybara";
	    Assert.assertEquals(expected, error);
	}
    }
}

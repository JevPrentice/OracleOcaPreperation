package code.examples.polymorphism;

import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author jev
 * @since Sep 18, 2018
 */
public class Polymorphism {

    Polymorphism() {
    }

    private static class Bird {
    }

    private static class Fish {
	// compiles with -> extends Bird
    }

    private static class Rodent {
    }

    private static class Capybara extends Rodent {
    }

    /**
     * The compiler will not allow casts to unrelated types.
     */
    @Test
    public void test() {
	final Fish fish = new Fish();
	//final Bird bird = (Bird) fish; // DOES NOT COMPILE, fish and bird are not related.

	final Rodent rodent = new Rodent();
	String error = null;
	try {
	    // While any Capybara is a Rodent, not all Rodents are Capybaras, and this one is not.
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

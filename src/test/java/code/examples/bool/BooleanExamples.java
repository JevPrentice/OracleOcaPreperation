package code.examples.bool;

import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author jev
 * @since Nov 17, 2018
 */
public class BooleanExamples {

    public BooleanExamples() {
    }

    @Test
    public void method() {
	// Multiple varibles declared on single line is ok.
	boolean b1, b2 = true;

	//Assert.assertTrue(b1); // b1 is not init.
	if ("".equals(" ")) {
	    b1 = true;
	}
	// Assert.assertTrue(b1); // b1 is still not init.
	if ("".equals(" ")) {
	    b1 = true;
	} else {
	    b1 = false;
	}

	Assert.assertFalse(b1); // b1 is still not init.

	Assert.assertTrue(b2);
	// boolean const; // const is a keyword

	//Boolean b = new Boolean(); // There is not a no arg constructor, there is one for string and boolean.
	// Boolean string constructor uses:
	/*
	public static boolean parseBoolean(String s) {
	    return ((s != null) && s.equalsIgnoreCase("true"));
	}
	 */
	
	Assert.assertTrue(new Boolean("trUe"));
	Assert.assertFalse(new Boolean("false"));
	Assert.assertFalse(new Boolean("truuu"));
	Assert.assertFalse(new Boolean("not true"));
    }
}

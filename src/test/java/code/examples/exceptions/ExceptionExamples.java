package code.examples.exceptions;

import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author jev
 * @since Nov 17, 2018
 */
public class ExceptionExamples {

    public ExceptionExamples() {
    }

    @Test
    public void method() {

	Assert.assertEquals("java.lang.Exception", new Exception().toString());
	final Exception e = new Exception("Oh no");
	Assert.assertEquals("java.lang.Exception: Oh no", e.toString());
	Assert.assertEquals("Oh no", e.getMessage());
    }

    @Test
    public void numberFormatException() {
	String msg = "no error yet";
	try {
	    Double.valueOf("");
	} catch (final NumberFormatException e) {
	    msg = e.getMessage();
	    Assert.assertEquals("java.lang.NumberFormatException: empty String", e.toString());
	} finally {
	    Assert.assertEquals("empty String", msg);
	}
    }
}

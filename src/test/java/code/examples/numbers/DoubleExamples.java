package code.examples.numbers;

import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author jev
 * @since Nov 17, 2018
 */
public class DoubleExamples {

    public DoubleExamples() {
    }

    @Test
    public void method() {
	String msg = "no error yet";
	try {
	    Double.valueOf("");
	} catch (final NumberFormatException e) {
	    msg = e.getMessage();
	} finally {
	    Assert.assertEquals("empty String", msg);
	}
    }
}

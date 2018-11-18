package code.examples.string;

import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author jev
 * @since Nov 17, 2018
 */
public class StringExamples {

    public StringExamples() {
    }

    @Test
    public void method() {

	final StringBuilder sb = new StringBuilder("my string builder");

	final String s1 = sb.toString();
	final String s2 = sb.toString();

	Assert.assertFalse(s1 == s2);
	Assert.assertTrue(s1 != s2);
	Assert.assertEquals(s1, s2);

	// While s1 and s2 are created from the same StringBuilder the .toString() method 
	// is creating a new string object. So == and != will evaluate as not equal.
    }
}

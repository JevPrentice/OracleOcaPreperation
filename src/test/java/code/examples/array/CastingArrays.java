package code.examples.array;

import java.util.Arrays;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author jev
 * @since Nov 17, 2018
 */
public class CastingArrays {

    public CastingArrays() {
    }

    @Test
    public void method() {

	final String[] array = {"s1", "s2"};

	StringBuilder sb = new StringBuilder();
	for (final String b : array)
	    sb.append(b);
	Assert.assertEquals("s1s2", sb.toString());

	array[0] = "test"; // Set the ele of array

	sb = new StringBuilder();
	for (final String b : array)
	    sb.append(b);
	Assert.assertEquals("tests2", sb.toString());

	final List<String> list = Arrays.asList(array); // Array is passed by ref.
	list.set(1, "test"); // Set the ele of list

	sb = new StringBuilder();
	for (final String b : array)
	    sb.append(b);
	Assert.assertEquals("testtest", sb.toString());

	/**
	 * Arrays.asList: Returns a fixed-size list backed by the specified array.
	 * see https://docs.oracle.com/javase/6/docs/api/java/util/Arrays.html#asList%28T...%29
	 */
	String error = "none";
	try {
	    list.remove(1);
	} catch (java.lang.UnsupportedOperationException e) {
	    error = e.toString();
	} finally {
	    Assert.assertEquals("java.lang.UnsupportedOperationException", error);
	}
    }
}

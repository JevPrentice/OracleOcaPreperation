package code.examples.array;

import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author jev
 * @since Nov 17, 2018
 */
public class StringsAndStringBuilders {

    public StringsAndStringBuilders() {
    }

    /**
     * Must have same elements, and in the same order.
     */
    @Test
    public void listOfStrings() {

	final List<String> one = new ArrayList<>();
	final List<String> two = new ArrayList<>();

	Assert.assertEquals(one, two);
	one.add("a");
	Assert.assertNotEquals(one, two);
	two.add("a");
	Assert.assertEquals(one, two);

	one.add("b");
	two.add(0, "b"); // two is now = [b,a]

	Assert.assertNotEquals(one, two);
    }

    @Test
    public void listOfStringBuilders() {

	final List<StringBuilder> one = new ArrayList<>();
	final List<StringBuilder> two = new ArrayList<>();

	Assert.assertEquals(one, two); // The lists are equal when they have the same type and are empty.

	one.add(new StringBuilder("a"));
	Assert.assertNotEquals(one, two);

	// The lists with instances of StringBuilder inside are not equal.
	// Even though they contain the same string contents. Since StringBuilder does not override .equals we 
	// get the runtime impl of Object#toString (Checks equality with ==)
	two.add(new StringBuilder("a"));
	Assert.assertNotEquals(one, two);

    }
}

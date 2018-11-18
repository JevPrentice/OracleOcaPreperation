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
public class ArrayListOfIntegers {

    public ArrayListOfIntegers() {
    }

    @Test
    public void method() {

	final List<Integer> list = new ArrayList<>();

	list.add(100);
	list.add(200);
	list.add(100);
	list.add(200);

	/**
	 * Removing element with an Object returns true if the record was found and removed, otherwise false.
	 */
	if (list.remove(new Integer(101))) { // Evaluates to false.
	    final Integer remove = list.remove(0);
	    Assert.assertEquals(new Integer(100), remove);
	}

	Assert.assertEquals("[100, 200, 100, 200]", list.toString());

	/**
	 * Removing element by index returns the removed object.
	 */
	if (list.remove(0) != null) { // Evaluates to true because list had an element at position 0.
	    boolean remove = list.remove(new Integer(200));
	    Assert.assertTrue(remove);
	}

	Assert.assertEquals("[100, 200]", list.toString());
    }
}

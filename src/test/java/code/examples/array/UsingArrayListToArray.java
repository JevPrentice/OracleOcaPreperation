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
public class UsingArrayListToArray {

    public UsingArrayListToArray() {
    }

    /**
     * {@link List#toArray()} Returns a new Object[], {@link List#toArray(T[])} returns the array T passed into toArray,
     * if the list can fit inside the array otherwise a new array of type T is returned.
     */
    @Test
    public void method() {
	final List<String> list = new ArrayList<>();

	list.add("hawk");
	list.add("robin");

	final Object[] objectArray = list.toArray();
	Assert.assertEquals(2, objectArray.length);

	final String[] stringArray = list.toArray(new String[0]);
	Assert.assertEquals(2, stringArray.length);
    }

}

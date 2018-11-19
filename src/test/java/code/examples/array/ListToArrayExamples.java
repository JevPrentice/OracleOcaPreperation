package code.examples.array;

import java.util.ArrayList;
import java.util.Arrays;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author jev
 * @since Nov 17, 2018
 */
public class ListToArrayExamples {

    public ListToArrayExamples() {
    }

    @Test
    public void method() {

	// List to array using to array
	final String[] arr = new String[3]; // Empty array
	final ArrayList<String> list = new ArrayList<>(3); // Populated list
	list.add("one");
	list.add("two");
	list.add("three");
	Assert.assertEquals("[one, two, three]", list.toString());
	Assert.assertEquals("[null, null, null]", Arrays.asList(arr).toString());

	final String[] toArray = list.toArray(arr); // Apply values in list to array.
	Assert.assertEquals("[one, two, three]", list.toString());
	Assert.assertEquals("[one, two, three]", Arrays.asList(arr).toString()); // Arr has changed.
	Assert.assertEquals("[one, two, three]", Arrays.asList(toArray).toString());

	// List to array used incorrect
	final String[] arr2 = {"one", "two", "three"}; // Populated array
	final ArrayList<String> list2 = new ArrayList<>(3); // Empty list

	// First element of arr2 has become null.
	final String[] toArray2 = list2.toArray(arr2);
	Assert.assertEquals("[null, two, three]", Arrays.asList(toArray2).toString());
	Assert.assertEquals("[null, two, three]", Arrays.asList(arr2).toString());

    }
}

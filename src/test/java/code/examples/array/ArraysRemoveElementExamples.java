package code.examples.array;

import java.util.*;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author jev
 * @since Nov 17, 2018
 */
public class ArraysRemoveElementExamples {

    public ArraysRemoveElementExamples() {
    }

    @Test
    public void booleanArr() {

	final boolean[] arr = new boolean[2];

	final List<Boolean> list = new ArrayList<>();

	list.add(arr[0]);
	list.add(arr[1]);

	Assert.assertEquals("[false, false]", list.toString());

	if (list.remove(0)) { // Remove returns the value false, which causes the if statement to not be entered.
	    list.remove(1);
	}

	Assert.assertEquals("[false]", list.toString());
    }

    @Test
    public void booleanArrWrapper() {

	final Boolean[] arr = new Boolean[2];

	final List<Boolean> list = new ArrayList<>();

	list.add(arr[0]);
	list.add(arr[1]);

	Assert.assertEquals("[null, null]", Arrays.asList(arr).toString());
	Assert.assertEquals("[null, null]", list.toString());

	String msg = "";
	try {
	    // ArrayList remove by index [E remove(int index)] returns the elememt that is removed.
	    // Since the element as position 0 is null, Java throws a null pointer when trying to access
	    // Boolean.booleanValue of the null ref.
	    if (list.remove(0)) {
		list.remove(1);
	    }
	} catch (final NullPointerException e) {
	    msg = e.toString();
	} finally {
	    Assert.assertEquals("java.lang.NullPointerException", msg);
	    System.out.println(list);
	}
    }
}

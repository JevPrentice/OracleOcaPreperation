package code.examples.array;

import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author jev
 * @since Nov 19, 2018
 */
public class SubList {

    public SubList() {
    }

    @Test
    @SuppressWarnings("unchecked")
    public void method() {

	final List nums = new ArrayList<>();
	nums.add("one");
	nums.add("two");
	nums.add("three");

	final List letters = new ArrayList<>();
	letters.add("A");
	letters.add("b");
	letters.add("C");

	final List result = new ArrayList<>();
	result.addAll(nums);
	result.add(letters.subList(1, 1));

	Assert.assertEquals("[one, two, three, []]", result.toString());
    }
}

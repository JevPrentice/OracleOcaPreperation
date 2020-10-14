package code.examples.array;

import java.util.*;
import java.util.function.BiPredicate;
import java.util.stream.*;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author jev
 * @since Dec 17, 2018
 */
public class IsContainedTest {

    private final static IsContainedBiPredicate INSTANCE = new IsContainedBiPredicate();

    //<editor-fold defaultstate="collapsed" desc="Inner class to perform check">
    private static class IsContainedBiPredicate implements BiPredicate<int[], int[]> {

	/**
	 * Write a function that accept two arrays of the same type, and returns a boolean value.
	 * The function does not need to consider duplicate values.
	 *
	 * Estimated complexity is O(1) when either array is null or array1 has more elements than array2.
	 * Estimated complexity is O(M) otherwise.
	 *
	 * @param array1 The input array one.
	 * @param array2 The input array two.
	 *
	 * @return Returns true if all the elements of array1 are found in array2.
	 */
	private static boolean isContained(final int[] array1, final int[] array2) {
	    Objects.requireNonNull(array1, "array1 cannot be null.");
	    Objects.requireNonNull(array2, "array2 cannot be null.");
	    if (array1.length > array2.length)
		return false;
	    final Set<Integer> set1 = IntStream.of(array1).boxed().collect(Collectors.toSet());
	    final Set<Integer> set2 = IntStream.of(array2).boxed().collect(Collectors.toSet());
	    return set2.containsAll(set1);
	}

	@Override
	public boolean test(final int[] array1, final int[] array2) {
	    return isContained(array1, array2);
	}
    }
    //</editor-fold>

    public IsContainedTest() {
    }

    public boolean runTimedTest(final int[] array1, final int[] array2) {
	final long then = System.currentTimeMillis();
	final boolean result = INSTANCE.test(array1, array2);
	final long ms = System.currentTimeMillis() - then;
	System.out.printf("array1 length = %d; array2 length = %d; ms = %d; result=%s\n",
		array1.length, array2.length, ms, result);
	return result;
    }

    @Test
    public void isContainedBiPredicateTest() {

	final int[] array1 = IntStream.range(0, 10).toArray();
	Assert.assertTrue(runTimedTest(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9}, array1));

	final int[] array2 = IntStream.range(0, 100).toArray();
	Assert.assertTrue(runTimedTest(array2, array2));
	Assert.assertTrue(runTimedTest(array1, array2));
	Assert.assertFalse(runTimedTest(array2, array1));

	final int[] array3 = IntStream.range(0, 1000).toArray();
	Assert.assertTrue(runTimedTest(array3, array3));

	final int[] array4 = IntStream.range(0, 9999999).toArray();
	Assert.assertTrue(runTimedTest(array4, array4));
	Assert.assertTrue(runTimedTest(array1, array4));
    }
}

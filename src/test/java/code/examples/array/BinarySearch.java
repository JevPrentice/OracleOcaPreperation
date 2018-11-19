package code.examples.array;

import java.util.Arrays;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author jev
 * @since Aug 28, 2018
 */
public class BinarySearch {

    public BinarySearch() {
    }

    /**
     * See {@link Arrays#binarySearch(java.lang.Object[], java.lang.Object)}
     *
     * The results from a binary search are predictable assuming the array is already sorted.
     *
     * The binary search result will be:
     * If the target element found in sorted array -> Index of match
     * If target element not found in sorted array -> A negative value showing one smaller than the negative of index,
     * where a match needs to be inserted to preserve sorted order.
     * Unsorted array -> An inconsistent result.
     */
    @Test
    public void method() {

	final int[] numbers = {2, 4, 6, 8}; // Arrays.binarySearch relies on the array already being sorted.

	// Searches for the index of 2. The answer is index 0. 
	Assert.assertEquals(0, Arrays.binarySearch(numbers, 2));

	// Searches for the index of 4, which is 1.
	Assert.assertEquals(1, Arrays.binarySearch(numbers, 4));

	// Searches for the index of 1. Although 1 isn’t in the list, the search can determine that it should be
	// inserted at element 0 to preserve the sorted order. Since 0 already means something for array indexes,
	// Java needs to subtract 1 to give us the answer of –1. 
	Assert.assertEquals(-1, Arrays.binarySearch(numbers, 1));

	// Searches for the index of 3. Although 3 isn’t in the list, it would need to be inserted at element 1 to 
	// preserve the sorted order. We negate and subtract 1 for consistency, getting –1 –1, also known as –2. 
	Assert.assertEquals(-2, Arrays.binarySearch(numbers, 3));

	// Searches for index 9. 9 should be inserted at index 4 to maintain order. 
	// We again negate and subtract 1, getting –4 –1, also known as –5.
	Assert.assertEquals(-5, Arrays.binarySearch(numbers, 9));

    }
}

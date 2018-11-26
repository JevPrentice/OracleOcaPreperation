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
public class DeclaringArrays {

    public DeclaringArrays() {
    }

    @Test
    public void method() {
	int[] arr1 = {2, 1, 0}; // with values

	// Normal for
	for (int i = 0; i < arr1.length; i++) {
	    System.out.print(arr1[i] + " ");
	}

	System.out.println();

	// Normal for each
	for (int i : arr1) {
	    System.out.print(i + " ");
	}

	System.out.println();

	// Foreach, also using element position - give slightly unexpected result.
	for (int i : arr1) {
	    System.out.print(arr1[i] + " ");
	}

	// Declare arrays right.
	int[] arr2[] = new int[8][];
	int[] arr3 = new int[8];
	int[][] arr4 = new int[8][8];
	int arr5[][] = new int[1][];
	int arr6[] = new int[1];
	int arr7[] = new int[0]; // Compiles but no elements.

	String error = "";
	try {
	    final int accessArray = arr6[0]; // There are no elements
	    System.out.println(accessArray);
	    Assert.assertEquals(0, accessArray); // A primitive int defaults to 0. https://docs.oracle.com/javase/tutorial/java/nutsandbolts/datatypes.html
	    final int accessEmptyArray = arr7[0]; // There are no elements - throws ArrayIndexOutOfBoundsException
	    Assert.assertEquals(9999, accessEmptyArray); // Not reached.
	} catch (final ArrayIndexOutOfBoundsException e) {
	    error = e.toString();
	} finally {
	    Assert.assertEquals("java.lang.ArrayIndexOutOfBoundsException: 0", error);
	}

	// int[][] arr8 = new int[][8]; // Not ok, first dimention does not have a size.
	final String[][] arr9 = new String[3][2]; // OK
	final String[][] arr10 = new String[0][]; // OK
	// final String [][] arr11 = new String[][1]; // NOT OK
	// final String [][] rectangle12 = new String[][]; // NOT OK

	// ArrayIndexOutOfBoundsException is also thrown for a negative value.
	int[] arr13 = new int[1];
	error = "";
	try {
	    arr13[-1] = -1;
	    System.out.println(arr13[-1]);
	} catch (final ArrayIndexOutOfBoundsException e) {
	    error = e.toString();
	} finally {
	    Assert.assertEquals("java.lang.ArrayIndexOutOfBoundsException: -1", error);
	}

	final int[] arr14 = {1, 2, 3, 4};
	final int[] arr15 = {1, 2, 3, 4};

	Assert.assertFalse(arr14 == arr15);
	Assert.assertFalse(arr14.equals(arr15));

	Assert.assertTrue(Arrays.equals(arr14, arr15));
	// Assert.assertTrue(Arrays.deepEquals((arr6, arr7));

	final int[] copy1 = Arrays.copyOf(arr15, 5);
	final int[] copy2 = Arrays.copyOf(arr15, 9);
	final int[] copy3 = Arrays.copyOf(arr15, 1); // First element only
	Assert.assertEquals("[1, 2, 3, 4, 0]", Arrays.toString(copy1));
	Assert.assertEquals("[1, 2, 3, 4, 0, 0, 0, 0, 0]", Arrays.toString(copy2));
	Assert.assertEquals("[1]", Arrays.toString(copy3));

	// Sorting
	final int[] arrUnsorted = {5, 1, 10, 2, 3, 4, 13, 50};
	final int[] arrUnsorted2 = {5, 1, 10, 2, 3, 4, 13, 50};

	Assert.assertEquals("[5, 1, 10, 2, 3, 4, 13, 50]", Arrays.toString(arrUnsorted));

	Arrays.sort(arrUnsorted);

	Assert.assertEquals("[1, 2, 3, 4, 5, 10, 13, 50]", Arrays.toString(arrUnsorted));

	Assert.assertEquals(0, Arrays.binarySearch(arrUnsorted, 1));
	Assert.assertEquals(1, Arrays.binarySearch(arrUnsorted, 2));
	Assert.assertEquals(2, Arrays.binarySearch(arrUnsorted, 3));
	Assert.assertEquals(3, Arrays.binarySearch(arrUnsorted, 4));
	Assert.assertEquals(4, Arrays.binarySearch(arrUnsorted, 5));
	Assert.assertEquals(5, Arrays.binarySearch(arrUnsorted, 10));
	Assert.assertEquals(6, Arrays.binarySearch(arrUnsorted, 13));
	Assert.assertEquals(7, Arrays.binarySearch(arrUnsorted, 50));
	//
	Assert.assertEquals(-6, Arrays.binarySearch(arrUnsorted, 6));
	// The value 6 was not found, so result is neg.
	// The the sorting order of the array would be preserved is the value 6 is inserted at position 5 (with following elements shifted up one space)
	// Arrays.binarySearch result = -(5) -1 = -6

	Assert.assertEquals("[5, 1, 10, 2, 3, 4, 13, 50]", Arrays.toString(arrUnsorted2));

	Arrays.sort(arrUnsorted2, 2, 5);

	Assert.assertEquals("[5, 1, 2, 3, 10, 4, 13, 50]", Arrays.toString(arrUnsorted2));

	unchecked();
    }

    @SuppressWarnings("unchecked")
    @Test
    public void unchecked() {
	final ArrayList list = new ArrayList();
	list.add('Q');
	list.add('W');
	list.add('e');
	list.add('R');
	list.add(true);   // OK

	Assert.assertEquals("[Q, W, e, R, true]", list.toString());
	Assert.assertTrue(list.get(1) instanceof Character);
	Assert.assertTrue(list.get(4) instanceof Boolean);
    }

    @Test
    public void std() {
	String[] stringArr = new String[]{"one", "two"};
	System.out.println(stringArr instanceof Object);
	System.out.println(stringArr instanceof Object[]);
	System.out.println(stringArr instanceof String[]);
	// System.out.println(stringArr instanceof String);      // does not compile
    }
}

package code.examples.array;

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
	int[] arr3[] = new int[8][];
	int[] arr = new int[8];
	int[][] arr2 = new int[8][8];
	int arr4[][] = new int[1][];
	int arr7[] = new int[1];
	int arr8[] = new int[0]; // Compiles but no elements.

	String error = "";
	try {
	    final int accessArray = arr7[0]; // There are no elements
	    System.out.println(accessArray);
	    Assert.assertEquals(0, accessArray); // A primitive int defaults to 0. https://docs.oracle.com/javase/tutorial/java/nutsandbolts/datatypes.html
	    final int accessEmptyArray = arr8[0]; // There are no elements - throws ArrayIndexOutOfBoundsException
	    Assert.assertEquals(9999, accessEmptyArray); // Not reached.
	} catch (final ArrayIndexOutOfBoundsException e) {
	    error = e.toString();
	} finally {
	    Assert.assertEquals("java.lang.ArrayIndexOutOfBoundsException: 0", error);
	}

	// int[][] arr6 = new int[][8]; // Not ok, first dimention does not have a size.
	final String[][] rectangle1 = new String[3][2]; // OK
	final String[][] rectangle2 = new String[0][]; // OK
	// final String [][] rectangle3 = new String[][1]; // NOT OK
	// final String [][] rectangle4 = new String[][]; // NOT OK

	// ArrayIndexOutOfBoundsException is also thrown for a negative value.
	int[] arr9 = new int[1];
	error = "";
	try {
	    arr9[-1] = -1;
	    System.out.println(arr9[-1]);
	} catch (final ArrayIndexOutOfBoundsException e) {
	    error = e.toString();
	} finally {
	    Assert.assertEquals("java.lang.ArrayIndexOutOfBoundsException: -1", error);
	}
    }
}

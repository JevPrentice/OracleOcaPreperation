package code.examples.array;

import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author jev
 * @since Nov 17, 2018
 */
public class IterateSimpleTwoDimensionalArray {

    public IterateSimpleTwoDimensionalArray() {
    }

    @Test
    public void method() {
	final StringBuilder sb = new StringBuilder();
	int[][] arr = new int[3][2];
	for (int i = 0; i < arr.length; i++) {
	    for (int j = 0; j < arr[i].length; j++)
		sb.append(arr[i][j]).append(" ");
	    sb.append("\n");
	}
	final String expected
		= "0 0 \n"
		+ "0 0 \n"
		+ "0 0 \n";

	Assert.assertEquals(expected, sb.toString());
    }
}

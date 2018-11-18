/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package code.examples.array;

import java.util.Arrays;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author jev
 */
public class ArraysBinarySearchTest {

    private final int[] numbers = {2, 4, 6, 8};

    public ArraysBinarySearchTest() {
    }

    @Test
    public void testMain() {
	Assert.assertEquals(0, Arrays.binarySearch(numbers, 2));
	Assert.assertEquals(1, Arrays.binarySearch(numbers, 4));
	Assert.assertEquals(-1, Arrays.binarySearch(numbers, 1));
	Assert.assertEquals(-2, Arrays.binarySearch(numbers, 3));
	Assert.assertEquals(-5, Arrays.binarySearch(numbers, 9));
    }
}

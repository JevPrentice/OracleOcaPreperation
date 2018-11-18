package code.examples.unary;

import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author jev
 * @since Nov 17, 2018
 */
public class UnaryExamples {

    public UnaryExamples() {
    }

    @Test
    public void u1() {
	int a = 7;
	boolean res = a++ == 7 && ++a == 9 || a++ == 9;
	Assert.assertEquals(9, a);
	Assert.assertTrue(res);
    }

    @Test
    public void u2() {
	int a = 3;
	boolean res = a++ == 3 || --a == 3 && --a == 3;
	Assert.assertEquals(4, a);
	Assert.assertTrue(res);
    }

    @Test
    public void u3() {
	int a = 100;
	int b = 100;
	Assert.assertEquals(-100, -a++);
	Assert.assertEquals(-101, -(++b));
    }
}

package code.examples.unary;

import java.util.ArrayList;
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
	int c = 100;

	Assert.assertEquals(-100, -a++);
	Assert.assertEquals(-101, -(++b));
	Assert.assertEquals(-99, -(--c));
    }

    @Test
    public void u4() {
	int a = 2;
	boolean res;
	res = a++ == 2 || --a == 2 && --a == 2;
	Assert.assertTrue(res);
	Assert.assertEquals(3, a);
    }

    @Test
    public void IntegerExample() {
	ArrayList<Integer> list = new ArrayList<>();
	list.add(new Integer(10));
	Integer i1 = list.get(0);
	++i1; // i1 is changed, but not the original list
	Assert.assertTrue(11 == i1);
	Assert.assertTrue(10 == list.get(0));
    }
}

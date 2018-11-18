package code.examples.array;

import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author jev
 * @since Nov 17, 2018
 */
public class NullRefWithStaticMember {

    private static class MyClass {

	final public static int NUM_CONST = 0;
    }

    public NullRefWithStaticMember() {
    }

    /**
     * Its fine to call a static member of a null reference.
     */
    @Test
    public void method() {
	final MyClass obj = null;
	int result = obj.NUM_CONST;
	Assert.assertEquals(0, result);
    }
}

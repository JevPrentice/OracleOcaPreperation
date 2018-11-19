package code.examples.string;

import java.util.function.Function;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author jev
 * @since Nov 17, 2018
 */
public class StringExamples {

    public StringExamples() {
    }

    @Test
    public void method() {

	final StringBuilder sb = new StringBuilder("my string builder");

	final String s1 = sb.toString();
	final String s2 = sb.toString();

	Assert.assertFalse(s1 == s2);
	Assert.assertTrue(s1 != s2);
	Assert.assertEquals(s1, s2);

	// While s1 and s2 are created from the same StringBuilder the .toString() method 
	// is creating a new string object. So == and != will evaluate as not equal.
    }

    @Test
    public void concatenation() {

	final String s1 = 1 + 3 + "j";
	Assert.assertEquals("4j", s1);

	// When since s1 already had the string value "4j", the string already existed in the pool so using == is true
	final boolean equalsEqualsStringPool = "4j" == s1;
	Assert.assertTrue(equalsEqualsStringPool);

	// When comparing s1 with a String created using the "new String(string)" constructor then == is false since its a different object
	final boolean equalsEqualsNewString = new String("4j") == s1;
	Assert.assertFalse(equalsEqualsNewString);

	final String s2 = "1" + 3.0;
	Assert.assertEquals("13.0", s2);

	final String s3 = 1 + 2.5 + "€";
	Assert.assertEquals("3.5€", s3);

	final String s4 = 1 + "" + 1;
	Assert.assertEquals("11", s4);

	// String s5 = 1 + 2 + 3; // Does not compile, cannot assign an int to a string.
	// String s6 = null + 1;  // Does not compile, cannot plus 1 to null.
	final String s7 = null;   // Assign null reference compiles fine.
	Assert.assertEquals(null, s7);

	Function<String, String> f;
	f = m1();
	System.out.println(f.apply("apply func: "));

	f = m2();
	System.out.println(f.apply("apply func: "));

    }

    static Function<String, String> m1() {
	return (final String s) -> s.concat(" lambda");
    }

    static Function<String, String> m2() {
	return new Function<String, String>() {
	    @Override
	    public String apply(final String s) {
		return s.concat(" anonymous");
	    }
	};
    }

    static Function<String, String> m3() {
	return new FunctionImpl();
    }

    private static class FunctionImpl implements Function<String, String> {

	public FunctionImpl() {
	}

	@Override
	public String apply(final String s) {
	    return s.concat(" anonymous member");
	}
    }
}

package code.examples.simple;

import java.util.Arrays;
import java.util.List;
import org.junit.Test;

/**
 *
 * @author jev
 * @since Sep 20, 2018
 */
public class MainMethodsOnAbstractClasses {

    private static abstract class MyAbstractClass {

	public static void main(final String[] args) { //psvm is fine in abstract class
	    Arrays.asList(args).forEach(System.out::println);
	}
    }

    public MainMethodsOnAbstractClasses() {
    }

    @Test
    public void method() {
	final List<String> asList = Arrays.asList("a", "b");
	MyAbstractClass.main((String[]) asList.toArray());
	MyAbstractClass.main(asList.toArray(new String[0]));
    }
}

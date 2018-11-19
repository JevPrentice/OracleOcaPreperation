package code.examples.array;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Predicate;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author jev
 * @since Sep 9, 2018
 */
public class RemoveIf {

    public RemoveIf() {
    }

    @Test
    public void method() {

	final List<String> bunnies = new ArrayList<>();

	bunnies.add("long ear");
	bunnies.add("floppy");
	bunnies.add("Hoppy");

	Assert.assertEquals("[long ear, floppy, Hoppy]", bunnies.toString());

	// bunnies.removeIf(s -> s.toLowerCase().charAt(0) != 'h');
	final Predicate<String> predicate = (final String x) -> {
	    return x.toLowerCase().charAt(0) != 'h';
	};

	bunnies.removeIf(predicate);

	Assert.assertEquals("[Hoppy]", bunnies.toString());

	// Exception in thread "main" java.util.ConcurrentModificationException
	String error = "";
	try {
	    for (String bunny : bunnies) {
		if (bunny.toLowerCase().startsWith("h")) {
		    bunnies.remove(bunny);
		}
	    }
	} catch (java.util.ConcurrentModificationException e) {
	    error = e.toString();
	} finally {
	    Assert.assertEquals("java.util.ConcurrentModificationException", error);
	}

	final BiPredicate<String, String> biPredicate = (final String a, final String b) -> {
	    return a.equals(b);
	};

	Assert.assertTrue(biPredicate.test("this", "this"));

	final BiPredicate<String, String> biPredicateMemberRef = String::equals;
	Assert.assertTrue(biPredicateMemberRef.test("this", "this"));

    }
}

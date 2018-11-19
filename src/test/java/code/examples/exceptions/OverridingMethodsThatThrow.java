package code.examples.exceptions;

import java.io.IOException;

/**
 * Throwing a narrower exception or not throwing an exception is fine, but throwing a new or wider exception
 * will not compile.
 *
 * @author jev
 * @since Nov 17, 2018
 */
public class OverridingMethodsThatThrow {

    private static interface I1 {

	void m1() throws java.io.IOException;
    }

    private static class C1 implements I1 {

	@Override
	public void m1() throws IOException { // Same
	}
    }

    private static class C2 implements I1 {

	@Override
	public void m1() { // None
	}
    }

    private static class C3 implements I1 {

	/**
	 * Since RuntimeException is an unchecked exception the same rules as C2 apply here, "throws
	 * RuntimeException" is unrelated to I1 throwing an IOException.
	 *
	 * @throws RuntimeException
	 */
	@Override
	public void m1() throws RuntimeException {
	}
    }
}

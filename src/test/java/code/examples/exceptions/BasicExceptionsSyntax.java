package code.examples.exceptions;

import org.junit.Test;

/**
 *
 * @author jev
 * @since Sep 30, 2018
 */
public class BasicExceptionsSyntax {

    private static class MyCheckedException extends Exception {
    }

    private static class MyUnCheckedException extends RuntimeException {
    }

    private static class MyAutoCloseable implements AutoCloseable {

	public MyAutoCloseable() {
	}

	@Override
	public void close() throws MyCheckedException {
	    // This is just an example, there is nothing to close.
	}
    }

    public BasicExceptionsSyntax() {
    }

    @Test
    public void method() {

	try {
	} catch (Exception e) {
	    throw new RuntimeException(e);
	}

	try {
	} catch (Exception e) {
	    throw new RuntimeException(e);
	} finally {

	}

	try {
	} finally {
	}

	/**
	 * MyCheckedException needs to be caught before Exception because MyCheckedException extends Exception.
	 */
	try (final AutoCloseable autoCloseable = new MyAutoCloseable()) {
	} catch (final MyCheckedException e) {
	    throw new MyUnCheckedException();
	} catch (final Exception ex) {
	    throw new RuntimeException();
	} finally {
	}
    }
}

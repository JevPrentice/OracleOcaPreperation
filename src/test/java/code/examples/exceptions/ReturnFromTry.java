package code.examples.exceptions;

/**
 *
 * @author jev
 * @since Nov 26, 2018
 */
public class ReturnFromTry {

    public ReturnFromTry() {
    }

    @org.junit.Test
    public void m() {
	try {
	    System.out.println("try");
	    return;
	} catch (Exception e) {
	    System.out.println("catch");
	} finally {
	    System.out.println("finally");
	}
	System.out.println("after");
    }
}

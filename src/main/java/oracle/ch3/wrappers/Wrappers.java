package oracle.ch3.wrappers;

/**
 *
 * @author jev
 * @since Nov 19, 2018
 */
public class Wrappers {

    private static void m(double d1, double d2) {
	System.out.println("double");
    }

    private static void m(Double d1, Double d2) {
	System.out.println("Double");
    }

    public static void main(final String[] args) {
	m(10.0, 10.1); // OK
	m(new Double(10.0), new Double(10.1)); // OK
	// m(10.0, new Double(10.1)); // Not ok - ambiguous
    }
}

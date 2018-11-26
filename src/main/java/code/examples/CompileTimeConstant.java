package code.examples;

/**
 *
 * @author jev
 * @since Nov 19, 2018
 */
public class CompileTimeConstant {

    public static void main(final String[] args) {

	// a is not a compile time constant.
	final boolean a;
	a = false;
	while (a) {
	}

	// b is a compile time constant.
	final boolean b = false;
	// while (b){} // Compiler detects unreachable code
	do {
	} while (b); // This is OK.
    }
}

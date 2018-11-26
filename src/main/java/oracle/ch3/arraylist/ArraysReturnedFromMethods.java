package oracle.ch3.arraylist;

/**
 *
 * @author jev
 * @since Nov 19, 2018
 */
public class ArraysReturnedFromMethods {

    public static int[] getNullRef() {
	return null;
    }

    public static String[] getValues() {
	// System.out.println("getValues");
	String[] arr = {"q ", "w ", "e ", "r ", "t ", "y."};
	return arr;
    }

    public static void main(String[] args) {

	int index = 4;
	try {
	    getNullRef()[index = 1]--; // postfix decrement element 1 of a null ref, throws npe
	} catch (final NullPointerException e) {
	}

	for (int i = 0; i < 6; i++)
	    System.out.print(getValues()[i]); // Executes getvalues each time.
    }
}

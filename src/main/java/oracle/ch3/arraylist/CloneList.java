package oracle.ch3.arraylist;

import java.util.ArrayList;

/**
 *
 * @author Jev
 */
public class CloneList {

    private static class Counter {

	int count;

	Counter(int count) {
	    this.count = count;
	}

	@Override
	public String toString() {
	    return "Counter-" + count;
	}
    }

    /**
     * See {@link ArrayList#clone()}
     *
     * @param args
     */
    public static void main(final String[] args) {
	final ArrayList<Counter> original = new ArrayList<>();
	original.add(new Counter(10));

	// final Object clone = original.clone();
	// Since .clone() returns type Object, the following line is valid but raises 
	// a complication warning: unchecked cast when using -Xlint:unchecked.
	// ArrayList<Counter> cloned = (ArrayList<Counter>) original.clone();
	final ArrayList<Counter> cloned = new ArrayList<>(original); // Solution is to create a new ArrayList.
	cloned.get(0).count = 5;

	System.out.println(original);
    }
}

package oracle.ch4.methods_and_encapsulation.lambdas;

import java.util.Arrays;
import java.util.List;

public class UsingFunctionalInterfaces {

    @FunctionalInterface
    private static interface I {

	void execute();
    }

    private static class I_Impl implements I {

	@Override
	public void execute() {
	    System.out.println("I Impl - inner class");
	}
    }

    @FunctionalInterface
    private static interface I_WithParam {

	void execute(int i);
    }

    public UsingFunctionalInterfaces() {
    }

    /**
     * Runs execute on an instance of I.
     *
     * @param i
     */
    private static void execute(I i) {
	i.execute();
    }

    /**
     * Run execute on a list of I
     *
     * @param i
     */
    private static void execute(final List<I> i) {
	i.forEach(I::execute);
    }

    /**
     * Run execute on a list of I
     *
     * @param i
     */
    private static void execute(final I... i) {
	// https://mlangc.wordpress.com/2010/05/01/be-carefull-when-converting-java-arrays-to-lists/
	execute(Arrays.asList(i));

	// Or
	for (final I i1 : i) {
	    i1.execute();
	}
    }

    public static void main(String[] args) {

	// Inner class
	final I i1 = new I_Impl();
	i1.execute();

	// Create and execute annonymous class.
	final I i2 = new I() {
	    @Override
	    public void execute() {
		System.out.println("annonymous class");
	    }
	};
	i2.execute();

	// Lambda syntax
	final I i3 = () -> {
	    System.out.println("lambda");
	};
	i3.execute();

	// Delegate execution of the interface to another method
	execute(i1);
	execute(i2);
	execute(i3);
	execute(new I() {
	    @Override
	    public void execute() {
		System.out.println("annonymous class");
	    }
	});
	execute(() -> {
	    System.out.println("lambda");
	});
	// Run execute on each element of alist of I
	Arrays.asList(i1, i2, i3).forEach(I::execute);
	final List<I> list = Arrays.asList(i1, i2, i3);
	execute(list);
	final I[] arr = new I[]{i1, i2, i3};
	execute(arr);

	final I_WithParam i4 = (final int i) -> {
	    System.out.println("lambda: " + i);
	};
	i4.execute(1);
    }
}

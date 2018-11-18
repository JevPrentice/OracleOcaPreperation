package code.examples.encapsulation;

import org.junit.Test;

/**
 * A static method is not overridden the same as a normal method, rather
 *
 * @author jev
 * @since Sep 11, 2018
 */
public class HiddenMethods {

    private static class StaticHiddenMethod {

	static class Marsupial_1 {

	    public static boolean isBiped() {
		return false;
	    }

	    /**
	     * When this method {@link Marsupial_1#getMarsupialDescription} is called then
	     * {@link Marsupial_1#isBiped} will be used during runtime.
	     */
	    public void getMarsupialDescription() {
		System.out.println("Marsupial1 walks on two legs: " + isBiped());
		System.out.println("Marsupial1 uses parent static isBiped: " + this.getClass().getName());
	    }
	}

	static class Kangaroo_1 extends Marsupial_1 {

	    public static boolean isBiped() {
		return true;
	    }

	    /**
	     * When this method {@link Kangaroo_1#getKangarooDescription} is called then
	     * {@link Kangaroo_1#isBiped} will be used during runtime, because Kangaroo_1 is hiding
	     * {@link Marsupial_1#isBiped}
	     */
	    public void getKangarooDescription() {
		System.out.println("Kangaroo1 hops on two legs: " + isBiped());
		System.out.println("Kangaroo_1 uses child static isBiped: " + this.getClass().getName());
	    }
	}

    }

    /**
     * If an object is an instance of Kangaroo_2 then a call to either {@link Marsupial_2#getMarsupialDescription()} or
     * {@link Kangaroo_2#getKangarooDescription()} will use {@link Kangaroo_2#isBiped()} using normal Java
     * https://docs.oracle.com/javase/tutorial/java/IandI/polymorphism.html
     */
    private static class OverriddenMethod {

	static class Marsupial_2 {

	    public boolean isBiped() {
		return false;
	    }

	    public void getMarsupialDescription() {
		System.out.println("Marsupial2 walks on two legs: " + isBiped());
		System.out.println("Marsupial2 uses overridden child isBiped: " + this.getClass().getName());
	    }
	}

	static class Kangaroo_2 extends Marsupial_2 {

	    // Here both times this implementation is used
	    // because this method overrides parent and joey_2 is of type Kangaroo_2 
	    @Override
	    public boolean isBiped() {
		return true;
	    }

	    public void getKangarooDescription() {
		System.out.println("Kangaroo2 hops on two legs: " + isBiped());
		System.out.println("Kangaroo2 uses overridden child isBiped: " + this.getClass().getName());
	    }
	}
    }

    public HiddenMethods() {
    }

    /**
     * These two Kangaroos spaced in different classes to make the example clearer to read.
     */
    @Test
    public void test() {
	final StaticHiddenMethod.Kangaroo_1 k1 = new StaticHiddenMethod.Kangaroo_1();
	k1.getMarsupialDescription();
	k1.getKangarooDescription();

	final OverriddenMethod.Kangaroo_2 k2 = new OverriddenMethod.Kangaroo_2();
	k2.getMarsupialDescription();
	k2.getKangarooDescription();
    }
}

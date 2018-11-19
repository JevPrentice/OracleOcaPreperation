package oracle.ch4.methods_and_encapsulation;

/**
 *
 * @author jev
 */
public class MethodBody {

    public void walk1() {
    }

    //public void walk2; // DOES NOT COMPILE (no body)
    public void walk3(int a) {
	int name = 5;
    }

    private static interface I {

	void m1();

	default void m2() {

	}

	static void m3() {

	}
    }

    private static abstract class A implements I {

	public A() {
	}

	// Override normal method.
	@Override
	public void m1() {
	}

	// Override default interface method.
	@Override
	public void m2() {
	    I.super.m2();
	}

	// Hidden, not overridden
	static void m3() {
	    I.m3();
	}
    }
}

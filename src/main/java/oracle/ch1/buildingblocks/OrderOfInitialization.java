package oracle.ch1.buildingblocks;

/**
 *
 * @author Jev
 */
public class OrderOfInitialization {

    private static class C {

	static int NUM = 1;

	static {
	    System.out.println("static block 1 " + NUM);
	    NUM = 10;
	}

	{
	    System.out.println("instance block 1");
	}

	public C() {
	    System.out.println("Inside constructor");
	}

	{
	    System.out.println("instance block 2");
	}

	static {
	    System.out.println("static block 2 " + NUM);
	}
    }

    private static class C2 {

	static Double d; // refs null
	int i = d.intValue(); // Throws a null pointer when C2 is init, since d is null.

	public static void main(final String[] args) {
	    System.out.println("C2 main"); // Static main method can be run without a problem
	}
    }

    public static void main(String[] args) {
	System.out.println("In main");

	C c1 = new C();
	C c2 = new C();

	C2.main(null); // OK - C2 does not get init
	String error = "";
	try {
	    C2 c3 = new C2(); // npe trying to access intValue of null ref.
	} catch (java.lang.NullPointerException e) {
	}
    }
}

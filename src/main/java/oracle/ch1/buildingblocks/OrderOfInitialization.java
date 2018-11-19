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

    public static void main(String[] args) {
	System.out.println("In main");

	C c1 = new C();
	C c2 = new C();
    }
}

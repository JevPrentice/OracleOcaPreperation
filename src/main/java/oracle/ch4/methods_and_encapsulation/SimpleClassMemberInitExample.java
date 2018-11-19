package oracle.ch4.methods_and_encapsulation;

/**
 *
 * @author jev
 */
class InitializationOrderSimple {

    private String string = "value";

    {
	System.out.println(string);
    }

    private static int COUNT = 0;

    static {
	System.out.println(COUNT);
    }

    static {
	COUNT += 10;
	System.out.println(COUNT);
    }

    public InitializationOrderSimple() {
	System.out.println("InitializationOrderSimple constructor");
    }
}

public class SimpleClassMemberInitExample {

    // Guess the output.
    public static void main(String[] args) {
	System.out.println("SimpleClassMemberInitExample main");
	final InitializationOrderSimple initializationOrderSimple = new InitializationOrderSimple();
	// Init code blocks executes without the initializationOrderSimple variable being used.
    }
}

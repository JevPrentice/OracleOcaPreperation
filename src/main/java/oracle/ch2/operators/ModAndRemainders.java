package oracle.ch2.operators;

/**
 * https://en.wikipedia.org/wiki/Modulo_operation
 *
 * @author Jev
 */
public class ModAndRemainders {

    private int classMember;
    private static int staticClassMember;

    /**
     * These are all valid ways to ref class members.
     */
    public void method() {
	ModAndRemainders.this.classMember = 1;
	this.classMember = 1;
	classMember = 1;

	ModAndRemainders.staticClassMember = 1;
	ModAndRemainders.this.staticClassMember = 1;
	this.staticClassMember = 1;
	staticClassMember = 1;
    }

    public static void main(final String args[]) throws InterruptedException {

	int i = 49;
	int j = 26;

	System.out.println("i: " + i);
	System.out.println("j: " + j);

	int k = i % j;
	System.out.println("i%j: " + k); // 49 - 26 = 23

	System.out.println(49 % 26);
	System.out.println(23 % 5);
	System.out.println(3 % 1);

    }
}

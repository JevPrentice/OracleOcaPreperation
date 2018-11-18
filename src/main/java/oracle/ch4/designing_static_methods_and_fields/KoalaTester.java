package oracle.ch4.designing_static_methods_and_fields;

/**
 * In addition to main() methods, static methods have two main purposes: -For
 * utility or helper methods that don’t require any object state. Since there is
 * no need to access instance variables, having static methods eliminates the
 * need for the caller to instantiate the object just to call the method.
 *
 * - For state that is shared by all instances of a class, like a counter. All
 * instances must share the same state. Methods that merely use that state
 * should be static as well.
 *
 * @author jev
 */
public class KoalaTester {

    public static void main(String[] args) {
	Koala.main(new String[0]); // call static method - main() can be called just like any other static method.

	System.out.println(Koala.count);

	Koala.main(new String[0]);

	Koala k = new Koala();
	System.out.println(k.count);

	k = null;
	System.out.println(k.count); // k is a Koala and count is a static variable, so it reads that static variable, 
	// this is OK even though k is null.

	Koala.count = 4;
	Koala koala1 = new Koala();
	Koala koala2 = new Koala();
	koala1.count = 6;
	koala2.count = 5;
	System.out.println(Koala.count); // OUTPUT IS 5 NOT 6
    }

}

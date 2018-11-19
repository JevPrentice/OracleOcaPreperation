package oracle.ch4.designing_static_methods_and_fields;

/**
 * A static method or instance method can call a static method because static
 * methods don’t require an object to use. Only an instance method can call
 * another instance method on the same class without using a reference variable,
 * because instance methods do require an object. Similar logic applies for the
 * instance and static variables
 *
 * @author jev
 */
public class Static {

    private String name = "Static class";

    public static void first() {
    }

    public static void second() {
    }

    public void third() {
	System.out.println(name);
    }

    public static void main(String args[]) {
	first();
	second();
	//third(); // DOES NOT COMPILE - third is not static.

    }
}

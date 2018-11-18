package oracle.ch4.methods_and_encapsulation;

/**
 *
 * @author jev
 */
public class MethodName {

    /**
     * walk1() is a valid method declaration with a traditional name.
     */
    public void walk1() {
    }

    /**
     * 2walk() doesn't compile because identi ers are not allowed to begin with numbers.
     */
    //public void 2walk() { } // DOES NOT COMPILE
    /**
     * walk3() doesn't compile because the method name is before the return type.
     */
    //public walk3 void() { } // DOES NOT COMPILE
    /**
     * Walk_$() is a valid method declaration.
     */
    public void Walk_$() {
    }

    /**
     * The method name is missing.
     */
    //public void() { } // DOES NOT COMPILE
    /**
     * Single dollar is legal.
     */
    public void $() {
    }
}

package oracle.ch4.methods_and_encapsulation;

/**
 *
 * @author jev
 */
public class FunctionSignatures {

    public final void nap(int minutes) throws InterruptedException {
	// take a nap
    }

    /*
     * - public The method can be called from any class
     * - private The method can only be called from within the same class.
     * - protected The method can only be called from classes in the same package or subclasses
     * - Default (Package Private) Access The method can only be called from classes in the same package.
     *          there is no keyword for default access. You simply omit the access modifier
     *              default keyword is for switch statement
     */
    public void walk1() {
    }

    //default void walk2() {} // DOES NOT COMPILE
    //void public walk3() {} // DOES NOT COMPILE
    void walk4() {
    }

}
